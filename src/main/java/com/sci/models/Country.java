package com.sci.models;

public class Country {
    private String countryId;
    private String countryName;
    private int regionId;
    public String getCountryId() {
        return countryId;
    }
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public int getRegionId() {
        return regionId;
    }
    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }
    @Override
    public String toString() {
        return "countries [countryId=" + countryId + ", countryName=" + countryName + ", regionId=" + regionId + "]";
    }

}
