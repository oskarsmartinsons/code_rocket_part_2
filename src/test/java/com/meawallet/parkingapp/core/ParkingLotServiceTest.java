package com.meawallet.parkingapp.core;

import com.meawallet.parkingapp.database.ParkingLotRepository;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.ui.exceptions.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@MockitoSettings
public class ParkingLotServiceTest {
    @Mock
    private ParkingLotRepository parkingLotRepository;
    @Mock
    private ParkingLot parkingLot;
    @InjectMocks
    ParkingLotService victim;
    @Test
    void shouldThrowExceptionIfParkingLotNotFound() {
        when(parkingLotRepository.getParkingLotById(1)).thenReturn(Optional.empty());

        var exception = assertThrows(EntityNotFoundException.class, () -> victim.findParkingLotById(1));
        assertEquals("Parking Lot not Found", exception.getMessage());
    }
    @Test
    void shouldReturnParkingLotIfFound() {
        when(parkingLotRepository.getParkingLotById(1)).thenReturn(Optional.of(parkingLot));

        var actual = victim.findParkingLotById(1);
        assertNotNull(actual);
    }
    @Test
    void shouldThrowIllegalArgumentExceptionIfArgIsNullForFindParkingLot(){
        var exception = assertThrows(IllegalArgumentException.class, () -> victim.findParkingLotById(null));
        assertEquals("Id arg is invalid", exception.getMessage());
    }

    @Test
    void shouldCreateParkingLot(){
        var testParkingLot = parkingLot();
        victim.createParkingLot(testParkingLot);
        verify(parkingLotRepository).save(testParkingLot);
    }
    private ParkingLot parkingLot() {
        return ParkingLot.builder()
                .name("TestLot")
                .slotCount(50)
                .emptySlots(50)
                .build();
    }
    @Test
    void shouldThrowIllegalArgumentExceptionIfArgIsNullForCreateParkingLot(){
        var exception = assertThrows(IllegalArgumentException.class, () -> victim.createParkingLot(null));
        assertEquals("ParkingLot arg is invalid", exception.getMessage());
    }

    @Test
    void shouldUpdateParkingLot() {
        var testParkingLot = parkingLot();
        victim.updateParkingLot(testParkingLot);
        verify(parkingLotRepository).update(testParkingLot);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIsArgIsNullForUpdateParkingLot(){
        var exception = assertThrows(IllegalArgumentException.class, () -> victim.updateParkingLot(null));
        assertEquals("ParkingLot arg is invalid", exception.getMessage());
    }

    @Test
    void shouldDeleteParkingLot() {
        var testParkingLot = parkingLot();
        victim.deleteParkingLot(testParkingLot);
        verify(parkingLotRepository).delete(testParkingLot);
    }

    @Test
    void shouldThrowIllegalArgumentExceptionIsArgIsNullForDeleteParkingLot(){
        var exception = assertThrows(IllegalArgumentException.class, () -> victim.deleteParkingLot(null));
        assertEquals("ParkingLot arg is invalid", exception.getMessage());
    }

    @Test
    void shouldShowParkingLots(){
      //  var parkingLotList = List.of(parkingLot(), parkingLot());
      //  when(parkingLotRepository.getAllParkingLots()).thenReturn(parkingLotList);
        victim.showParkingLots();
        verify(parkingLotRepository).getAllParkingLots();

       //  how to verify if list was printed out?
    }
}
