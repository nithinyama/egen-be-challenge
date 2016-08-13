package com.app.main;

import javax.inject.Named;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.app.dao.SensorDAO;

@Configuration
public class ApplicationConfig {
	@Named
	static class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
	this.packages("com.app.services");
	}
	}
	@Bean
	public RestTemplate restTemplate() {
	RestTemplate restTemplate = new RestTemplate();
	return restTemplate;
	}
	
	@Bean
	public SensorDAO sensorDAO() {
		SensorDAO sensorDao = new SensorDAO();
		return sensorDao;
	}
}