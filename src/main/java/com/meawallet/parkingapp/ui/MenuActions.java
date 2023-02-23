package com.meawallet.parkingapp.ui;

public interface MenuActions {
    boolean hasSubMenu();
    MenuName getSubMenuName();
    MenuName getMenuAppearanceName();
    String getActionName();
    void execute();
}
