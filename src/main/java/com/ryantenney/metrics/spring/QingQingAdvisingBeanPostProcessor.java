package com.ryantenney.metrics.spring;

import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyConfig;

/**
 * @author yaoqijun on 2018-04-08.
 * 不兼容， 也许真的不应该这么搞, 扩展性不好
 */
public class QingQingAdvisingBeanPostProcessor extends AdvisingBeanPostProcessor{
    public QingQingAdvisingBeanPostProcessor(Pointcut pointcut, AdviceFactory adviceFactory, ProxyConfig proxyConfig) {
        super(pointcut, adviceFactory, proxyConfig);
    }
}
