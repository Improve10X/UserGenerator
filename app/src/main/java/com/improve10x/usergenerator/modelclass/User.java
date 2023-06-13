package com.improve10x.usergenerator.modelclass;

import com.google.gson.annotations.SerializedName;

public class User {

//    @SerializedName("_id")
//    private String id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getIncomeUsd() {
        return incomeUsd;
    }

    public void setIncomeUsd(Integer incomeUsd) {
        this.incomeUsd = incomeUsd;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public Boolean getMarried() {
        return married;
    }

    public void setMarried(Boolean married) {
        this.married = married;
    }

    public Boolean getHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(Boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Boolean getHasDegree() {
        return hasDegree;
    }

    public void setHasDegree(Boolean hasDegree) {
        this.hasDegree = hasDegree;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Float getPoliticalLeaning() {
        return politicalLeaning;
    }

    public void setPoliticalLeaning(Float politicalLeaning) {
        this.politicalLeaning = politicalLeaning;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public Float getGpa() {
        return gpa;
    }

    public void setGpa(Float gpa) {
        this.gpa = gpa;
    }
}

