package kargo.hack8.beapp.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_trucks")
public class Truck {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_number")
    private String truckLicenseNumber;

    @Column(name = "type")
    private String truckType;

    @Column(name = "plate",nullable = true)
    private String truckPlateType;

    @Column(name = "production_year",nullable = true)
    private Long truckProductionYear; 

    @Column(name="status",nullable = true)
    private Boolean status;

    @Column(name="id_attachment_STNK",nullable = true)
    private Long attachmentIdSTNK;

    @Column(name="id_attachment_KIR",nullable = true)
    private Long attachmentIdKIR;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTruckLicenseNumber() {
        return truckLicenseNumber;
    }

    public void setTruckLicenseNumber(String truckLicenseNumber) {
        this.truckLicenseNumber = truckLicenseNumber;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public String getTruckPlateType() {
        return truckPlateType;
    }

    public void setTruckPlateType(String truckPlateType) {
        this.truckPlateType = truckPlateType;
    }

    public Long getTruckProductionYear() {
        return truckProductionYear;
    }

    public void setTruckProductionYear(Long truckProductionYear) {
        this.truckProductionYear = truckProductionYear;
    }
    
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getAttachmentIdSTNK() {
        return attachmentIdSTNK;
    }

    public void setAttachmentIdSTNK(Long attachmentIdSTNK) {
        this.attachmentIdSTNK = attachmentIdSTNK;
    }

    public Long getAttachmentIdKIR() {
        return attachmentIdKIR;
    }

    public void setAttachmentIdKIR(Long attachmentIdKIR) {
        this.attachmentIdKIR = attachmentIdKIR;
    }
}
