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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @OneToMany
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinColumn(name="albumId")
    private Set<Song> songs = new HashSet<Song>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="song_playlist", joinColumns = {
            @JoinColumn(name="song_id") }, inverseJoinColumns = {
            @JoinColumn(name="playlist_id") })
    private Set<Playlist> playlists = new HashSet<Playlist>();

    public Song() {
    }


}
