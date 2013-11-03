package com.desple.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Thierry
 * Date: 3/11/13
 * Time: 14:22
 * To change this template use File | Settings | File Templates.
 */
public class RFIDModel {

    private int trackingNummer;
    private Date timeStamp;
    private int inOut;
    private Integer zoneId;

    public int getTrackingNummer() {
        return trackingNummer;
    }

    public void setTrackingNummer(int trackingNummer) {
        this.trackingNummer = trackingNummer;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getInOut() {
        return inOut;
    }

    public void setInOut(int inOut) {
        this.inOut = inOut;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }
}
