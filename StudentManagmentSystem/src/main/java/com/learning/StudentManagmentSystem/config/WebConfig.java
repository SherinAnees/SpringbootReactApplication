package com.learning.StudentManagmentSystem.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("http://localhost:5173") // Allow this origin, adjust if your frontend is served from a different port
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
