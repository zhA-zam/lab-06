package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a class that keeps a list of city objects
 *
 * @author zohaz
 */
public class CityList {

    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     *
     * @param city This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns true if the list contains a given city, false otherwise
     *
     * @param city city item
     * @return Return boolean value whether a given city is in the list
     */
    public boolean hasCity(City city) {
        // When given a city, return whether or not it is in the list
        return cities.contains(city);
    }

    /**
     * This deletes an existing city from the list
     *
     * @param city city item
     */
    public void deleteCity(City city) {
        // Check if a city is present in the list. If it does then remove
        // it from the list, if not then **throw an exception**
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * This returns the number of cities in the list
     *
     * @return Number of cities in the list
     */
    public int countCities() {
        // Return how many cities are in the list

        return cities.size();
    }
}
