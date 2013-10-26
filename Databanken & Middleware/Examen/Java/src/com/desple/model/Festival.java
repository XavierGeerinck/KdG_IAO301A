package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
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
@Table(name="festival")
public class Festival {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="locatie")
    private String locatie;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="eind_date")
    private Date eindDate;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<Zone> zones = new HashSet<Zone>();

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<FestivalDag> festivalDagen = new HashSet<FestivalDag>();

    public Festival() {
    }

    public int getId() {
        return id;
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
}
