package com.allstate.services;

import com.allstate.entities.Passenger;
import com.allstate.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {

    private IPassengerRepository passengerRepository;

    @Autowired
    public void setPassengerRepository(IPassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public Passenger create(Passenger passenger) {
        return this.passengerRepository.save(passenger);
    }

    public Passenger findById(int i) {
        return this.passengerRepository.findOne(i);
    }

    public Passenger findByName(String p1) {
        return this.passengerRepository.findByName(p1);
    }
}
