package com.stevan.challenge.dto;

import com.stevan.challenge.entity.Location;

import java.io.Serializable;

public class LocationDto implements Serializable {

    private String locationId;
    private String name;
    private String address;
    private String countryCode;

    public LocationDto(String locationId, String name, String address, String countryCode) {
        this.locationId = locationId;
        this.name = name;
        this.address = address;
        this.countryCode = countryCode;
    }

    public LocationDto(Location location) {
        this.locationId = location.getIdLocation();
        this.name = location.getName();
        this.address = location.getAddress();
        this.countryCode = location.getCountryCode();
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
