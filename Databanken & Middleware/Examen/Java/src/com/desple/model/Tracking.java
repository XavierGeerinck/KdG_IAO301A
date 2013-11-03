package com.desple.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name="tracking")
public class Tracking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="trackingNummer")
    private int trackingNummer;

    @Column(name="timestamp")
    private Date timestamp;

    //0 for in 1 for out
    @Column(name="in_out")
    private int inOut;

    @ManyToOne
    @Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE })
    @JoinColumn(name="zone_id")
    private Zone zone;

    public Tracking() {
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getInOut() {
        return inOut;
    }

    public void setInOut(int inOut) {
        this.inOut = inOut;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public int getTrackingNummer() {
        return trackingNummer;
    }

    public void setTrackingNummer(int trackingNummer) {
        this.trackingNummer = trackingNummer;
    }

    @Override
    public String toString() {
        return "Tracking{" + id +
                "trackingNummer=" + trackingNummer +
                ", timestamp=" + timestamp +
                ", inOut=" + inOut +
                ", zone=" + zone +
                '}';
    }
}
