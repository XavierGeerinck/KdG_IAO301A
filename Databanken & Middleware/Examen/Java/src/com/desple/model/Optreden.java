package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="optreden")
public class Optreden {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="eind_date")
    private Date eindDate;

    @Column(name="soundcheck")
    private boolean soundCheck;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="fest_dag_id", nullable = false)
    private FestivalDag festivalDag;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="playlist_id", nullable = false)
    private Playlist playlist;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="zone_id", nullable = false)
    private Zone zone;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="apparatuur_id")
    private BenodigdeApparatuur benodigdeApparatuur;

    public Optreden() {
    }

    public int getId() {
        return id;
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

    public boolean isSoundCheck() {
        return soundCheck;
    }

    public void setSoundCheck(boolean soundCheck) {
        this.soundCheck = soundCheck;
    }

    public FestivalDag getFestivalDag() {
        return festivalDag;
    }

    public void setFestivalDag(FestivalDag festivalDag) {
        this.festivalDag = festivalDag;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public BenodigdeApparatuur getBenodigdeApparatuur() {
        return benodigdeApparatuur;
    }

    public void setBenodigdeApparatuur(BenodigdeApparatuur benodigdeApparatuur) {
        this.benodigdeApparatuur = benodigdeApparatuur;
    }

    @Override
    public String toString() {
        return playlist.getNaam() + " - " + zone.toString();
    }
}
