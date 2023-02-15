package com.thommache.springboot.app.components;

import com.thommache.springboot.app.dto.CalificacionResponse;
import com.thommache.springboot.app.repositories.CalificacionRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;


import java.io.IOException;
import java.util.Date;

@Component
public class TransactionFilter implements Filter {

    private CalificacionRepository repository;

    @Autowired
    public TransactionFilter(CalificacionRepository transactionsRepository){
        this.repository = transactionsRepository;
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        if(!requestWrapper.getRequestURI().contains("/api/v1/credit")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        filterChain.doFilter(requestWrapper, responseWrapper);

        String requestBody = new String(requestWrapper.getContentAsByteArray());
        String responseBody = new String(responseWrapper.getContentAsByteArray());

      //  CalificacionResponse response = new CalificacionResponse(responseBody,responseWrapper.getStatus());
       // CalificacionResponse request = new CalificacionResponse(new Date(),requestBody,requestWrapper.getRequestURI(),response);

     //   repository.save(request);

        responseWrapper.copyBodyToResponse();

    }



    @Override
    public void destroy() {

    }


}
