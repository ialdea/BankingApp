package com.example;

import java.util.HashMap;
import java.util.Map;

public final class Agency {
    final private String street;
    final private String city;

    private static Map<String, Agency> allAgencies = new HashMap<>();

    public  static Agency getAgency(String street, String city){
        Agency ag = allAgencies.get(street+"#"+city);
        if(ag == null){
            ag = new Agency(street, city);
            allAgencies.put(street+"#"+city, ag);
        }
        return ag;
    }

    public Agency(String street, String city){
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String toString(){
        return "street "+street+" city "+city;
    }
}
