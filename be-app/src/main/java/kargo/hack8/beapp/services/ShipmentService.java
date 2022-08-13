package kargo.hack8.beapp.services;

import kargo.hack8.beapp.models.entities.Shipment;
import kargo.hack8.beapp.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public Shipment create(Shipment product){
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        String shipmentNumber = "DO - " + number;
        product.setShipmentNumber(shipmentNumber);
        return shipmentRepository.save(product);
    }

    public Shipment findById(Long id){
        Optional<Shipment> product = shipmentRepository.findById(id);
        return product.orElse(null);
    }

    public Iterable<Shipment> findAll() {
        return shipmentRepository.findAll();
    }
}
