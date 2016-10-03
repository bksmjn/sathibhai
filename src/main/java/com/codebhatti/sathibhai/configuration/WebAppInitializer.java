package com.codebhatti.sathibhai.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
 
@Configuration
public class WebAppInitializer implements WebApplicationInitializer {
	
	
	public WebAppInitializer(){
		System.out.println("INSIDE WEBAPPINITIALIZER");
	}
 
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(MvcConfig.class);
        ServletRegistration.Dynamic dispatcher = (servletContext).addServlet(
                "SpringDispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
         
    }
}