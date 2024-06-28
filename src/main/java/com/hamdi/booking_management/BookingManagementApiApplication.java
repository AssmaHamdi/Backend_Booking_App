package com.hamdi.booking_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookingManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingManagementApiApplication.class, args);
	}

}
