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
@Table(name="playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="grootte")
    private double grootte;

    @Column(name="naam")
    private String naam;

    @Column(name="duur")
    private double duur;

    @Column(name="registratieAuteursrecht")
    private boolean registratieAuteursrecht;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<Optreden> optreden = new HashSet<Optreden>();

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="id")
    private Set<SongPlaylist> songPlaylists = new HashSet<SongPlaylist>();

    public Playlist() {
    }
}
