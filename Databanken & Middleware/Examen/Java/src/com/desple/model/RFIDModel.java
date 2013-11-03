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
    private Date timeStampIn;
    private Date timeStampOut;
    private Integer zoneId;

    public int getTrackingNummer() {
        return trackingNummer;
    }

    public void setTrackingNummer(int trackingNummer) {
        this.trackingNummer = trackingNummer;
    }

    public Date getTimeStampIn() {
        return timeStampIn;
    }

    public void setTimeStampIn(Date timeStampIn) {
        this.timeStampIn = timeStampIn;
    }

    public Date getTimeStampOut() {
        return timeStampOut;
    }

    public void setTimeStampOut(Date timeStampOut) {
        this.timeStampOut = timeStampOut;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }
}
