package com.meawallet.parkingapp.in.actions;

import com.meawallet.parkingapp.core.port.in.DeleteParkingLotUseCase;
import com.meawallet.parkingapp.core.port.in.FindParkingLotUseCase;
import com.meawallet.parkingapp.in.MenuActions;
import com.meawallet.parkingapp.in.MenuName;
import com.meawallet.parkingapp.in.UserInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteParkingLotAction implements MenuActions {
    private final UserInput userInput;
    private final DeleteParkingLotUseCase deleteParkingLotUseCase;
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
        return "Delete Parking Lot";
    }

    @Override
    public void execute() {
        var id = userInput.requestIdNumber();
        var parkingLot = findParkingLotUseCase.findParkingLot(id);
        deleteParkingLotUseCase.deleteParkingLot(parkingLot);
        System.out.println("DELETED Parking Lot with Id: " + id);
    }
}
