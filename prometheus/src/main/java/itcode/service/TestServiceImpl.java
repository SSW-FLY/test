package itcode.service;

import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.concurrent.locks.ReentrantLock;
import org.springframework.amqp.core.Queue;
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

    public void d() {
        Runnable a = this::deal;
        new Thread(a, "a").start();
        new Thread(a, "b").start();
        new Thread(a, "c").start();
    }

    public void getConsumer() throws IOException {
        Connection connection = connectionFactory.createConnection();
        Channel channel = connection.createChannel(false);
        long l = channel.consumerCount("tut.rpc.requests");
        System.out.println("TOPIC_QUEUE1: " + l);
        long l1 = channel.consumerCount("ec.rcequest.rpc");
        System.out.println("ec.request.rpc: " + l1);
        long l2 = channel.consumerCount("a.b.c");
        System.out.println("a.b.c : " + l2);
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
