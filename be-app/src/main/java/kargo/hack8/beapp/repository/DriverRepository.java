package kargo.hack8.beapp.repository;

import kargo.hack8.beapp.models.entities.Driver;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DriverRepository extends CrudRepository<Driver, Long>{
    List<Driver> findByStatus(Boolean status);
}
