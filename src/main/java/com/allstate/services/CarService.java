package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.repositories.ICarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private ICarsRepository iCarsRepository;

    @Autowired
    private DriverService driverService;

    @Autowired
    public void setiCarsRepository(ICarsRepository iCarsRepository) {
        this.iCarsRepository = iCarsRepository;
    }

    public Car create(Car car) {
       // Car car = new Car(car4,lux,make4,model4,i);
        return this.iCarsRepository.save(car);
    }

    public Car findById(int i) {
        return  this.iCarsRepository.findOne(i);
    }

    public Car findByName(String car3) {
        return this.iCarsRepository.findByName(car3);
    }
    public List<Car> findAllCarsForADriver(int i) {
        return this.driverService.findById(1).getCars();
    }

}
