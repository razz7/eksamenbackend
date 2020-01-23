/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Razz
 */
@Entity
@Table(name = "Rental")
@NamedQuery(name = "Movie.deleteAllRows", query = "DELETE from Movie")
public class Rental implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private Bike bike;

/*    @JoinTable(name = "movie_directors", joinColumns = {
        @JoinColumn(name = "movie_id", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "director_id", referencedColumnName = "ID")})
    @ManyToMany
    private List<Bike> directors = new ArrayList();

    @JoinTable(name = "movie_actors", joinColumns = {
        @JoinColumn(name = "movie_id", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "actor_id", referencedColumnName = "ID")})
    @ManyToMany
    private List<Member> actors = new ArrayList();

    @JoinTable(name = "movie_genres", joinColumns = {
        @JoinColumn(name = "movie_id", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "genre_id", referencedColumnName = "ID")})*/
    @OneToMany
    private List<Bike> Bike = new ArrayList();

    public Rental() {
    }

    public Rental(String date, Bike bike) {
       
        this.date = date;
        this.bike = bike;
        
    }


    public List<Bike> getBike() {
        return Bike;
    }

    public void setBikes(List<Bike> Bikes) {
        this.Bike = Bikes;
    }

    public void addBikeToRental(Bike b) {
        this.Bike.add(b);
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = date;
    }

  

   

}
