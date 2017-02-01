package com.allstate.repositories;


import com.allstate.entities.Passenger;
import org.springframework.data.repository.CrudRepository;

public interface IPassengerRepository extends CrudRepository<Passenger,Integer>{
    Passenger findByName(String p1);
}
