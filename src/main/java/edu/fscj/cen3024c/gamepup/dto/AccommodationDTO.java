package edu.fscj.cen3024c.gamepup.dto;

public class AccommodationDTO {

    private int accId;
    private String accType;
    private String accDesc;

    public AccommodationDTO() {
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccDesc() {
        return accDesc;
    }

    public void setAccDesc(String accDesc) {
        this.accDesc = accDesc;
    }
}
