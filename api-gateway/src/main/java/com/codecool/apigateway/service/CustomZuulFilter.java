package com.codecool.apigateway.service;

import com.codecool.apigateway.security.JwtTokenServices;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

@Component
public class CustomZuulFilter extends ZuulFilter {
    @Autowired
    private JwtTokenServices jwtTokenServices;

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = jwtTokenServices.getTokenFromRequest(request);
        String username = jwtTokenServices.getUsernameFromJwtToken(token);
        context.addZuulRequestHeader("username", username);
        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 10;
    }
}
