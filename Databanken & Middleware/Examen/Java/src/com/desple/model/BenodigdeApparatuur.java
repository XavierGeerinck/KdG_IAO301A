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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="micro")
    private boolean micro;

    @Column(name="geluids_versterking")
    private boolean geluidsVersterking;

    @Column(name="licht")
    private boolean licht;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<Optreden> optredens = new HashSet<Optreden>();

    public BenodigdeApparatuur() {
    }

    public int getId() {
        return id;
    }

    public boolean isMicro() {
        return micro;
    }

    public void setMicro(boolean micro) {
        this.micro = micro;
    }

    public boolean isGeluidsVersterking() {
        return geluidsVersterking;
    }

    public void setGeluidsVersterking(boolean geluidsVersterking) {
        this.geluidsVersterking = geluidsVersterking;
    }

    public boolean isLicht() {
        return licht;
    }

    public void setLicht(boolean licht) {
        this.licht = licht;
    }

    public Set<Optreden> getOptredens() {
        return optredens;
    }

    public void setOptredens(Set<Optreden> optredens) {
        this.optredens = optredens;
    }
}
