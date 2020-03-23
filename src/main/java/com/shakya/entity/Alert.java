package com.shakya.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Alert {

    @Id
    private String id;
    private Integer priority;
    private String description;

    public Alert(){
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                '}';
    }
}
