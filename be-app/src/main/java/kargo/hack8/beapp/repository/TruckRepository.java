package kargo.hack8.beapp.repository;

import org.springframework.data.repository.CrudRepository;

import kargo.hack8.beapp.models.entities.Truck;


public interface TruckRepository extends CrudRepository<Truck,Long>{
    
}
