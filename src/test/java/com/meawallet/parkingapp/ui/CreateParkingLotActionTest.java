package com.meawallet.parkingapp.ui;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.ui.actions.CreateParkingLotAction;
import com.meawallet.parkingapp.ui.converter.CreateParkingLotRequestToDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CreateParkingLotActionTest {
    @Mock
    UserInput userInput;

    @Mock
    ParkingLotService parkingLotService;

    @Mock
    CreateParkingLotRequestToDomain converter;

    @InjectMocks
    CreateParkingLotAction createParkingLotAction;

    @Test
    void shouldReturnCreateParkingLotAsActionName () {
        String expectedResult = "Create new Parking Lot";
        String actualResult = createParkingLotAction.getName();
        assertEquals(expectedResult, actualResult);
    }


}
