package com.shakya.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class VehiclePK implements Serializable {

    private String vin;
    private Timestamp lastServiceDate;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VehiclePK)) return false;
        VehiclePK vehiclePK = (VehiclePK) o;
        return Objects.equals(getVin(), vehiclePK.getVin()) &&
                Objects.equals(getLastServiceDate(), vehiclePK.getLastServiceDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin(), getLastServiceDate());
    }
}
