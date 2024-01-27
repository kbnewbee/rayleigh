package com.kaybee.web;

import com.kaybee.AppConfiguration;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletResponse;

@WebListener
@WebFilter
public final class DASHConfiguration implements ServletContextListener, Filter {

  private AppConfiguration appConfiguration = null;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletResponse responseWithHeader = (HttpServletResponse) servletResponse;
    responseWithHeader.setHeader("Access-Control-Allow-Origin", "*");

    filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {
  }

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    ServletContext servletContext = sce.getServletContext();
    this.initRayleigh(servletContext);
    this.init();
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
  }

  private void initRayleigh(ServletContext servletContext) {
    appConfiguration = new AppConfiguration();
  }

  private static void init() {
  }
}
