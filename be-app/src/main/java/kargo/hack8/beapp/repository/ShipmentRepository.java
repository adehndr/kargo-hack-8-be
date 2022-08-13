package kargo.hack8.beapp.repository;

import kargo.hack8.beapp.models.entities.Shipment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.websocket.server.PathParam;

public interface ShipmentRepository extends CrudRepository<Shipment,Long> {
    @Query("SELECT s FROM Shipment s WHERE s.id = :id")
    public Shipment findShipmentById(@PathParam("id") Long id);
}
