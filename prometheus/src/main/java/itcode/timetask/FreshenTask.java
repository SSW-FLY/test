package itcode.timetask;

import com.rabbitmq.client.Channel;
import itcode.Monitor.PrometheusCustomMonitor;
import java.io.IOException;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author imp
 * @date 2021/1/21
 */
@Component
public class FreshenTask {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private PrometheusCustomMonitor monitor;

    @Scheduled(cron = "")
    @SchedulerLock(name = "HMA_DAILY_MONITOR_LOCK", lockAtLeastFor = 5000, lockAtMostFor = 10000)
    public void task() {
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
}
