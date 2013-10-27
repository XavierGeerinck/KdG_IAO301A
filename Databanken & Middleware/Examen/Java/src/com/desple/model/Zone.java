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
@Table(name="zone")
public class Zone {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "zoneType", columnDefinition = "enum('PODIUM1', 'PODIUM2', 'PUBLIEKPODIUM1', 'PUBLIEKPODIUM2', 'VIP', 'BACKSTAGE', 'SANITAIR', 'CAMPING')")
    @Enumerated(EnumType.STRING)
    private ZoneTypes zoneType;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="festivalId")
    private Festival festival;

    @ManyToMany(mappedBy = "zones")
    private Set<TicketType> ticketTypes;

    public Zone() {
    }

    public int getId() {
        return id;
    }

    public ZoneTypes getZoneType() {
        return zoneType;
    }

    public void setZoneType(ZoneTypes zoneType) {
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
}
