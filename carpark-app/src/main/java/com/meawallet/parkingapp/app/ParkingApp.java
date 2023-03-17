package com.meawallet.parkingapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.meawallet")
public class ParkingApp {
	public static void main(String[] args) {
		SpringApplication.run(ParkingApp.class);
	}
}
