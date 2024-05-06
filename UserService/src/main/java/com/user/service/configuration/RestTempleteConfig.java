package com.user.service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTempleteConfig {

    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
