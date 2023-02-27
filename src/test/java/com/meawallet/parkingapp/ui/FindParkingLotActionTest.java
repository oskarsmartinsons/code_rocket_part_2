package com.meawallet.parkingapp.ui;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.dto.CreateParkingLotRequest;
import com.meawallet.parkingapp.ui.actions.FindParkingLotAction;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@MockitoSettings
public class FindParkingLotActionTest {
    @Mock
    private UserInput userInput;
    @Mock
    private ParkingLotService parkingLotService;
    @Captor
    private ArgumentCaptor<Integer> captor;
    @InjectMocks
    private FindParkingLotAction findParkingLotAction;

    @Test
    void shouldReturnFindParkingLotAsActionName(){
        String expectedResult= "Find Parking Lot by Id" ;
        String actualResult = findParkingLotAction.getActionName();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    void shouldCallParkingLotServiceToFindParkingLot() {
        var requestIdNumber = 1;
        when(userInput.requestIdNumber()).thenReturn(requestIdNumber);

        findParkingLotAction.execute();

        verify(userInput).requestIdNumber();
        verify(parkingLotService).findParkingLotById(captor.capture());

        var capturedId = captor.getValue();
        assertEquals(1, capturedId);
    }

    private ParkingLot parkingLot() {
        return ParkingLot.builder()
                .id(1)
                .name("Test")
                .slotCount(10)
                .emptySlots(10)
                .build();
    }
}
