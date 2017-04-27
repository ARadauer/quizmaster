package com.radauer;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter
{

    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        ResourceHandlerRegistration resourceHandlerRegistration =
            registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/");
    }
}
