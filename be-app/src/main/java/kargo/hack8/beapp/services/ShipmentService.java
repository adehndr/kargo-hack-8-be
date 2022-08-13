package kargo.hack8.beapp.services;

import kargo.hack8.beapp.models.dto.GetShipmentDTO;
import kargo.hack8.beapp.models.entities.Driver;
import kargo.hack8.beapp.models.entities.Shipment;
import kargo.hack8.beapp.models.entities.Truck;
import kargo.hack8.beapp.repository.DriverRepository;
import kargo.hack8.beapp.repository.ShipmentRepository;
import kargo.hack8.beapp.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private DriverRepository driverRepository;

    public GetShipmentDTO create(Shipment shipment){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        String shipmentNumber = "DO - " + number;
        shipment.setShipmentNumber(shipmentNumber);
        Shipment response = shipmentRepository.save(shipment);
        return generateGetDTOFromShipment(response);
    }

    public GetShipmentDTO findById(Long id){
        Optional<Shipment> product = shipmentRepository.findById(id);

        if(product.isEmpty()) {
            return generateGetDTOFromShipment(product.get());
        }
        return null;
    }

    public List<GetShipmentDTO> findAll() {
        List<GetShipmentDTO> response = new ArrayList<>();
        Iterable<Shipment> shipmentList = shipmentRepository.findAll();
        for(Shipment shipment : shipmentList) {
            response.add(generateGetDTOFromShipment(shipment));
        }
        return response;
    }

    public GetShipmentDTO update(Shipment shipment) {
        Shipment response = shipmentRepository.save(shipment);
        return generateGetDTOFromShipment(response);
    }

    private GetShipmentDTO generateGetDTOFromShipment (Shipment shipment) {
        GetShipmentDTO getShipmentDTO = new GetShipmentDTO();
        getShipmentDTO.setId(shipment.getId());
        getShipmentDTO.setShipmentNumber(shipment.getShipmentNumber());
        getShipmentDTO.setDestination(shipment.getDestination());
        getShipmentDTO.setOrigin(shipment.getOrigin());
        getShipmentDTO.setLoadingDate(shipment.getLoadingDate());

        if (shipment.getIdTruck() != null) {
            Optional<Truck> truck = truckRepository.findById(shipment.getIdTruck());
            getShipmentDTO.setTruck(truck.orElse(null));
        }

        if (shipment.getIdDriver() != null) {
            Optional<Driver> driver = driverRepository.findById(shipment.getIdDriver());
            getShipmentDTO.setDriver(driver.orElse(null));
        }

        return getShipmentDTO;
    }
}
