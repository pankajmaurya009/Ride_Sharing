package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.enums.CarType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class CarServiceTest {
    @Autowired
    CarService carService;

    @Autowired
    private DriverService driverService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void shouldCreateTheCar(){

        Driver driver = this.driverService.findById(1);
        Car car = new Car("car4", CarType.LUX,"Make4","Model4",1994);
        car.setDriver(driver);
        car = this.carService.create(car);
        assertEquals(6,car.getId());
        assertEquals("car4",car.getName());
    }

    @Test
    public void shouldFindCarById() throws Exception {
        Car car = this.carService.findById(2);
        assertEquals(2, car.getId());
        assertEquals("car2", car.getName());
    }

    @Test
    public void shouldNotFindCarById() throws Exception {
        Car car = this.carService.findById(7);
        assertNull(car);
    }

    @Test
    public void ShouldFindtheCarByName() throws Exception{
        Car car = this.carService.findByName("car3");
        assertEquals("car3", car.getName());
        assertEquals(3, car.getId());
    }

    @Test
    public void ShouldNotFindtheCarByName() throws Exception{
        Car car = this.carService.findByName("xxx");
        assertNull(car);
    }

    @Test
    @Transactional
    public void shouldFindAllTheCarsForADriver() throws Exception{
        List<Car> cars = this.carService.findAllCarsForADriver(1);
        assertEquals(3,cars.size());
    }

}