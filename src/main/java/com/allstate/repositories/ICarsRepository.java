package com.allstate.repositories;


import com.allstate.entities.Car;
import org.springframework.data.repository.CrudRepository;

public interface ICarsRepository extends CrudRepository<Car,Integer> {
    Car findByName(String car3);
}
