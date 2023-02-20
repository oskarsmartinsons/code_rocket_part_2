package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.ui.MenuAction;
import org.springframework.stereotype.Component;

@Component
public class SettingsAction implements MenuAction {
    @Override
    public String getName() {
        return "Settings";
    }

    @Override
    public void execute() {
        System.out.println("Settings");
    }
}
