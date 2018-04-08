package com.ryantenney.metrics.spring;

import com.codahale.metrics.Counter;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author yaoqijun on 2018-04-08.
 */
public class CounterExtend extends Counter{

    private final LongAdder count;  // jdk long adder 应为Metric 不兼容对应LongAdder 类型

    public CounterExtend() {
        this.count = new LongAdder();
    }

    /**
     * Increment the counter by one.
     */
    public void inc() {
        inc(1);
    }

    /**
     * Increment the counter by {@code n}.
     *
     * @param n the amount by which the counter will be increased
     */
    public void inc(long n) {
        count.add(n);
    }

    /**
     * Decrement the counter by one.
     */
    public void dec() {
        dec(1);
    }

    /**
     * Decrement the counter by {@code n}.
     *
     * @param n the amount by which the counter will be decreased
     */
    public void dec(long n) {
        count.add(-n);
    }

    /**
     * Returns the counter's current value.
     *
     * @return the counter's current value
     */
    @Override
    public long getCount() {
        return count.sumThenReset();
    }
}
