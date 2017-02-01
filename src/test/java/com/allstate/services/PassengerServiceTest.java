package com.allstate.services;

import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
import com.allstate.enums.IsBan;
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
public class PassengerServiceTest {

    @Autowired
    private PassengerService passengerService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void createPassenger(){

        Passenger passenger = new Passenger("nathen",46, Gender.M,30000.00, IsBan.N);
        passenger = this.passengerService.create(passenger);
        assertEquals(4 ,passenger.getId());
    }

    @Test
    public void findByIdPassenger(){
        Passenger passenger = this.passengerService.findById(2);
        assertEquals(2 ,passenger.getId());
    }

    @Test
    public void findByNamePassenger(){
        Passenger passenger = this.passengerService.findByName("p1");
        assertEquals(1 ,passenger.getId());
    }


}