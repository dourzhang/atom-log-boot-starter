package com.watent.log;

import com.watent.log.filter.AccountFilter;
import com.watent.log.filter.AccountFilterProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * Atom AutoConfiguration
 * <p>
 * Created by Atom on 2017/4/17.
 */
@Configuration
@ConditionalOnClass(AccountFilter.class)
@EnableConfigurationProperties(AccountFilterProperties.class)
public class AtomAutoConfiguration {

    @Resource
    private AccountFilterProperties accountFilterProperties;

    @Bean
    @ConditionalOnMissingBean(AccountFilter.class)
//    @ConditionalOnProperty(prefix = "atom.log", value = "key",havingValue = "account")
    public AccountFilter accountFilter() {
        return new AccountFilter(accountFilterProperties);
    }
}
