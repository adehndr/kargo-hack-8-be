package kargo.hack8.beapp.services;

import java.util.Optional;

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

    public Truck findById(Long id){
        Optional<Truck> truckFounded = truckRepository.findById(id);
        if (!truckFounded.isPresent()) {
            return null;
        }
        return truckFounded.get();
    }

    public Truck create(Truck truck){
        return truckRepository.save(truck);
    }

    public void delete(Long id){
        truckRepository.deleteById(id);
    }
}
