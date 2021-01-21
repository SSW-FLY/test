package itcode.monitor;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.MeterRegistry;

/**
 * @author imp
 * @date 2021/1/21
 */
public class PrometheusCustomMonitor {
    /**
     * 订单发起次数
     */
    private Counter orderCount;

    /**
     * 金额统计
     */
    private DistributionSummary amountSum;

    private final MeterRegistry registry;

    public PrometheusCustomMonitor(Counter orderCount,
        DistributionSummary amountSum, MeterRegistry registry) {
        this.orderCount = orderCount;
        this.amountSum = amountSum;
        this.registry = registry;
    }
}
