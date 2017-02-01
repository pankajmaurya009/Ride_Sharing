package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Trip;
import com.allstate.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {
    private ITripRepository tripRepository;

    @Autowired
    public void setTripRepository(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip create(Trip trip) {
        return this.tripRepository.save(trip);
    }

    public Car findTheCar(int i) {
        Trip trip =  this.tripRepository.findOne(i);
        Car car = trip.getCar();
        return car;
    }
}
