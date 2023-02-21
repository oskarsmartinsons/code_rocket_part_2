package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.ui.MenuActions;
import com.meawallet.parkingapp.ui.MenuName;
import com.meawallet.parkingapp.ui.SubMenuActions;
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
    public String getName() {
        return "Return";
    }

    @Override
    public void execute() {

    }
}
