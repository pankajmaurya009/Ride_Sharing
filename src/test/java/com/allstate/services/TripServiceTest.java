package com.allstate.services;

import com.allstate.entities.*;
import com.allstate.enums.WasSuccessfull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class TripServiceTest {
    @Autowired
    private TripService tripService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private CityService cityService;

    @Autowired
    private CarService carService;

    @Autowired
    private PassengerService passengerService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createTrip(){
        Driver driver = this.driverService.findById(1);
        Passenger passenger = this.passengerService.findById(2);
        Car car = this.carService.findById(3);
        City city = this.cityService.findById(4);

        Trip trip = new Trip(12.09, WasSuccessfull.Y);

        trip.setDriver(driver);
        trip.setCar(car);
        trip.setCity(city);
        trip.setPassenger(passenger);

        trip = this.tripService.create(trip);

        assertEquals(5 ,trip.getId());
    }

    @Test
    public void findCarForATrip(){
        Car car = this.tripService.findTheCar(2);

        assertEquals(3 ,car.getId());
    }


}