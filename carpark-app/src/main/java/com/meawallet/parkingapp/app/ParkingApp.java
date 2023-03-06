package com.meawallet.parkingapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.meawallet")
public class ParkingApp {
	public static void main(String[] args) {
		SpringApplication.run(ParkingApp.class);
	}
}
