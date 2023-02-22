package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.ui.MenuActions;
import com.meawallet.parkingapp.ui.MenuName;
import com.meawallet.parkingapp.ui.UserInput;
import com.meawallet.parkingapp.ui.converter.CreateParkingLotRequestToDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateParkingLotAction implements MenuActions {
    UserInput userInput;
    ParkingLotService parkingLotService;
    CreateParkingLotRequestToDomain converter;

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
        return "Create new Parking Lot";
    }

    @Override
    public void execute() {
        var request = userInput.getCreateParkingLotRequest();
        var lot = converter.convert(request);
        System.out.println("Parking Lot unit: ");
        parkingLotService.createParkingLot(lot);
        System.out.println(lot);
/*        System.out.println("Parking Lot with slots: ");
        parkingLotService.createParkingLotWithSlots(lot);
        System.out.println(lot);*/
    }
}
