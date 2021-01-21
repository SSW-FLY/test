package itcode.Monitor;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author imp
 * @date 2021/1/21
 */
@Component
public class PrometheusCustomMonitor {

    private final MeterRegistry registry;

    @Autowired
    public PrometheusCustomMonitor(MeterRegistry meterRegistry) {
        this.registry = meterRegistry;
    }

    public void setLongGauge(Long v) {
        registry.gauge("LongGauge", v, Long::doubleValue);
    }
}
