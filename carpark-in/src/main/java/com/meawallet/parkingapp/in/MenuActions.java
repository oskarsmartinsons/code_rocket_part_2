package com.meawallet.parkingapp.in;

public interface MenuActions {
    boolean hasSubMenu();
    MenuName getSubMenuName();
    MenuName getMenuAppearanceName();
    String getActionName();
    void execute();
}
