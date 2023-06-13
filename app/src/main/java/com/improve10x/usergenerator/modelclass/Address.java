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
}

