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
@Table(name="playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="grootte")
    private double grootte;

    @Column(name="naam")
    private String naam;

    @Column(name="duur")
    private double duur;

    @Column(name="registratieAuteursrecht")
    private boolean registratieAuteursrecht;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<Optreden> optreden = new HashSet<Optreden>();

    public Playlist() {
    }

    public int getId() {
        return id;
    }

    public double getGrootte() {
        return grootte;
    }

    public void setGrootte(double grootte) {
        this.grootte = grootte;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getDuur() {
        return duur;
    }

    public void setDuur(double duur) {
        this.duur = duur;
    }

    public boolean isRegistratieAuteursrecht() {
        return registratieAuteursrecht;
    }

    public void setRegistratieAuteursrecht(boolean registratieAuteursrecht) {
        this.registratieAuteursrecht = registratieAuteursrecht;
    }

    public Set<Optreden> getOptreden() {
        return optreden;
    }

    public void setOptreden(Set<Optreden> optreden) {
        this.optreden = optreden;
    }
}
