/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Bike;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Razz
 */
public class BikeDTOs {
    private List<BikeDTO> BikeDtos = new ArrayList<>();
    
    public BikeDTOs(List<Bike> Bikes) {
        for(Bike b : Bikes) {
            BikeDtos.add(new BikeDTO(b));
        }
        
    }
    
}
