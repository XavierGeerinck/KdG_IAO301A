package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 17/09/13
 * Time: 12:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="medewerker")
public class Medewerker {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="naam")
    private String naam;

    @Column(name="adres")
    private String adres;

    @Column(name="uurloon")
    private double uurloon;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="medewerker_taak", joinColumns = {
            @JoinColumn(name="medewerker_id") }, inverseJoinColumns = {
            @JoinColumn(name="taak_id") })
    private Set<Taak> taken = new HashSet<Taak>();

    public Medewerker() {
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public double getUurloon() {
        return uurloon;
    }

    public void setUurloon(double uurloon) {
        this.uurloon = uurloon;
    }

    public Set<Taak> getTaken() {
        return taken;
    }

    public void setTaken(Set<Taak> taken) {
        this.taken = taken;
    }
}
