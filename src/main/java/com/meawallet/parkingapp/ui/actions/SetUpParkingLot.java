package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.ui.MenuActions;
import com.meawallet.parkingapp.ui.MenuName;
import org.springframework.stereotype.Component;

//@Component
public class SetUpParkingLot implements MenuActions {

    @Override
    public boolean hasSubMenu() {
        return true;
    }

    @Override
    public MenuName getSubMenuName() {
        return MenuName.SUB;
    }

    @Override
    public MenuName getMenuAppearanceName() {
       // return MenuType.SUB;
        return MenuName.MAIN;
    }

    @Override
    public String getName() {
        return "SET UP my Parking Lot";
    }

    @Override
    public void execute() {
        System.out.println("Settings");
    }
}
