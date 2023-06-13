package com.improve10x.usergenerator.modelclass;

import com.google.gson.annotations.SerializedName;

public class Address {

    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private String zip;
    @SerializedName("geonameId")
    private Integer geoNameId;
    private String phoneNumber;
    private String ipAddress;
    private String countryCode;

    public Address() {

    }

    public Address(String streetAddress, String city, String state, String country, String zip, Integer geoNameId, String phoneNumber, String ipAddress, String countryCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.geoNameId = geoNameId;
        this.phoneNumber = phoneNumber;
        this.ipAddress = ipAddress;
        this.countryCode = countryCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Integer getGeoNameId() {
        return geoNameId;
    }

    public void setGeoNameId(Integer geoNameId) {
        this.geoNameId = geoNameId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}

