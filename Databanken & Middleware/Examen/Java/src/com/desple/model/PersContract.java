package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pers_contract")
public class PersContract {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="bio")
    private String bio;

    @Column(name="mag_filmen")
    private boolean magFilmen;

    @Column(name="mag_foto")
    private boolean magFoto;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="optreden_id")
    private Optreden optredenId;

    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="koper_id")
    private Koper koperId;

    public PersContract() {
    }

    public boolean isMagFilmen() {
        return magFilmen;
    }

    public void setMagFilmen(boolean magFilmen) {
        this.magFilmen = magFilmen;
    }

    public boolean isMagFoto() {
        return magFoto;
    }

    public void setMagFoto(boolean magFoto) {
        this.magFoto = magFoto;
    }

    public Optreden getOptredenId() {
        return optredenId;
    }

    public void setOptredenId(Optreden optredenId) {
        this.optredenId = optredenId;
    }

    public Koper getKoperId() {
        return koperId;
    }

    public void setKoperId(Koper koperId) {
        this.koperId = koperId;
    }
}
