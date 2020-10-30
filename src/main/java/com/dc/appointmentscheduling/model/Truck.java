package com.dc.appointmentscheduling.model;

import javax.persistence.*;

@Entity
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="truckId")
    private Integer truckId;


    @Column(name = "truckNumber")
    private String truckNumber;

    @Column(name = "truckName")
    private String truckName;

    @Column(name =  "truckType")
    private String truckType;

    @Column(name = "conestogaTrailers")
    private  String ConestogaTrailers;

    @Column(name = "refrigerateTrailers")
    private  String refrigerateTrailers;

    public Truck() {
    }

    public Truck(Integer truckId, String truckNumber, String truckName, String truckType, String conestogaTrailers, String refrigerateTrailers) {
        this.truckId = truckId;
        this.truckNumber = truckNumber;
        this.truckName = truckName;
        this.truckType = truckType;
        ConestogaTrailers = conestogaTrailers;
        this.refrigerateTrailers = refrigerateTrailers;
    }

    public Integer getTruckId() {
        return truckId;
    }

    public void setTruckId(Integer truckId) {
        this.truckId = truckId;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getTruckName() {
        return truckName;
    }

    public void setTruckName(String truckName) {
        this.truckName = truckName;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public String getConestogaTrailers() {
        return ConestogaTrailers;
    }

    public void setConestogaTrailers(String conestogaTrailers) {
        ConestogaTrailers = conestogaTrailers;
    }

    public String getRefrigerateTrailers() {
        return refrigerateTrailers;
    }

    public void setRefrigerateTrailers(String refrigerateTrailers) {
        this.refrigerateTrailers = refrigerateTrailers;
    }
}
