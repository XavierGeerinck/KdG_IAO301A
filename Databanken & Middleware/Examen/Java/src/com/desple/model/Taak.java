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
@Table(name="taak")
public class Taak {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="omschrijving")
    private String omschrijving;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<MedewerkerTaak> medewerkerTaken = new HashSet<MedewerkerTaak>();

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="festivalDagId")
    private FestivalDag festivalDag;

    public Taak() {
    }
}
