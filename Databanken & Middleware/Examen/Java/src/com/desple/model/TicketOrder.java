package com.desple.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ticket_order")
public class TicketOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name= "verkoop_wijze")
    @Enumerated(EnumType.STRING)
    private ETicketOrder verkoopsWijze;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="koper_id")
    private Koper koper;

    public TicketOrder() {
    }

    public int getId() {
        return id;
    }

    public ETicketOrder getVerkoopsWijze() {
        return verkoopsWijze;
    }

    public void setVerkoopsWijze(ETicketOrder verkoopsWijze) {
        this.verkoopsWijze = verkoopsWijze;
    }

    public Koper getKoper() {
        return koper;
    }

    public void setKoper(Koper koper) {
        this.koper = koper;
    }
}
