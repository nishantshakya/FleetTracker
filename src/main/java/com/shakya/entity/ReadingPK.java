package com.shakya.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Embeddable
public class ReadingPK implements Serializable{
    private String vin;
    private Timestamp timestamp;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReadingPK)) return false;
        ReadingPK pk = (ReadingPK) o;
        return Objects.equals(getVin(), pk.getVin()) &&
                Objects.equals(getTimestamp(), pk.getTimestamp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVin(), getTimestamp());
    }

}
