package com.desple.testData;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Thierry
 * Date: 26/10/13
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
public class Festival {
    private String name;
    private String location;
    private Date startDate;
    private Date endDate;

    public Festival(String name, String location, Date startDate) {
        this.name = name;
        this.location = location;
        this.startDate = startDate;
    }

    public int setEndDate(Random random){
        int amountDays = random.nextInt(4);
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DATE, amountDays);
        endDate = cal.getTime();
        return amountDays;
    }
}
