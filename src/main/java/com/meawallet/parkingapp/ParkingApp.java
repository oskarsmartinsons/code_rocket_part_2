package com.meawallet.parkingapp;

import com.meawallet.parkingapp.ui.UserMenu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ParkingApp {
	public static void main(String[] args) {
		var annotation = new AnnotationConfigApplicationContext("com.meawallet.parkingapp");
		var userMenu = annotation.getBean(UserMenu.class);
		userMenu.startMenu();
	}

}
