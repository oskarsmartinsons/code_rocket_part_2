package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.ui.MenuActions;
import com.meawallet.parkingapp.ui.MenuName;
import com.meawallet.parkingapp.ui.UserInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindParkingLotAction implements MenuActions {
    UserInput userInput;
    ParkingLotService parkingLotService;

    @Override
    public boolean hasSubMenu() {
        return false;
    }

    @Override
    public MenuName getSubMenuName() {
        return null;
    }

    @Override
    public MenuName getMenuAppearanceName() {
        return MenuName.MAIN;
    }

    @Override
    public String getName() {
        return "Find Parking Lot by Id";
    }

    @Override
    public void execute() {
        var lotId = userInput.requestIdNumber();
        var parkingLot = parkingLotService.findById(lotId);
        System.out.println("Search result: \n" + parkingLot);
        System.out.println("----------- SLOTS --------------");
        parkingLotService.showParkingSlotsByParkingLotId(lotId);
    }
}
