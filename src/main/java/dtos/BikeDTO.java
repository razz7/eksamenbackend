/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Member;
import entities.Bike;
import entities.Storage;
import entities.Bike;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Razz
 */
public class BikeDTO {
    private String make;
    private int size;
    private String gender;
    private int gears;
    private double day_price;
    
    
    public BikeDTO(Bike b ) {
        
        this.make = b.getMake();
        this.size = b.getSize();
        this.gender = b.getGender();
        this.gears = b.getGears();
        this.day_price = b.getDay_price();

        
    }
    public BikeDTO(String make, int size, double day_price, String gender) {
        this.make = make;
        this.size = size;
        this.gender = gender;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGears() {
        return gears;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public double getDay_price() {
        return day_price;
    }

    public void setDay_price(double day_price) {
        this.day_price = day_price;
    }


    
    
    
    
}
