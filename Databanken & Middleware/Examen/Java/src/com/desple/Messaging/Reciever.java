package com.desple.Messaging;

import com.desple.model.Tracking;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

import javax.jms.*;
import java.io.StringReader;

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
                        StringReader reader = new StringReader(textMessage.getText());
                        Tracking tracking = (Tracking)(Unmarshaller.unmarshal(Tracking.class, reader));
                        System.out.println(tracking);
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
        }
    }
}
