package com.allstate.entities;

import com.allstate.enums.CarType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cars")
@Data
public class Car {

    private int id;
    private int version;
    private String name;
    private CarType type;
    private String make;
    private String model;
    private int year;
    private Driver driver;
    private Date created;
    private Date modified;


    public Car() {
    }

    public Car(String name, CarType type, String make, String model, int year) {
        this.name = name;
        this.type = type;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }


    @Column(columnDefinition = "ENUM('LUX', 'BASIC')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }

    @ManyToOne
    @JoinColumn(name="driver_id")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
