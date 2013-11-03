package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="festival")
public class Festival {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="naam")
    private String naam;

    @Column(name="locatie")
    private String locatie;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="eind_date")
    private Date eindDate;

    @OneToMany(mappedBy = "festival", fetch = FetchType.EAGER)
    private Set<Zone> zones = new HashSet<Zone>();

    @OneToMany(mappedBy = "festival", fetch = FetchType.EAGER)
    private Set<FestivalDag> festivalDagen = new HashSet<FestivalDag>();

    public Festival() {
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getLocatie() {
        return locatie;
    }


    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEindDate() {
        return eindDate;
    }

    public void setEindDate(Date eindDate) {
        this.eindDate = eindDate;
    }

    public Set<Zone> getZones() {
        return zones;
    }

    public void setZones(Set<Zone> zones) {
        this.zones = zones;
    }

    public Set<FestivalDag> getFestivalDagen() {
        return festivalDagen;
    }

    public void setFestivalDagen(Set<FestivalDag> festivalDagen) {
        this.festivalDagen = festivalDagen;
    }

    @Override
    public String toString() {
        return naam;
    }
}
