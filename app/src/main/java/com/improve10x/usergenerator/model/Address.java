package com.improve10x.usergenerator.model;

import com.google.gson.annotations.SerializedName;

public class Address {
    private String streetAddress;
    private String city;
    private String  state;
    private String country;
    private String zip;
    private Integer geonameId;
    private String phoneNumber;
    private String ipAddress;
    private String countryCode;

    public Address() {
    }

    public Address(String streetAddress, String city, String state, String country, String zip,
                   Integer geonameId, String phoneNumber, String ipAddress, String countryCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.geonameId = geonameId;
        this.phoneNumber = phoneNumber;
        this.ipAddress = ipAddress;
        this.countryCode = countryCode;
    }
}


//"streetAddress": "142 Ted Greens",
//      "city": "Beirut",
//      "state": "Nabatîyé",
//      "country": "Lebanon",
//      "zip": "1161",
//      "geonameId": 278832,
//      "phoneNumber": "+961 83182898",
//      "ipAddress": "102.195.45.179"