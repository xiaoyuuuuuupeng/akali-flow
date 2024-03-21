package com.sqg.flow.ui;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

@Configuration
public class CustomWebServerConfig {

    @Bean
    public ServletRegistrationBean customServlet() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CustomServlet(), "/custom");
        return registration;
    }

    @Bean
    public ServletListenerRegistrationBean<CustomServletContextListener> customListener() {
        ServletListenerRegistrationBean<CustomServletContextListener> registration = new ServletListenerRegistrationBean<>(new CustomServletContextListener());
        return registration;
    }

    private static class CustomServlet implements Servlet {
        @Override
        public void init(ServletConfig config) throws ServletException {
            System.out.println("CustomServlet initialized");
        }

        @Override
        public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
            System.out.println("CustomServlet called");
        }

        @Override
        public void destroy() {
            System.out.println("CustomServlet destroyed");
        }

        @Override
        public ServletConfig getServletConfig() {
            return null;
        }

        @Override
        public String getServletInfo() {
            return null;
        }
    }

    private static class CustomServletContextListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            System.out.println("ServletContext initialized");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            System.out.println("ServletContext destroyed");
        }
    }
}