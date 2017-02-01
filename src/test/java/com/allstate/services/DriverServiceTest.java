package com.allstate.services;

import com.allstate.entities.Driver;
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

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class DriverServiceTest {
    @Autowired
    private DriverService driverService;

    @Autowired
    private CityService cityService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateTheDriver(){
        Driver driver = new Driver();
        driver.setName("xxx");
        driver.setAge(23);
        driver.setGender(Gender.M);
        driver.setTickets(0);
        driver.setIsban(IsBan.N);
        Driver tdriver = this.driverService.create(driver);
        assertEquals(3,tdriver.getId());
        assertEquals("xxx",tdriver.getName());
    }

    @Test
    public void shouldFindDriverById() throws Exception {
        Driver driver = this.driverService.findById(1);
        assertEquals(1, driver.getId());

    }

    @Test
    public void ShouldNotFindtheDriverById() throws Exception{
        Driver driver = this.driverService.findById(3);
        assertNull(driver);
    }

    @Test
    public void ShouldFindtheDriverByName() throws Exception{
        Driver driver = this.driverService.findByName("roy");
        assertEquals("roy", driver.getName());
        assertEquals(1, driver.getId());
    }

    @Test
    public void ShouldNotFindtheDriverByName() throws Exception{
        Driver driver = this.driverService.findByName("xxx");
        assertNull(driver);
    }

    @Test
    @Transactional
    public void shouldFindTheDriverForACar() throws Exception{
        Driver driver = this.driverService.findDriverForACar(2);
        assertEquals(1, driver.getId());
        assertEquals("roy", driver.getName());
    }

    @Test
    @Transactional
    public void shouldFindAllTheDriversInTheCity() throws Exception{
        List<Driver> drivers= this.driverService.findAllTheDriversInACity(1);
        assertEquals(1, drivers.size());
    }

    @Test
    @Transactional
    public void shouldFindAllTheDriversInTheCity2() throws Exception{
        List<Driver> drivers= this.driverService.findAllTheDriversInACity(5);
        assertEquals(2, drivers.size());
    }

    @Test
    @Transactional
    public void shouldFindAllTheDriversInTheCity8() throws Exception{
        List<Driver> drivers= this.driverService.findAllTheDriversInACity(8);
        assertNull(drivers);
    }

}