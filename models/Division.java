package models;

public class Division {
    private int divisionId;
    private String divisionName;
    private int regionId;
    private String regionName;
    
    public String getRegionName() {
        return regionName;
    }
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    public int getDivisionId() {
        return divisionId;
    }
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }
    public String getDivisionName() {
        return divisionName;
    }
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }
    public int getRegionId() {
        return regionId;
    }
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
}
