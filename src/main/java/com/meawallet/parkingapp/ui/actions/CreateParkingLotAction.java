package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.database.ParkingLotRepository;
import com.meawallet.parkingapp.dto.CreateParkingLotRequest;
import com.meawallet.parkingapp.ui.MenuAction;
import com.meawallet.parkingapp.ui.UserInput;
import com.meawallet.parkingapp.ui.converter.CreateParkingLotRequestToDomain;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreateParkingLotAction implements MenuAction {
    UserInput userInput;
    ParkingLotService parkingLotService;
    CreateParkingLotRequestToDomain converter;

    @Override
    public String getName() {
        return "Create new Parking Lot";
    }

    @Override
    public void execute() {
        var request = userInput.getCreateParkingLotRequest();
        var domain = converter.convert(request);
        parkingLotService.save(domain);
        System.out.println(domain);
    }
}
