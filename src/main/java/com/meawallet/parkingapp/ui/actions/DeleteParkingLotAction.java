package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.ui.MenuActions;
import com.meawallet.parkingapp.ui.MenuName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteParkingLotAction implements MenuActions {
    private final ParkingLotService parkingLotService;

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
        return "Delete Parking Lot";
    }

    @Override
    public void execute() {
        var parkingLot = parkingLotService.findParkingLotById(1);
        parkingLotService.deleteParkingLot(parkingLot);
        System.out.println("Deleted: " + parkingLot);
    }
}
