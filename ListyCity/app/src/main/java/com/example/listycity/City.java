package com.example.listycity;

import java.lang.Comparable;

/**
 * This is a class that defines a City.
 *
 * @author zohaz
 * @see ...
 * @version 1.0
 *
 */
public class City implements Comparable<City> {

    private String city;
    private String province;

    /**
     * This is the constructor of the City class.
     *
     * @param city      description...
     * @param province  description...
     */
    City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * This is a getter method of the City class.
     *
     * @return          name of the City object's city
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * This is a getter method of the City class.
     *
     * @return          name of the City object's province
     */
    public String getProvinceName() {
        return this.province;
    }

    @Override
    public int compareTo(City o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName()); // this.city refers to the city name
    }
}

