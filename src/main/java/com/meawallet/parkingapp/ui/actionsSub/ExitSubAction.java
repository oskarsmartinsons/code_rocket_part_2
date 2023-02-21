package com.meawallet.parkingapp.ui.actionsSub;

import com.meawallet.parkingapp.ui.SubMenuActions;
import org.springframework.stereotype.Component;

@Component
public class ExitSubAction implements SubMenuActions {
    @Override
    public String getName() {
        return "Exit";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
