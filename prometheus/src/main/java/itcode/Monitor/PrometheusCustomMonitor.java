package itcode.Monitor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import org.springframework.stereotype.Component;

/**
 * @author imp
 * @date 2021/1/21
 */
@Component
public class PrometheusCustomMonitor {

    private Counter counter;

    private Gauge gauge;
}
