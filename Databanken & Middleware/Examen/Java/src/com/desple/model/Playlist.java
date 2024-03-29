package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="grootte")
    private double grootte;

    @Column(name="naam")
    private String naam;

    @Column(name="duur")
    private double duur;

    @Column(name="registratie_auteursrecht")
    private boolean registratieAuteursrecht;

    @OneToMany(mappedBy = "playlist")
    private Set<Optreden> optreden = new HashSet<Optreden>();

    @ManyToMany(mappedBy = "playlists")
    private Set<Song> songs = new HashSet<Song>();

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
