package com.meawallet.parkingapp.in.actions;

import com.meawallet.parkingapp.core.port.in.FindParkingLotUseCase;
import com.meawallet.parkingapp.in.MenuActions;
import com.meawallet.parkingapp.in.MenuName;
import com.meawallet.parkingapp.in.UserInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindParkingLotAction implements MenuActions {
    UserInput userInput;
    private final FindParkingLotUseCase findParkingLotUseCase;

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
        return "Find Parking Lot by Id";
    }

    @Override
    public void execute() {
        var lotId = userInput.requestIdNumber();
        var parkingLot = findParkingLotUseCase.findParkingLot(lotId);
        System.out.println("Search result: \n" + parkingLot);
      //  System.out.println("----------- SLOTS --------------");
      //  parkingLotService.showParkingSlotsByParkingLotId(lotId);
    }
}
