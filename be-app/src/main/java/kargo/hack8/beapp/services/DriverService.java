package kargo.hack8.beapp.services;

import java.sql.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kargo.hack8.beapp.models.entities.Driver;
import kargo.hack8.beapp.repository.DriverRepository;

@Service
@Transactional
public class DriverService {
    @Autowired
    private DriverRepository driverRepository;

    public Iterable<Driver> findAll(){
        return driverRepository.findAll();
    }

    public Driver create(Driver driver){
        return driverRepository.save(driver);
    }

    public Driver findById(Long id){
        Optional<Driver> driverFounded = driverRepository.findById(id);
        if (!driverFounded.isPresent()) {
            return null;
        }
        return driverFounded.get();
    }
}
