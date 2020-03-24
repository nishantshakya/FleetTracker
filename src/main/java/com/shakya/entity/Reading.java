package com.shakya.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.shakya.views.Views;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@IdClass(ReadingPK.class)
@Entity
public class Reading {

    @Id
    @JsonView(Views.Location.class)
    private String vin;
    @Id
    @JsonView(Views.Location.class)
    private Timestamp timestamp;

    @JsonView(Views.Location.class)
    private BigDecimal latitude;

    @JsonView(Views.Location.class)
    private BigDecimal longitude;

    @JsonView(Views.Alerts.class)
    private float fuelVolume;
    private float speed;

    @JsonView(Views.Alerts.class)
    private float engineHp;

    @JsonView(Views.Alerts.class)
    private boolean checkEngineLightOn;

    @JsonView(Views.Alerts.class)
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;

    @JsonView(Views.Alerts.class)
    private float engineRpm;
    @Embedded
    private Tire tires;

    @JsonIgnore
    private boolean hasAlerts;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonView(Views.Alerts.class)
    private List<Alert> alerts;

    public Reading() {
    }


//    public Reading(ReadingPK readingPK, BigDecimal latitude, BigDecimal longitude,float fuelVolume, float speed,
//                   float engineHp, boolean checkEngineLightOn, boolean engineCoolantLow, boolean cruiseControlOn,
//                   float engineRpm, Tire tires){
//        System.out.println("not default");
//        this.readingPK = readingPK;
//        this.latitude = latitude;
//        this.longitude = longitude;
//        this.fuelVolume = fuelVolume;
//        this.speed = speed;
//        this.engineHp = engineHp;
//        this.checkEngineLightOn = checkEngineLightOn;
//        this.engineCoolantLow = engineCoolantLow;
//        this.cruiseControlOn = cruiseControlOn;
//        this.engineRpm = engineRpm;
//        this.tires = tires;
//    }
    public List<Alert> getAlerts() {
        return alerts;
    }

    public boolean isHasAlerts() {
        return hasAlerts;
    }

    public void setHasAlerts(boolean hasAlerts) {
        this.hasAlerts = hasAlerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public float getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(float fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(float engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public float getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(float engineRpm) {
        this.engineRpm = engineRpm;
    }

    public Tire getTires() {
        return tires;
    }

    public void setTires(Tire tires) {
        this.tires = tires;
    }

//    public ReadingPK getReadingPK() {
//        return readingPK;
//    }
//
//    public void setReadingPK(ReadingPK readingPK) {
//        this.readingPK = readingPK;
//    }


    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "vin='" + vin + '\'' +
                ", timestamp=" + timestamp +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", fuelVolume=" + fuelVolume +
                ", speed=" + speed +
                ", engineHp=" + engineHp +
                ", checkEngineLightOn=" + checkEngineLightOn +
                ", engineCoolantLow=" + engineCoolantLow +
                ", cruiseControlOn=" + cruiseControlOn +
                ", engineRpm=" + engineRpm +
                ", tires=" + tires +
                ", hasAlerts=" + hasAlerts +
                ", alerts=" + alerts +
                '}';
    }
}
