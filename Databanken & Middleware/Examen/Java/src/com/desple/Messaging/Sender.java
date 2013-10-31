package com.desple.Messaging;

import com.desple.model.EZoneType;
import com.desple.model.Tracking;
import com.desple.model.Zone;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ValidationException;
import org.hibernate.cfg.annotations.reflection.XMLContext;

import javax.jms.*;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Thierry
 * Date: 30/10/13
 * Time: 19:01
 * To change this template use File | Settings | File Templates.
 */
public class Sender {

    private Date generateRandomDate(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        Random random = new Random();
        int addingMinutes = random.nextInt(720);
        cal.add(Calendar.MINUTE, addingMinutes);
        return cal.getTime();
    }

    public static void main(String[] args) {
        Sender sender = new Sender();


        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://localhost:61616");

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
            ArrayList<Zone> zones = new ArrayList<Zone>();
            for(EZoneType zoneType : EZoneType.values()){
                Zone zone = new Zone();
                zone.setType(zoneType);
                zones.add(zone);
            }
            int i = 0;
            while(i < 500){
                Tracking trackingIn = new Tracking();
                Tracking trackingOut = new Tracking();
                Random random = new Random();
                int randomZone = random.nextInt(zones.size());
                trackingIn.setZone(zones.get(randomZone));
                trackingOut.setZone(zones.get(randomZone));
                trackingIn.setTrackingNummer(i);
                trackingOut.setTrackingNummer(i);
                trackingIn.setInOut(0);
                trackingOut.setInOut(1);

                Date date1 = sender.generateRandomDate();
                Date date2 = sender.generateRandomDate();

                if(date1.compareTo(date2) > 0 ){
                    trackingIn.setTimestamp(date2);
                    trackingOut.setTimestamp(date1);
                }else{
                    trackingIn.setTimestamp(date1);
                    trackingOut.setTimestamp(date2);
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
