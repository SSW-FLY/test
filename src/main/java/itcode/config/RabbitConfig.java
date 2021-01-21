package itcode.config;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.BrokerEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author imp
 * @date 2020/6/18
 */
@Configuration
public class RabbitConfig {

    public static final String TOPIC_QUEUE1 = "tut.rpc.requests";
    public static final String TOPIC_QUEUE2 = "ec.request.rpc";
    public static final String TOPIC_EXCHANGE = "ecExchange";

    @Bean(name = "connectionFactory")
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        String host = "10.16.2.1";
        connectionFactory.setHost(host);
        int port = 5672;
        connectionFactory.setPort(port);
        String username = "ec";
        connectionFactory.setUsername(username);
        String password = "ec";
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/ec");
        return connectionFactory;
    }


    //创建队列
    @Bean(TOPIC_QUEUE1)
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1);
    }

    //创建队列
    @Bean(TOPIC_QUEUE2)
    public Queue topicQueue() {
        return new Queue(TOPIC_QUEUE1);
    }

    //创建交换机
    @Bean("ecExchange")
    public TopicExchange topicExchange() {
        return new TopicExchange("ecExchange");
    }

    //交换机与队列进行绑定
    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(TOPIC_QUEUE1);
    }

    @Bean
    public Binding binding(){
        return BindingBuilder.bind(topicQueue()).to(topicExchange()).with(TOPIC_QUEUE2);
    }
}
