package com.sci.models;

public class Location {
    private int locationId;
    private String streetAddress;
    private int postalCode;
    private String city;
    private String stateProvince;
    private String countryId;
    public int getLocationId() {
        return locationId;
    }
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public int getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateProvince() {
        return stateProvince;
    }
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }
    public String getCountryId() {
        return countryId;
    }
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
    @Override
    public String toString() {
        return "Location [city=" + city + ", countryId=" + countryId + ", locationId=" + locationId + ", postalCode="
                + postalCode + ", stateProvince=" + stateProvince + ", streetAddress=" + streetAddress + "]";
    }
    
}