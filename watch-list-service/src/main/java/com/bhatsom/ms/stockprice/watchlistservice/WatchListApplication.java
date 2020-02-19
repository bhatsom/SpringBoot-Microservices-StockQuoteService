package com.bhatsom.ms.stockprice.watchlistservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.bhatsom.ms.stockprice.watchlistservice.repository")
@SpringBootApplication
public class WatchListApplication {

	public static void main(String[] args) {
		SpringApplication.run(WatchListApplication.class, args);
	}
}
