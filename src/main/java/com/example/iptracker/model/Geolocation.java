package com.example.iptracker.model;

import java.io.Serializable;

public class Geolocation implements Serializable {

    public String ip;
    public Boolean success;
    public String continent;
    public String country;
    public String city;

    public Geolocation(String ip, Boolean success, String continent, String country, String city) {
        this.ip = ip;
        this.success = success;
        this.continent = continent;
        this.country = country;
        this.city = city;
    }

    public String getIp() {
        return ip;
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getContinent() {
        return continent;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return getCity();
    }
}
