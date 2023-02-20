package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.ui.MenuAction;
import com.meawallet.parkingapp.ui.UserInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShowParkingLotAction implements MenuAction {
    ParkingLotService parkingLotService;

    @Override
    public String getName() {
        return "Show My Parking Lots";
    }

    @Override
    public void execute() {
        parkingLotService.showParkingLots();
    }
}
