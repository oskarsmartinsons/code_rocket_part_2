package com.meawallet.parkingapp.ui;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.dto.UpdateParkingLotRequest;
import com.meawallet.parkingapp.ui.actions.UpdateParkingLotAction;
import com.meawallet.parkingapp.ui.converter.UpdateParkingLotRequestToDomain;
import org.hibernate.service.spi.InjectService;
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
public class UpdateParkingLotActionTest {
    @Mock
    private UserInput userInput;
    @Mock
    private ParkingLotService parkingLotService;
    @Mock
    private UpdateParkingLotRequestToDomain updateParkingLotRequestToDomain;
    @Captor
    private ArgumentCaptor<UpdateParkingLotRequest> captorForRequest;
    @InjectMocks
    private UpdateParkingLotAction updateParkingLotAction;

    @Test
    void shouldReturnUpdateParkingLotAsActionName(){
        String expectedResult= "Update Parking Lot by Id" ;
        String actualResult = updateParkingLotAction.getActionName();
        assertEquals(expectedResult,actualResult);
    }
    @Test
    void shouldCallParkingLotServiceToUpdateParkingLot() {
        var requestIdNumber = 1;
        var testParkingLot = parkingLotBeforeUpdate();
        var updateRequest = request();
        var updatedParkingLot = parkingLotAfterUpdate();

        when(userInput.requestIdNumber()).thenReturn(requestIdNumber);
        when(parkingLotService.findParkingLotById(requestIdNumber)).thenReturn(testParkingLot);
        when(userInput.getUpdateParkingLotRequest(testParkingLot)).thenReturn(updateRequest);
        when(updateParkingLotRequestToDomain.convert(updateRequest)).thenReturn(updatedParkingLot);

        updateParkingLotAction.execute();

        verify(userInput).requestIdNumber();
        verify(parkingLotService).findParkingLotById(requestIdNumber);
        verify(userInput).getUpdateParkingLotRequest(testParkingLot);
        verify(updateParkingLotRequestToDomain).convert(captorForRequest.capture());

        var capturedRequest = captorForRequest.getValue();
        assertEquals("UPDATED NAME", capturedRequest.getName());

        verify(parkingLotService).updateParkingLot(parkingLotAfterUpdate());
    }

    private ParkingLot parkingLotBeforeUpdate() {
        return ParkingLot.builder()
                .id(1)
                .name("Test")
                .slotCount(10)
                .emptySlots(10)
                .build();
    }

    private UpdateParkingLotRequest request() {
        return new UpdateParkingLotRequest(
                1,
                "UPDATED NAME",
                10,
                10);
    }
    private ParkingLot parkingLotAfterUpdate() {
        return ParkingLot.builder()
                .id(1)
                .name("UPDATED NAME")
                .slotCount(10)
                .emptySlots(10)
                .build();
    }






}
