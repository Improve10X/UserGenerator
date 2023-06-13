package com.improve10x.usergenerator.modelclass;

import com.google.gson.annotations.SerializedName;

public class User {

    private String name;
    private Integer age;
    private String job;
    @SerializedName("incomeUSD")
    private Integer incomeUsd;
    private Integer creditScore;
    private String ccNumber;
    private Boolean married;
    private Boolean hasChildren;
    private Integer height;
    private Float weight;
    private String eyeColor;
    private String email;
    private String gender;
    private Boolean hasDegree;
    private String bloodType;
    @SerializedName("username")
    private String userName;
    private Float politicalLeaning;
    private String religion;
    @SerializedName("doB")
    private String dOB;
    private Float gpa;
}

