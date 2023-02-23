package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.ui.MenuActions;
import com.meawallet.parkingapp.ui.MenuName;
import org.springframework.stereotype.Component;

@Component
public class ExitAction implements MenuActions {
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
        return "Exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
