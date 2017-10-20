package com.watent.log.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class LogFilter extends GenericFilterBean {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    private static final String ANONYMOUS_USER = "anonymousUser";

    private LogFilterProperties logFilterProperties;

    public LogFilter(LogFilterProperties logFilterProperties) {
        this.logFilterProperties = logFilterProperties;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

//        if (null == SecurityContextHolder.getContext().getAuthentication()) {
//            chain.doFilter(request, response);
//        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String value = principal.toString();
        if (logger.isDebugEnabled()) {
            logger.debug("MDC put key:{},value:{}", logFilterProperties.getKey(), value);
        }
        if (!ANONYMOUS_USER.equals(value)) {
            MDC.put(logFilterProperties.getKey(), value);
        }
        chain.doFilter(request, response);
        if (logger.isDebugEnabled()) {
            logger.debug("MDC clear");
        }

        try {
            //nothing
        } finally {
            MDC.clear();
        }
    }
}