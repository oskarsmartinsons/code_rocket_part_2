package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.ui.MenuAction;
import org.springframework.stereotype.Component;

@Component
public class ExitAction implements MenuAction {
    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
