package com.shakya.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.shakya.views.Views;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@JsonView(Views.Alerts.class)
@Entity
public class Alert {

    @Id
    @JsonIgnore
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
