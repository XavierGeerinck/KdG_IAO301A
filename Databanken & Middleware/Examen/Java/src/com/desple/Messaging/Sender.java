package com.desple.Messaging;

import com.desple.model.*;
import com.desple.services.FestivalService;
import com.desple.services.ZoneService;
import com.desple.util.HibernateUtil;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.hibernate.*;
import org.hibernate.cfg.annotations.reflection.XMLContext;

import javax.jms.*;
import javax.jms.Session;
import java.io.StringWriter;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Thierry
 * Date: 30/10/13
 * Time: 19:01
 * To change this template use File | Settings | File Templates.
 */
public class Sender {

    private Date generateRandomDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        Random random = new Random();
        int addingMinutes = random.nextInt(720);
        cal.add(Calendar.MINUTE, addingMinutes);
        return cal.getTime();
    }

    public static void main(String[] args) {
        Sender sender = new Sender();
       // ArrayList<Festival> festivals = FestivalService.findFestivalByName("");

        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://localhost:61616");
        List<Festival> festivals = FestivalService.findFestivalByName("pukkelpop");
        Date date = festivals.get(0).getStartDate();

        // Create a Connection to ActiceMQ
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            // Create a Session that allows you to work with activeMQ
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // Create the destination queue (or retrieve it, if it already exists)
            Destination destination = session.createQueue("TEST.SENDRECEIVE");
            // Create a MessageProducer for the Destination
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            List<Zone> zones = ZoneService.getZonesByFestival(festivals.get(0));
            int i = 0;
            while(i < 500){
                RFIDModel trackingIn = new RFIDModel();
                RFIDModel trackingOut = new RFIDModel();

                Random random = new Random();
                int randomZone = random.nextInt((zones.size()- 2)) + 2;
                Zone zone = zones.get(randomZone);




                trackingIn.setZoneId(zone.getId());
                trackingIn.setTrackingNummer(i);
                trackingIn.setInOut(0);

                trackingOut.setZoneId(zone.getId());
                trackingOut.setTrackingNummer(i);
                trackingOut.setInOut(1);


                Date date1 = sender.generateRandomDate(date);
                Date date2 = sender.generateRandomDate(date);

                if(date1.compareTo(date2) > 0 ){
                    trackingIn.setTimeStamp(date2);
                    trackingOut.setTimeStamp(date1);
                }else{
                    trackingIn.setTimeStamp(date1);
                    trackingOut.setTimeStamp(date2);
                }


                StringWriter writer = new StringWriter();
                Marshaller.marshal(trackingIn, writer);
                TextMessage message = session.createTextMessage(writer.toString());
                producer.send(message);


                StringWriter writer2 = new StringWriter();
                Marshaller.marshal(trackingOut, writer2);
                message = session.createTextMessage(writer2.toString());
                producer.send(message);
                i++;
            }
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.getMessage();
        } catch (MarshalException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ValidationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }


}
