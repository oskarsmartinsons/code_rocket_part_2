package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.dto.UpdateParkingLotRequest;
import com.meawallet.parkingapp.ui.MenuActions;
import com.meawallet.parkingapp.ui.MenuName;
import com.meawallet.parkingapp.ui.UserInput;
import com.meawallet.parkingapp.ui.converter.UpdateParkingLotRequestToDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateParkingLotAction implements MenuActions {
    private final UserInput userInput;
    private final ParkingLotService parkingLotService;
    private final UpdateParkingLotRequestToDomain updateParkingLotRequestToDomain;
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
    public String getName() {
        return "Update Parking Lot by Id";
    }

    @Override
    public void execute() {
        var id = userInput.requestIdNumber();
        System.out.println("Parking Lot: " );
        var parkingLot = parkingLotService.findParkingLotById(id);
        var updateRequest = userInput.getUpdateParkingLotRequest();
        var parkingLotUpdated =  updateParkingLotRequestToDomain.convert(updateRequest);
        parkingLotService.updateParkingLot(parkingLotUpdated);
        System.out.println(parkingLotService.findParkingLotById(id));
    }
}
