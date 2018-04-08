package com.ryantenney.metrics.spring;

import com.codahale.metrics.MetricRegistry;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.util.ReflectionUtils.MethodFilter;

import java.lang.reflect.Method;

import static com.ryantenney.metrics.spring.AnnotationFilter.PROXYABLE_METHODS;

/**
 * @author yaoqijun on 2018-04-08.
 */
public class CountedExtendMethodInterceptor extends AbstractMetricMethodInterceptor<CountedExtend, CounterExtend>{

    public static final Class<CountedExtend> ANNOTATION = CountedExtend.class;
    public static final Pointcut POINTCUT = new AnnotationMatchingPointcut(null, ANNOTATION);
    public static final MethodFilter METHOD_FILTER = new AnnotationFilter(ANNOTATION, PROXYABLE_METHODS);

    public CountedExtendMethodInterceptor(MetricRegistry metricRegistry, Class<?> targetClass) {
        super(metricRegistry, targetClass, ANNOTATION, METHOD_FILTER);
    }

    @Override
    protected String buildMetricName(Class<?> targetClass, Method method, CountedExtend annotation) {
        return Util.chooseName(annotation.name(), annotation.absolute(), targetClass, method);
    }

    @Override
    protected CounterExtend buildMetric(MetricRegistry metricRegistry, String metricName, CountedExtend annotation) {
        return metricRegistry.register(metricName, new CounterExtend());
    }

    @Override
    protected Object invoke(MethodInvocation invocation, CounterExtend metric, CountedExtend annotation) throws Throwable {
        try {
            metric.inc();
            return invocation.proceed();
        }
        finally {
            if (!annotation.monotonic()) {
                metric.dec();
            }
        }
    }

    public static AdviceFactory adviceFactory(final MetricRegistry metricRegistry) {
        return new AdviceFactory() {
            @Override
            public Advice getAdvice(Object bean, Class<?> targetClass) {
                return new CountedExtendMethodInterceptor(metricRegistry, targetClass);
            }
        };
    }
}
