package com.meawallet.parkingapp.ui;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.dto.CreateParkingLotRequest;
import com.meawallet.parkingapp.ui.actions.CreateParkingLotAction;
import com.meawallet.parkingapp.ui.converter.CreateParkingLotRequestToDomain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateParkingLotActionTest {
    @Mock
    private UserInput userInput;
    @Mock
    private ParkingLotService parkingLotService;
    @Mock
    private CreateParkingLotRequestToDomain converter;
    @Captor
    private ArgumentCaptor<CreateParkingLotRequest> captor;
    @InjectMocks
    private CreateParkingLotAction createParkingLotAction;
    @Test
    void shouldReturnCreateParkingLotAsActionName () {
        String expectedResult = "Create new Parking Lot";
        String actualResult = createParkingLotAction.getActionName();
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void shouldCallParkingLotServiceToCreateParkingLot() {
        CreateParkingLotRequest request = request();
        when(userInput.getCreateParkingLotRequest()).thenReturn(request);
        when(converter.convert(request)).thenReturn(parkingLot());

        createParkingLotAction.execute();

        verify(userInput).getCreateParkingLotRequest();
        verify(converter).convert(captor.capture());

        CreateParkingLotRequest capturedRequest = captor.getValue();
        assertNotNull(capturedRequest);
        assertNotNull(capturedRequest.getName());
        assertNotNull(capturedRequest.getSlotCount());
        assertEquals("TestLot", capturedRequest.getName());
        assertEquals(50, capturedRequest.getSlotCount());
        assertEquals(50, capturedRequest.getEmptySlots());

        verify(parkingLotService).createParkingLot(parkingLot());
      //  verify(parkingLotService).createParkingLotWithSlots(parkingLot());
    }

    private CreateParkingLotRequest request() {
        return new CreateParkingLotRequest("TestLot",50,50);
    }

    private ParkingLot parkingLot( ) {
        return ParkingLot.builder()
                .name("TestLot")
                .slotCount(50)
                .emptySlots(50)
                .build();
    }
}
