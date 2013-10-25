package com.desple.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;
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
@Table(name="tracking")
public class Tracking {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="timestamp")
    private Date timestamp;

    @Column(name="in_out")
    private int inOut;

    @Column(name="bezoekerId")
    private Bezoeker bezoekerId;

    public Tracking() {
    }
}
