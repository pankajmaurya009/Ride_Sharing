package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cities")
@Data
public class City {

    private int id;
    private int version;
    private String name;
    private String state;
    private boolean isNight;
    private Double dayRatePerKm;
    private Double nightRatePerKm;
    private List<Driver> drivers;
    private Date created;
    private Date modified;


    public City() {
    }

    public City(String name, String state, boolean isNight, Double dayRatePerKm, Double nightRatePerKm) {
        this.name = name;
        this.state = state;
        this.isNight = isNight;
        this.dayRatePerKm = dayRatePerKm;
        this.nightRatePerKm = nightRatePerKm;
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

    @Column(name = "is_Night")
    @NotNull
    public boolean isNight() {
        return isNight;
    }

    public void setNight(boolean night) {
        isNight = night;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "drivers_city_map",
            joinColumns = @JoinColumn(name = "city_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "drivr_id", referencedColumnName = "id"))
    @JsonIgnore
    public List<Driver> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
