package com.meawallet.parkingapp.in.actions;

import com.meawallet.parkingapp.core.port.in.ShowParkingLotsUseCase;
import com.meawallet.parkingapp.in.MenuActions;
import com.meawallet.parkingapp.in.MenuName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShowParkingLotAction implements MenuActions {
    private final ShowParkingLotsUseCase showParkingLotsUseCase;
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
        return "Show My Parking Lots";
    }

    @Override
    public void execute() {
        System.out.println("\nMy Parking Lots:");
        showParkingLotsUseCase.showParkingLots();
    }
}
