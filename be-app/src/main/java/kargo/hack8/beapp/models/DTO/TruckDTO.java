package kargo.hack8.beapp.models.DTO;

public class TruckDTO {

    private String truckLicenseNumber;
    private String truckType;
    private String truckPlateType;
    private Long truckProductionYear; 
    private Boolean status;
    private Long attachmentIdSTNK;
    private Long attachmentIdKIR;

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
