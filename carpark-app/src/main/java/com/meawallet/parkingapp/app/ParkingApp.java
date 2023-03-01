package com.meawallet.parkingapp.app;

//import com.meawallet.parkingapp.in.UserMenu;
// import com.meawallet.parkingapp.ui.UserMenu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "com.meawallet",
		exclude = HibernateJpaAutoConfiguration.class)

public class ParkingApp {
	public static void main(String[] args) {
		SpringApplication.run(ParkingApp.class);
	}
}
