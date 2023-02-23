package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.ui.MenuActions;
import com.meawallet.parkingapp.ui.MenuName;
import org.springframework.stereotype.Component;

@Component
public class ReturnSubAction implements MenuActions {
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
        return MenuName.SUB;
    }

    @Override
    public String getActionName() {
        return "Return";
    }

    @Override
    public void execute() {

    }
}
