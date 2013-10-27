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
@Table(name="koper")
public class Koper {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="naam")
    private String naam;

    @Column(name= "koperType", columnDefinition = "enum('PATICULIER', 'BEDRIJF', 'PERS' )")
    @Enumerated(EnumType.STRING)
    private KoperTypes type;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<TicketOrder> ticketOrders = new HashSet<TicketOrder>();

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<PersContract> persContracten = new HashSet<PersContract>();

    public Koper() {
    }

    public int getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public KoperTypes getType() {
        return type;
    }

    public void setType(KoperTypes type) {
        this.type = type;
    }

    public Set<TicketOrder> getTicketOrders() {
        return ticketOrders;
    }

    public void setTicketOrders(Set<TicketOrder> ticketOrders) {
        this.ticketOrders = ticketOrders;
    }

    public Set<PersContract> getPersContracten() {
        return persContracten;
    }

    public void setPersContracten(Set<PersContract> persContracten) {
        this.persContracten = persContracten;
    }
}
