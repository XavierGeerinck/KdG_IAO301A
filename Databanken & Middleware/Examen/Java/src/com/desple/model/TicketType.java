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
@Table(name="ticket_type")
public class TicketType {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="prijs")
    private double prijs;

    @Column(name= "ticketType", columnDefinition = "enum('NORMAL', 'VIP', 'COMBI', 'PERS' )")
    @Enumerated(EnumType.STRING)
    private TicketTypes type;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="festivalId")
    private Festival festival;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="ticketType_zone",
            joinColumns = {@JoinColumn(name="ticketTypeId") },
            inverseJoinColumns = {@JoinColumn(name="zoneId") })
    private Set<Zone> zones = new HashSet<Zone>();

    public TicketType() {
    }

    public int getId() {
        return id;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public TicketTypes getType() {
        return type;
    }

    public void setType(TicketTypes type) {
        this.type = type;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestivalId(Festival festival) {
        this.festival = festival;
    }

    public Set<Zone> getZones() {
        return zones;
    }

    public void setZones(Set<Zone> zones) {
        this.zones = zones;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
