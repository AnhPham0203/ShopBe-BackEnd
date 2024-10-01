package com.vin.shopbe.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**").allowedOrigins("http://localhost:3000") // Cho phép truy cập từ localhost:3000
				.allowedMethods("GET", "POST", "PUT", "DELETE") // Các phương thức HTTP được cho phép
				.allowedHeaders("*") // Cho phép tất cả các headers
				.allowCredentials(true);
	}

}
