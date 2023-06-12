package com.improve10x.usergenerator.model;

public class User {
    private String name;
    private Integer age;
    private String job;
    private Integer incomeUSD;
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
    private String username;
    private Float politicalLeaning;
    private String religion;
    private Address address;
    private String doB;
    private Float gpa;

    public User() {
    }

    public User(String name, Integer age, String job, Integer incomeUSD, Integer creditScore,
                String ccNumber, Boolean married, Boolean hasChildren, Integer height, Float weight,
                String eyeColor, String email, String gender, Boolean hasDegree, String bloodType,
                String username, Float politicalLeaning, String religion, Address address, String doB,
                Float gpa) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.incomeUSD = incomeUSD;
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
        this.username = username;
        this.politicalLeaning = politicalLeaning;
        this.religion = religion;
        this.address = address;
        this.doB = doB;
        this.gpa = gpa;
    }
}

//{
//    "name": "Ying Cronin",
//    "age": 31,
//    "job": "Occupational Therapy Aide",
//    "incomeUSD": 42427,
//    "creditScore": 626,
//    "ccNumber": "6011-9024-8671-7581",
//    "married": true,
//    "hasChildren": true,
//    "height": 150,
//    "weight": 60.6,
//    "eyeColor": "BROWN",
//    "email": "yingcronin@outlook.com",
//    "gender": "Female",
//    "hasDegree": false,
//    "bloodType": "AB+",
//    "username": "ying29",
//    "politicalLeaning": -0.4,
//    "religion": "Christianity",
//    "address": {
//      "streetAddress": "142 Ted Greens",
//      "city": "Beirut",
//      "state": "Nabatîyé",
//      "country": "Lebanon",
//      "zip": "1161",
//      "geonameId": 278832,
//      "phoneNumber": "+961 83182898",
//      "ipAddress": "102.195.45.179"
//    },
//    "doB": "Sat Dec 26 09:53:27 UTC 1992",
//    "gpa": 3
//  },
