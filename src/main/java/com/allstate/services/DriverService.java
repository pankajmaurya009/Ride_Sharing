package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private IDriverRepository iDriverRepository;

    @Autowired
    private CarService carService;

    @Autowired
    private CityService cityService;

    @Autowired
    public void setiDriverRepository(IDriverRepository iDriverRepository) {
        this.iDriverRepository = iDriverRepository;
    }

    @Autowired
    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public Driver create(Driver driver) {
        return this.iDriverRepository.save(driver);

    }

    public Driver findById(int i) {
        return this.iDriverRepository.findOne(i);
    }

    public Driver findByName(String name) {
        return this.iDriverRepository.findByName(name);
    }

    public Driver findDriverForACar(int i) {
        return this.carService.findById(i).getDriver();
    }

    public List<Driver> findAllTheDriversInACity(int i) {
        City city = this.cityService.findById(i);
        return (city != null ? city.getDrivers(): null);
    }
}

