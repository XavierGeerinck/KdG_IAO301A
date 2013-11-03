package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="zone")
public class Zone {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "zone_type")
    @Enumerated(EnumType.STRING)
    private EZoneType type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="festival_id")
    private Festival festival;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="bijhorende_zone")
    private Zone zone;

    @OneToMany(mappedBy = "zone")
    private Set<Tracking> trackings = new HashSet<Tracking>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="ticket_type_zone",
            joinColumns = {@JoinColumn(name="zone_id") },
            inverseJoinColumns = {@JoinColumn(name="ticket_type_id") })
    private Set<TicketType> ticketTypes = new HashSet<TicketType>();

    public Zone() {
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id){
        this.id = id;
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
        return id + "  " + type;
    }
}
