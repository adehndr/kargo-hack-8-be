package kargo.hack8.beapp.models.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "tbl_shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shipment_number", nullable = false)
    private String shipmentNumber;

    //TODO refer to truck
    @Column(name = "id_truck")
    private Long idTruck;

    //TODO refer to driver
    @Column(name = "id_driver")
    private Long idDriver;

    @Column(name = "origin", nullable = false)
    private String origin;

    @Column(name = "destination", nullable = false)
    private String destination;

    @Column(name="loading_date")
    private Date loading_date;

    public Shipment(Long id, String shipmentNumber, Long idTruck, Long idDriver,
                    String origin, String destination, Date loading_date) {
        this.id = id;
        this.shipmentNumber = shipmentNumber;
        this.idTruck = idTruck;
        this.idDriver = idDriver;
        this.origin = origin;
        this.destination = destination;
        this.loading_date = loading_date;
    }

    public Shipment() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShipmentNumber() {
        return shipmentNumber;
    }

    public void setShipmentNumber(String shipmentNumber) {
        this.shipmentNumber = shipmentNumber;
    }

    public Long getIdTruck() {
        return idTruck;
    }

    public void setIdTruck(Long idTruck) {
        this.idTruck = idTruck;
    }

    public Long getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(Long idDriver) {
        this.idDriver = idDriver;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getLoading_date() {
        return loading_date;
    }

    public void setLoading_date(Date loading_date) {
        this.loading_date = loading_date;
    }
}
