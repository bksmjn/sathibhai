 	 	 	package com.codebhatti.sathibhai.configuration;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.codebhatti.sathibhai*"})
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	public MvcConfig(){
		System.out.println("INSIDE MVCCONFIG");
	}

	
	  @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    }
	 
	    @Override
	    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	        configurer.enable();
	    }
	 
	    @Bean
	    public InternalResourceViewResolver jspViewResolver() {
	        InternalResourceViewResolver bean = new InternalResourceViewResolver();
	        bean.setPrefix("/WEB-INF/views/");
	        bean.setSuffix(".jsp");
	        return bean;
	    }
	 
	    @Bean(name = "messageSource")
	    public ReloadableResourceBundleMessageSource getMessageSource() {
	        ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
	        resource.setBasename("classpath:messages");
	        resource.setDefaultEncoding("UTF-8");
	        return resource;
	    }
	    

		@Override
		public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
			Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
			builder.indentOutput(true).dateFormat(new SimpleDateFormat("yyyy-MM-dd"));
			converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
			converters.add(new MappingJackson2XmlHttpMessageConverter(builder.createXmlMapper(true).build()));
		}
}
