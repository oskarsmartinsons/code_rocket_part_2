package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.ui.MenuAction;
import com.meawallet.parkingapp.ui.UserInput;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
public class CreateParkingLotAction implements MenuAction {
    UserInput userInput;

    @Override
    public String getName() {
        return "Create new Parking Lot";
    }

    @Override
    public void execute() {
        System.out.println("Create Parking Lot is running");
        System.out.println(userInput.getCreateParkingLotRequest());


    }
}
