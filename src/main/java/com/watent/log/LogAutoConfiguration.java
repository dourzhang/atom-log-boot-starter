package com.watent.log;

import com.watent.log.filter.LogFilter;
import com.watent.log.filter.LogFilterProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Atom log autoConfiguration
 */
@Configuration
@ConditionalOnClass(LogFilter.class)
@EnableConfigurationProperties(LogFilterProperties.class)
public class LogAutoConfiguration {

    @Resource
    private LogFilterProperties logFilterProperties;

    @Bean
    @ConditionalOnMissingBean(LogFilter.class)
//    @ConditionalOnProperty(prefix = "atom.log", value = "key",havingValue = "account")
    public LogFilter logFilter() {
        return new LogFilter(logFilterProperties);
    }
}
