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
@Table(name="benodigde_apparatuur")
public class BenodigdeApparatuur {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="micro")
    private int micro;

    @Column(name="geluids_versterking")
    private int geluidsVersterking;

    @Column(name="licht")
    private int licht;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<Optreden> optredens = new HashSet<Optreden>();

    public BenodigdeApparatuur() {
    }

    public int getId() {
        return id;
    }

    public int getMicro() {
        return micro;
    }

    public void setMicro(int micro) {
        this.micro = micro;
    }

    public int getGeluidsVersterking() {
        return geluidsVersterking;
    }

    public void setGeluidsVersterking(int geluidsVersterking) {
        this.geluidsVersterking = geluidsVersterking;
    }

    public int getLicht() {
        return licht;
    }

    public void setLicht(int licht) {
        this.licht = licht;
    }

    public Set<Optreden> getOptredens() {
        return optredens;
    }

    public void setOptredens(Set<Optreden> optredens) {
        this.optredens = optredens;
    }
}
