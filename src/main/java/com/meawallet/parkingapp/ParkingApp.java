package com.meawallet.parkingapp;

import com.meawallet.parkingapp.ui.UserInput;
import com.meawallet.parkingapp.ui.actions.CreateParkingLotAction;
import com.meawallet.parkingapp.ui.MenuAction;
import com.meawallet.parkingapp.ui.UserMenu;
import com.meawallet.parkingapp.ui.actions.ExitAction;
import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

public class ParkingApp {
	public static void main(String[] args) {
		UserInput userInput = new UserInput();
		List<MenuAction> menuActionList = List.of(
				new CreateParkingLotAction(userInput),
				new ExitAction()
		);

		UserMenu userMenu = new UserMenu(userInput, menuActionList);
		userMenu.startMenu();
	}

}
