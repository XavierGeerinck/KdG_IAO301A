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

    @Column(name= "ticket_type")
    @Enumerated(EnumType.STRING)
    private ETicketType type;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="festival_id")
    private Festival festival;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="ticket_type_zone",
            joinColumns = {@JoinColumn(name="ticket_type_id") },
            inverseJoinColumns = {@JoinColumn(name="zone_id") })
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

    public ETicketType getType() {
        return type;
    }

    public void setType(ETicketType type) {
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
