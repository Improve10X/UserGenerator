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
    private Address address;
    @SerializedName("doB")
    private String dOB;
    private Float gpa;

    public User() {

    }

    public User(String name, Integer age, String job, Integer incomeUsd, Integer creditScore, String ccNumber, Boolean married, Boolean hasChildren, Integer height, Float weight, String eyeColor, String email, String gender, Boolean hasDegree, String bloodType, String userName, Float politicalLeaning, String religion, Address address, String dOB, Float gpa) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.incomeUsd = incomeUsd;
        this.creditScore = creditScore;
        this.ccNumber = ccNumber;
        this.married = married;
        this.hasChildren = hasChildren;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.email = email;
        this.gender = gender;
        this.hasDegree = hasDegree;
        this.bloodType = bloodType;
        this.userName = userName;
        this.politicalLeaning = politicalLeaning;
        this.religion = religion;
        this.address = address;
        this.dOB = dOB;
        this.gpa = gpa;
    }
}

