package kargo.hack8.beapp.repository;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kargo.hack8.beapp.models.entities.Truck;


public interface TruckRepository extends CrudRepository<Truck,Long>{
        
    List<Truck> findByStatus(Boolean status);
}
