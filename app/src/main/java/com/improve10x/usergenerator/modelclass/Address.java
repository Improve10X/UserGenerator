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
}

