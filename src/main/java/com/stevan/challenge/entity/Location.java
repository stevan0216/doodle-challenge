package com.stevan.challenge.entity;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_location")
    private String idLocation;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "country_code")
    private String countryCode;

    public Location() {}

    public Location(String idLocation, String name, String address, String countryCode) {
        this.idLocation = idLocation;
        this.name = name;
        this.address = address;
        this.countryCode = countryCode;
    }

    public String getIdLocation() { return idLocation; }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
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
