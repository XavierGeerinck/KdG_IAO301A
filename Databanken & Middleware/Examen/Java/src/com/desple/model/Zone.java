package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Xavier
 * Date: 17/09/13
 * Time: 12:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="zone")
public class Zone {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "zone_type")
    @Enumerated(EnumType.STRING)
    private EZoneTypes zoneType;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="festival_id")
    private Festival festival;

    @ManyToOne
    @JoinColumn(name="bijhorende_zone")
    private Zone zone;

    @ManyToMany(mappedBy = "zones")
    private Set<TicketType> ticketTypes;

    public Zone() {
    }

    public int getId() {
        return id;
    }

    public EZoneTypes getZoneType() {
        return zoneType;
    }

    public void setZoneType(EZoneTypes zoneType) {
        zoneType = zoneType;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Set<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(Set<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public void addTicketType(TicketType ticketType){
        ticketTypes.add(ticketType);
    }

    @Override
    public String toString() {
        return zoneType.name();
    }
}
