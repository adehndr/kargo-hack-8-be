package kargo.hack8.beapp.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_trucks")
public class Truck {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "License number is required")
    @Column(name = "license_number")
    private String truckLicenseNumber;

    @NotEmpty(message = "Truck type is required")
    @Column(name = "type")
    private String truckType;

    @Column(name = "plate")
    private String truckPlateType;

    @NotEmpty(message = "Truck production year is required")
    @Column(name = "production_year")
    private Long truckProductionYear; 

    @Column(name="status")
    private String status;

}
