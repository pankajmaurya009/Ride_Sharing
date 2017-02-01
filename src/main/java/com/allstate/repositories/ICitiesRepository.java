package com.allstate.repositories;


import com.allstate.entities.City;
import org.springframework.data.repository.CrudRepository;

public interface ICitiesRepository extends CrudRepository<City, Integer>{
    City findByName(String lucknow);
}
