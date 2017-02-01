package com.allstate.entities;

import com.allstate.enums.WasSuccessfull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "trips")
@Data
public class Trip {
    private int id;
    private int version;
    private Date startedAt;
    private Date endedAt;
    private int duration;
    private City city;
    private Driver driver;
    private Passenger passenger;
    private Car car;
    private double tripDistance;
    private double travelCost;
    private double tipPercent;
    private double totalCost;
    private WasSuccessfull wasSuccessfull;
    private Date created;
    private Date modified;

    public Trip() {
    }

    public Trip(double tripDistance, WasSuccessfull wasSuccessfull) {
        this.tripDistance = tripDistance;
        this.wasSuccessfull = wasSuccessfull;
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

    @Column(columnDefinition = "ENUM('M', 'F')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public WasSuccessfull getWasSuccessfull() {
        return wasSuccessfull;
    }

    public void setWasSuccessfull(WasSuccessfull wasSuccessfull) {
        this.wasSuccessfull = wasSuccessfull;
    }

    public Date getStartedAt() {
        return startedAt;
    }

    @CreationTimestamp
    public void setStartedAt(Date startedAt) {
        this.startedAt = startedAt;
    }

    public Date getEndedAt() {
        return endedAt;
    }

    @CreationTimestamp
    public void setEndedAt(Date endedAt) {
        this.endedAt = endedAt;
    }

    @OneToOne
    @JoinColumn(name="city_id1")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @OneToOne
    @JoinColumn(name="driver_id1")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @OneToOne
    @JoinColumn(name="passenger_id1")
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @OneToOne
    @JoinColumn(name="car_id1")
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
