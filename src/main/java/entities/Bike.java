/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Rumle
 */
@Entity
@Table(name = "Bike")
public class Bike implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String make;
    private int size_;
    private String gender;
    private int gears;
    private double day_price;
    

    
    
    @OneToMany(mappedBy = "id")
    private List<Rental> Rental;
            
    public Bike() {
        
    }

    public Bike(String make, int size, String gender, int gears, double day_price ) {
       
        this.make = make;
        this.size_ = size;
        this.gender = gender;
        this.gears = gears;
        this.day_price = day_price;
        
    }

 

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getSize() {
        return size_;
    }

    public void setSize(int size) {
        this.size_ = size;
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

    public List<Rental> getRental() {
        return Rental;
    }

    public void setRental(List<Rental> Rental) {
        this.Rental = Rental;
    }

  
    
    
  

   
    
}
