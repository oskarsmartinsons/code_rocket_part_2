package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.ui.MenuAction;
import com.meawallet.parkingapp.ui.UserInput;
import com.meawallet.parkingapp.ui.converter.CreateParkingLotRequestToDomain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FindParkingLotAction implements MenuAction {
    UserInput userInput;
    ParkingLotService parkingLotService;
    CreateParkingLotRequestToDomain converter;
    @Override
    public String getName() {
        return "Find Parking Lot by Id";
    }

    @Override
    public void execute() {
        var id = userInput.requestIdNumber();
        var parkingLot = parkingLotService.findById(id);
        System.out.println("Search result: " + parkingLot);
    }
}
