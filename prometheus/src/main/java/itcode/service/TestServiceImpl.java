package itcode.service;

import com.rabbitmq.client.Channel;
import itcode.Monitor.PrometheusCustomMonitor;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author imp
 * @date 2020/9/15
 */
@Service
public class TestServiceImpl {

    private static volatile Long a = 2L;
    private static ReentrantLock lock = new ReentrantLock();

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private PrometheusCustomMonitor monitor;

    public void getConsumer() {
        Connection connection = connectionFactory.createConnection();
        Channel channel = connection.createChannel(false);
        try {
            long l = channel.consumerCount("tut.rpc.requests");
            System.out.println("TOPIC_QUEUE1: " + l);
            monitor.setLongGauge(l);
        } catch (IOException e) {
            monitor.setLongGauge(0L);
        }
    }

    public void deal() {
        try {
            Thread.sleep(1000);
            a++;
            System.out.println("a=:" + Thread.currentThread().getName() + " - " + a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
