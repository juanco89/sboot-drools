package com.boot.endpoint.rest;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityFilter implements Filter {

  public static final String AUTHENTICATION_HEADER = "token";
  

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter) throws IOException, ServletException {
    
    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    String authCredentials = httpServletRequest.getHeader(AUTHENTICATION_HEADER);
    
    if (authCredentials != null) {
      filter.doFilter(request, response);
    } else {
      HttpServletResponse httpServletResponse = (HttpServletResponse) response;
      httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
  }
  

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }

}
