package com.desple.Messaging;

import com.desple.model.Optreden;
import com.desple.model.RFIDModel;
import com.desple.model.Tracking;
import com.desple.model.Zone;
import com.desple.services.OptredenService;
import com.desple.services.ZoneService;
import com.desple.util.HibernateUtil;
import com.mongodb.*;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.hibernate.Transaction;

import javax.jms.*;
import javax.jms.Session;
import java.io.StringReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Thierry
 * Date: 30/10/13
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public class Reciever {



    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://localhost:61616");
        // Create a Connection to ActiceMQ
        Connection connection = null;
        try {

            final MongoClient mongoClient = new MongoClient();
            final DB db = mongoClient.getDB("FestivalDb");
            final DBCollection collection = db.getCollection("Tracking");

            connection = connectionFactory.createConnection();
            connection.start();
            // Create a Session that allows you to work with activeMQ
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination queue (or retrieve it, if it already exists)
            Destination destination = session.createQueue("TEST.SENDRECEIVE");
            // Create a MessageProducer for the Destination
            MessageConsumer consumer = session.createConsumer(destination);

            MessageListener listener = new MessageListener() {
                @Override
                public void onMessage(Message msg){
                    TextMessage textMessage = (TextMessage) msg;
                    try {
                        org.hibernate.Session sessionHibernate = HibernateUtil.getSessionFactory().getCurrentSession();
                        StringReader reader = new StringReader(textMessage.getText());
                        Transaction tx = sessionHibernate.beginTransaction();

                        RFIDModel rfidModel = (RFIDModel)(Unmarshaller.unmarshal(RFIDModel.class, reader));
                        Tracking tracking = new Tracking();
                        tracking.setTimestampIn(rfidModel.getTimeStampIn());
                        tracking.setTimestampOut(rfidModel.getTimeStampOut());
                        tracking.setTrackingNummer(rfidModel.getTrackingNummer());
                        tracking.setZone(ZoneService.getZoneById(rfidModel.getZoneId()));


                        sessionHibernate.saveOrUpdate(tracking);
                        tx.commit();
                        BasicDBObject dbObject = new BasicDBObject("TrackingNummer", tracking.getTrackingNummer()).
                                append("TimestampIn", tracking.getTimestampIn()).
                                append("TimestampOut", tracking.getTimestampOut()).
                                append("Zone", tracking.getZone().getType().toString());
                        if (tracking.getZone().getZone() != null){
                            List<Optreden> optredens = OptredenService.findOptredenByDatesAndZone(tracking.getTimestampIn(), tracking.getTimestampOut(), tracking.getZone().getZone());

                            //if (optredens.isEmpty() == false){
                            //    dbObject.append("Artiest", optredens.get(0).getArtiest().getNaam());
                            //}
                        }
                        collection.insert(dbObject);

                    } catch (JMSException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    } catch (MarshalException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    } catch (ValidationException e) {
                        e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                    }


                }
            };

            consumer.setMessageListener(listener);
        } catch (JMSException e) {

            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
