package com.spring.cloud.microservices.course.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoggingFilter extends ZuulFilter {

    private Logger _log = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public String filterType() {
//        "pre"
//        "post"
//        "error"

        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();


        _log.info("Request URI -> {} ----- Request -> {}", request.getRequestURI(), request);

        return null;
    }
}
