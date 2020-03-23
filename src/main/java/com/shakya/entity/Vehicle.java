package com.shakya.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Vehicle {

    @Id
    private String vin;
    private Timestamp lastServiceDate;
    private String make;
    private String model;
    private int year;
    private float redLineRpm;
    private float maxFuelVolume;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Timestamp getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Timestamp lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRedLineRpm() {
        return redLineRpm;
    }

    public void setRedLineRpm(float redLineRpm) {
        this.redLineRpm = redLineRpm;
    }

    public float getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(float maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", lastServiceDate=" + lastServiceDate +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redLineRpm=" + redLineRpm +
                ", maxFuelVolume=" + maxFuelVolume +
                '}';
    }
}
