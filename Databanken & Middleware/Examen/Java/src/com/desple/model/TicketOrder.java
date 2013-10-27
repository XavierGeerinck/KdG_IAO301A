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
@Table(name="ticket_order")
public class TicketOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private String verkoopsWijze;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="koperId")
    private Koper koper;

    public TicketOrder() {
    }

    public int getId() {
        return id;
    }

    public String getVerkoopsWijze() {
        return verkoopsWijze;
    }

    public void setVerkoopsWijze(String verkoopsWijze) {
        this.verkoopsWijze = verkoopsWijze;
    }

    public Koper getKoper() {
        return koper;
    }

    public void setKoper(Koper koper) {
        this.koper = koper;
    }
}
