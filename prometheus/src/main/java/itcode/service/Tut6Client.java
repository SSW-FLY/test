package itcode.service;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tut6Client {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private TopicExchange exchange;

    int start = 0;

    public Integer send(int n) {
        System.out.println(" [x] Requesting fib(" + start + ")");
        Integer a = (Integer) template.convertSendAndReceive
            (exchange.getName(), "tut.rpc.requests", n);
        return a;
    }
}