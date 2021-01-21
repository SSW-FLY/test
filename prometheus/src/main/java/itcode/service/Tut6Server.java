package itcode.service;

import itcode.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author imp
 */
@Component
public class Tut6Server {

    @RabbitListener(queues = RabbitConfig.TOPIC_QUEUE1)
    public int ffff(int n) throws InterruptedException {
        System.out.println("ffffffffffffffffffffffffffffffffffffffffffff" + n);
        Thread.sleep(3000L);
        return n;
    }
}