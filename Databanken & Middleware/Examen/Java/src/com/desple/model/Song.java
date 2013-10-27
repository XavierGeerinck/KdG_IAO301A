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
@Table(name="song")
public class Song {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="duur")
    private double duur;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="song_playlist",
            joinColumns = {@JoinColumn(name="songId") },
            inverseJoinColumns = {@JoinColumn(name="playlistId") })
    private Set<Playlist> playlists = new HashSet<Playlist>();

    public Song() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuur() {
        return duur;
    }

    public void setDuur(double duur) {
        this.duur = duur;
    }
}
