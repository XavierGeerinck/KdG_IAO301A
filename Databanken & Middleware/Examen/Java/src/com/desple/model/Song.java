package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="song")
public class Song {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="duur")
    private double duur;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="song_playlist",
            joinColumns = {@JoinColumn(name="song_id") },
            inverseJoinColumns = {@JoinColumn(name="playlist_id") })
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
