package com.allstate.services;


import com.allstate.entities.City;
import com.allstate.repositories.ICitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private ICitiesRepository citiesRepository;

    @Autowired
    public void setCitiesRepository(ICitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    public City create(City city) {
       return this.citiesRepository.save(city);
    }

    public City findById(int i) {
        return this.citiesRepository.findOne(i);
    }

    public City findByName(String lucknow) {
        return this.citiesRepository.findByName(lucknow);
    }


}
