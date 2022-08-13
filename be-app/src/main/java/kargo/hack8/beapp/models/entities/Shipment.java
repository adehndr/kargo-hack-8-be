package kargo.hack8.beapp.models.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Date;

@Entity
@Table(name = "tbl_shipment")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "shipment_number")
    private String shipmentNumber;

    @Column(name = "id_truck")
    private Long idTruck;

    @Column(name = "id_driver")
    private Long idDriver;

    @NotNull
    @Column(name = "origin")
    private String origin;

    @NotNull
    @Column(name = "destination")
    private String destination;

    @NotNull
    @Column(name="loading_date")
    private Date loadingDate;

    @NotNull
    @Column(name="status")
    private String status;

    public Shipment(Long id, String shipmentNumber, Long idTruck, Long idDriver,
                    String origin, String destination, Date loadingDate, String status) {
        this.id = id;
        this.shipmentNumber = shipmentNumber;
        this.idTruck = idTruck;
        this.idDriver = idDriver;
        this.origin = origin;
        this.destination = destination;
        this.loadingDate = loadingDate;
        this.status = status;
    }

    public Shipment() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getLoadingDate() {
        return loadingDate;
    }

    public void setLoadingDate(Date loadingDate) {
        this.loadingDate = loadingDate;
    }
}
