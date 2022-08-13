package kargo.hack8.beapp.services;

import kargo.hack8.beapp.models.DTO.ResponseData;
import kargo.hack8.beapp.models.DTO.GetShipmentDTO;
import kargo.hack8.beapp.models.entities.Driver;
import kargo.hack8.beapp.models.entities.Shipment;
import kargo.hack8.beapp.models.entities.Truck;
import kargo.hack8.beapp.repository.DriverRepository;
import kargo.hack8.beapp.repository.ShipmentRepository;
import kargo.hack8.beapp.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class ShipmentService {

    private final List<String> STATUS = Arrays.asList(
        "Created",
        "Allocated",
        "Ongoing to Origin",
        "At Origin",
        "Ongoing to Destination",
        "At Destination",
        "Completed"
    );

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private TruckRepository truckRepository;

    @Autowired
    private DriverRepository driverRepository;

    public ResponseData<GetShipmentDTO> create(Shipment shipment){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        String shipmentNumber = "DO - " + number;
        shipment.setShipmentNumber(shipmentNumber);
        Shipment shipmentResponse = shipmentRepository.save(shipment);

        ResponseData<GetShipmentDTO> response = new ResponseData<>();
        response.setMessages("Success create shipment data");
        response.setPayload(generateGetDTOFromShipment(shipmentResponse));
        response.setStatus(HttpStatus.OK);
        return response;
    }

    public ResponseData<GetShipmentDTO> findById(Long id){
        Optional<Shipment> shipment = shipmentRepository.findById(id);

        ResponseData<GetShipmentDTO> response = new ResponseData<>();
        if(shipment.isPresent()) {
            response.setMessages("Success find shipment by id data");
            response.setPayload(generateGetDTOFromShipment(shipment.get()));
            response.setStatus(HttpStatus.OK);
            return response;
        }
        response.setMessages("Failed find shipment by id: " + id + " (data not found)");
        response.setPayload(null);
        response.setStatus(HttpStatus.BAD_REQUEST);
        return response;
    }

    public ResponseData<List<GetShipmentDTO>> findAll() {
        List<GetShipmentDTO> getShipmentDTOList = new ArrayList<>();
        Iterable<Shipment> shipmentList = shipmentRepository.findAll();
        for(Shipment shipment : shipmentList) {
            getShipmentDTOList.add(generateGetDTOFromShipment(shipment));
        }
        ResponseData<List<GetShipmentDTO>> response = new ResponseData<>();
        response.setMessages("Success find " + getShipmentDTOList.toArray().length
                + " shipment data");
        response.setPayload(getShipmentDTOList);
        response.setStatus(HttpStatus.OK);
        return response;
    }

    public ResponseData<GetShipmentDTO> update(Shipment shipment) {
        ResponseData<GetShipmentDTO> response = new ResponseData<>();
        if (!STATUS.contains(shipment.getStatus())){
            response.setMessages("Failed update shipment data (invalid status : "
                    + shipment.getStatus() + ")");
            response.setPayload(generateGetDTOFromShipment(shipment));
            response.setStatus(HttpStatus.BAD_REQUEST);
            return response;
        }
        Shipment shipmentResponse = shipmentRepository.save(shipment);
        response.setMessages("Success update shipment data");
        response.setPayload(generateGetDTOFromShipment(shipmentResponse));
        response.setStatus(HttpStatus.OK);
        return response;
    }

    private GetShipmentDTO generateGetDTOFromShipment (Shipment shipment) {
        GetShipmentDTO getShipmentDTO = new GetShipmentDTO();
        getShipmentDTO.setId(shipment.getId());
        getShipmentDTO.setShipmentNumber(shipment.getShipmentNumber());
        getShipmentDTO.setDestination(shipment.getDestination());
        getShipmentDTO.setOrigin(shipment.getOrigin());
        getShipmentDTO.setLoadingDate(shipment.getLoadingDate());
        getShipmentDTO.setStatus(shipment.getStatus());

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
