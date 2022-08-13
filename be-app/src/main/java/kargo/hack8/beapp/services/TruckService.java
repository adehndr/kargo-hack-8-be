package kargo.hack8.beapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kargo.hack8.beapp.models.entities.Truck;
import kargo.hack8.beapp.repository.TruckRepository;

@Service
@Transactional
public class TruckService {
    
    @Autowired
    private TruckRepository truckRepository;

    public Iterable<Truck> findAll() {
        return truckRepository.findAll();
    }

}
