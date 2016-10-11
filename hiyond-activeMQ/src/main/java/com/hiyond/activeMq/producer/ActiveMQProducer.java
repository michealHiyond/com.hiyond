package com.hiyond.activeMq.producer;

import com.hiyond.activeMq.config.ActiveMqConfig;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hiyond on 2016/10/11.
 */
public class ActiveMQProducer {

    public static void send() {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageProducer messageProducer;
        try {
            connectionFactory = new ActiveMQConnectionFactory(ActiveMqConfig.USER_NAME,ActiveMqConfig.PASSWORD,ActiveMqConfig.BROKE_URL);
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("test--activeMQ");
            messageProducer = session.createProducer(destination);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while (true) {
                String str = "activeMQ消息--"+simpleDateFormat.format(new Date());
                TextMessage message = session.createTextMessage(str);
                messageProducer.send(destination,message);
                session.commit();
                System.out.println("发送的消息:"+message.getText());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }catch (Exception e){

        }finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        send();
    }


}
