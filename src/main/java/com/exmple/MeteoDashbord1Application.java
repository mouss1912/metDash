package com.exmple;


import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@PropertySource("classpath:application.properties")
@Transactional
@EnableScheduling
@SpringBootApplication
public class MeteoDashbord1Application {

	public static void main(String[] args) {
		SpringApplication.run(MeteoDashbord1Application.class, args);
	}
	
	@Bean
	public RestTemplate restTemplateMain(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	/*
	@Bean
	public ConnectionProvider connectionProvider() {
	    return ConnectionProvider.builder("Auto refresh & no connection limit")
		    .maxIdleTime(Duration.ofSeconds(10))
		    .maxConnections(500)
		    .pendingAcquireMaxCount(-1)
		    .build();
	}

	@Bean
	public HttpClient httpClient(ConnectionProvider connectionProvider) {
		return HttpClient.create(connectionProvider)
                  .compress(true)
                  .resolver(DefaultAddressResolverGroup.INSTANCE);
	}

*/
}
