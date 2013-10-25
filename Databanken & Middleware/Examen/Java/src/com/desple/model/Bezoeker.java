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
@Table(name="bezoeker")
public class Bezoeker {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="tracking_nummer")
    private String trackingNummer;

    @Column(name="naam")
    private String naam;

    @Column(name="adres")
    private String adres;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<Tracking> trackings = new HashSet<Tracking>();

    public Bezoeker() {
    }
}
