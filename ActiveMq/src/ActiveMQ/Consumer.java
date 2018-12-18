package ActiveMQ;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Consumer {

    private static final String Username=ActiveMQConnection.DEFAULT_USER;
    private static final String Password=ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String ActiveMqUrl="tcp://172.16.51.64:61616/";

    ConnectionFactory connectionFactory;
    Connection connection;
    Session session;

    ThreadLocal<MessageConsumer> threadLocal =new ThreadLocal<>();
    AtomicInteger count=new AtomicInteger();
    public void init(){
        try {
        connectionFactory=new ActiveMQConnectionFactory(Username,Password,ActiveMqUrl);
        connection=connectionFactory.createConnection();
        connection.start();
        session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
    public void getMessage(String disname){
        try{
            Queue queue=session.createQueue(disname);
            MessageConsumer consumer=null;
            if(threadLocal.get()!=null){
                consumer=threadLocal.get();
            }
            else{
                consumer=session.createConsumer(queue);
                threadLocal.set(consumer);
            }
            while(true){
                Thread.sleep(1000);
                TextMessage msg=(TextMessage) consumer.receive();
                if(msg!=null){
                    msg.acknowledge();
                    System.out.println(Thread.currentThread().getName()+"Consumer:我正在消费Msg"+msg.getText()+"--->"+count.getAndIncrement());
                }
                else {break;}
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }




}
