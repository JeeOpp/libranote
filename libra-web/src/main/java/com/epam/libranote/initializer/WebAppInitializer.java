package com.epam.libranote.initializer;


import com.epam.libranote.configuration.LogicAppConfiguration;
import com.epam.libranote.configuration.WebAppConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext configWebApplicationContext = new AnnotationConfigWebApplicationContext();
        configWebApplicationContext.register(LogicAppConfiguration.class, WebAppConfiguration.class);
        configWebApplicationContext.setServletContext(servletContext);
        configWebApplicationContext.refresh();

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(
                "dispatcher",
                new DispatcherServlet(configWebApplicationContext)
        );
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/api/*");

    }
}
