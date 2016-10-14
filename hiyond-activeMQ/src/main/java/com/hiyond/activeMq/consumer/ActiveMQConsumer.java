package com.hiyond.activeMq.consumer;

import com.hiyond.activeMq.config.ActiveMqConfig;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by hiyond on 2016/10/11.
 */
public class ActiveMQConsumer {

    public static void receive() {

        ConnectionFactory connectionFactory;//连接工厂
        Connection connection = null;//连接

        Session session;//会话 接受或者发送消息的线程
        Destination destination;//消息的目的地

        MessageConsumer messageConsumer;//消息的消费者

        //实例化连接工厂
        connectionFactory = new ActiveMQConnectionFactory(ActiveMqConfig.USER_NAME,ActiveMqConfig.PASSWORD,ActiveMqConfig.BROKE_URL);

        try {
            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //创建session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建一个连接test--activeMQ的消息队列
            destination = session.createQueue("test--activeMQ");
            //创建消息消费者
            messageConsumer = session.createConsumer(destination);

            while (true) {
                TextMessage textMessage = (TextMessage) messageConsumer.receive();
                if(textMessage != null){
                    System.out.println("收到的消息:" + textMessage.getText());
                }else {
                    //break;
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                }
            }


        } catch (JMSException e) {
            e.printStackTrace();
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
        receive();
    }

}
