package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="zone")
public class Zone {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "zone_type")
    @Enumerated(EnumType.STRING)
    private EZoneType type;

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

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public EZoneType getType() {
        return type;
    }

    public void setType(EZoneType type) {
        this.type = type;
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
        return type.name();
    }
}
