package com.allstate.services;

import com.allstate.entities.City;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql("/sql/seed.sql")
public class CityServiceTest {

    @Autowired
    CityService cityService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void shouldCreateCity() throws Exception{
        City city = new City("Banglore","KA",false,20.00,40.00);
        city = this.cityService.create(city);

        assertEquals(6,city.getId());
        assertEquals("Banglore",city.getName());

    }

    @Test
    public void shouldFindCityById() throws Exception{

        City city  = this.cityService.findById(3);
        assertEquals(3,city.getId());
        assertEquals("city3",city.getName());

    }

    @Test
    public void shouldNotFindCityById() throws Exception{

        City city  = this.cityService.findById(23);
        assertNull(city);

    }

    @Test
    public void shouldFindCityByName() throws Exception{

        City city  = this.cityService.findByName("city5");
        assertEquals(5,city.getId());
        assertEquals("city5",city.getName());

    }

    @Test
    public void shouldNotFindCityByName() throws Exception{
        City city  = this.cityService.findByName("Lucknow");
        assertNull(city);

    }

}