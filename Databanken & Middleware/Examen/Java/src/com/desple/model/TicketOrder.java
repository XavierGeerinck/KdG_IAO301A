package com.desple.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name="ticket_order")
public class TicketOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name= "verkoopWijze", columnDefinition = "enum('WEB', 'HANDELAAR')")
    @Enumerated(EnumType.STRING)
    private TicketOrders verkoopsWijze;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="koperId")
    private Koper koper;

    public TicketOrder() {
    }

    public int getId() {
        return id;
    }

    public TicketOrders getVerkoopsWijze() {
        return verkoopsWijze;
    }

    public void setVerkoopsWijze(TicketOrders verkoopsWijze) {
        this.verkoopsWijze = verkoopsWijze;
    }

    public Koper getKoper() {
        return koper;
    }

    public void setKoper(Koper koper) {
        this.koper = koper;
    }
}
