package com.meawallet.parkingapp.in.actions;

import com.meawallet.parkingapp.core.port.in.FindParkingLotUseCase;
import com.meawallet.parkingapp.core.port.in.UpdateParkingLotUseCase;
import com.meawallet.parkingapp.in.MenuActions;
import com.meawallet.parkingapp.in.MenuName;
import com.meawallet.parkingapp.in.UserInput;
import com.meawallet.parkingapp.in.converter.UpdateParkingLotRequestToDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UpdateParkingLotAction implements MenuActions {
    private final UserInput userInput;
    private final UpdateParkingLotUseCase updateParkingLotUseCase;
    private final FindParkingLotUseCase findParkingLotUseCase;
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
    public String getActionName() {
        return "Update Parking Lot by Id";
    }

    @Override
    public void execute() {
        var id = userInput.requestIdNumber();
        var oldParkingLot = findParkingLotUseCase.getParkingLot(id);
        System.out.println("Searched Parking Lot for update: "  + oldParkingLot);
        var updateRequest = userInput.getUpdateParkingLotRequest(oldParkingLot);
        var parkingLotUpdated =  updateParkingLotRequestToDomain.convert(updateRequest);
        updateParkingLotUseCase.update(parkingLotUpdated);
        System.out.println("UPDATED");
    }
}
