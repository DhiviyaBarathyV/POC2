package com.bookdetailsMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookdetailsMicroServiceApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(BookdetailsMicroServiceApplication.class, args);
	}

}
