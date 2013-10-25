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


}
