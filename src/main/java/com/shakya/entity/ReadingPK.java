package com.shakya.entity;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class ReadingPK implements Serializable{
    private String vin;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
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
