package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

public class CityListTest {

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        // Test to see if hasCity returns whether or not a city is in the list
        City city = new City("Calgary", "Alberta");
        cityList.add(city);

        City city2 = new City("Toronto", "Ontario");

        // Test true
        assertTrue(cityList.hasCity(city));

        // Test false
        assertFalse(cityList.hasCity(city2));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();

        // Test to see if deleteCity actually removes a city from the list
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Regina", "Saskatchewan");
        City city3 = new City("Charlottetown", "Prince Edward Island");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        assertEquals(4, cityList.countCities());

        // Assert city not in list after deletion
        cityList.deleteCity(city3);

        assertEquals(3, cityList.countCities());
        assertFalse(cityList.hasCity(city3));
    }

    @Test
    void testDeleteCityException() {
        CityList cityList = mockCityList();
        // Test to see if the exception is actually thrown
        City city = new City("Ottawa", "Ontario");

        assertFalse(cityList.hasCity(city)); // Verify city not in list

        assertThrows(NoSuchElementException.class, () -> {
            cityList.deleteCity(city);
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();
        // Test to see whether countCities returns how many cities are in the list
        City city1 = new City("Calgary", "Alberta");
        City city2 = new City("Regina", "Saskatchewan");
        City city3 = new City("Charlottetown", "Prince Edward Island");

        // Add a known amount of cities to a list then test countCities to be sure number is the same
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        assertEquals(4, cityList.countCities()); // expected = 4 because mockCity is always in cityList
    }
}
