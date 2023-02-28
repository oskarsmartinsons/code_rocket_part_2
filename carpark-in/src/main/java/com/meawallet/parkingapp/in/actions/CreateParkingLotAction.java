package com.meawallet.parkingapp.in.actions;

import com.meawallet.parkingapp.core.port.in.SaveParkingLotUseCase;
import com.meawallet.parkingapp.in.MenuActions;
import com.meawallet.parkingapp.in.MenuName;
import com.meawallet.parkingapp.in.UserInput;
import com.meawallet.parkingapp.in.converter.CreateParkingLotRequestToDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateParkingLotAction implements MenuActions {
    UserInput userInput;
    private final SaveParkingLotUseCase saveParkingLotUseCase;
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
    public String getActionName() {
        return "Create new Parking Lot";
    }

    @Override
    public void execute() {
        var request = userInput.getCreateParkingLotRequest();
        var lot = converter.convert(request);
        saveParkingLotUseCase.saveParkingLot(lot);
        System.out.println("CREATED");
    }
}
