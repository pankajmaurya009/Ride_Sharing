package com.allstate.entities;

import com.allstate.enums.Gender;
import com.allstate.enums.IsBan;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "drivers")
@Data
public class Driver {

    private int id;
    private int version;
    private String name;
    private int age;
    private Gender gender;
    private int tickets;
    private IsBan isban;
    private List<Car> cars;
    private List<City> cities;
    private Date created;
    private Date modified;


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
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column(columnDefinition = "ENUM('Y', 'N')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public IsBan getIsban() {
        return isban;
    }

    public void setIsban(IsBan isban) {
        this.isban = isban;
    }

    @OneToMany(mappedBy = "driver")
    @JsonIgnore
    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @ManyToMany(mappedBy = "drivers")
    @JsonIgnore
    public List<City> getCities() {
        return cities;
    }
    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
