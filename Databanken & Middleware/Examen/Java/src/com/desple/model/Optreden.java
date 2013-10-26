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
@Table(name="optreden")
public class Optreden {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="tijdstip")
    private Date tijdstip;

    @Column(name="duur")
    private double duur;

    @Column(name="soundcheck")
    private boolean soundCheck;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="festDagId")
    private Set<FestivalDag> festivalDagen = new HashSet<FestivalDag>();

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="playlistId")
    private Set<Playlist> playlists = new HashSet<Playlist>();

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="zoneId")
    private Set<Zone> zones = new HashSet<Zone>();

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="apparatuurId")
    private Set<BenodigdeApparatuur> apparatuurRequirements = new HashSet<BenodigdeApparatuur>();

    public Optreden() {
    }

    public int getId() {
        return id;
    }

    public Date getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(Date tijdstip) {
        this.tijdstip = tijdstip;
    }

    public double getDuur() {
        return duur;
    }

    public void setDuur(double duur) {
        this.duur = duur;
    }

    public boolean isSoundCheck() {
        return soundCheck;
    }

    public void setSoundCheck(boolean soundCheck) {
        this.soundCheck = soundCheck;
    }

    public Set<FestivalDag> getFestivalDagen() {
        return festivalDagen;
    }

    public void setFestivalDagen(Set<FestivalDag> festivalDagen) {
        this.festivalDagen = festivalDagen;
    }

    public Set<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Set<Playlist> playlists) {
        this.playlists = playlists;
    }

    public Set<Zone> getZones() {
        return zones;
    }

    public void setZones(Set<Zone> zones) {
        this.zones = zones;
    }

    public Set<BenodigdeApparatuur> getApparatuurRequirements() {
        return apparatuurRequirements;
    }

    public void setApparatuurRequirements(Set<BenodigdeApparatuur> apparatuurRequirements) {
        this.apparatuurRequirements = apparatuurRequirements;
    }
}
