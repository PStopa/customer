package com.customer;

import com.customer.domain.Customer;
import com.customer.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class CustomerApplication {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			repository.save(new Customer(1234L, "Jan", "Kowalski"));
		};
	}

}
