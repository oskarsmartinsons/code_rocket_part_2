package com.meawallet.parkingapp.in.controller;

import com.meawallet.parkingapp.core.DeleteParkingSlotService;
import com.meawallet.parkingapp.core.port.in.DeleteParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.in.FindParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.in.SaveParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.in.UpdateParkingSlotUseCase;
import com.meawallet.parkingapp.core.port.out.SaveParkingSlotPort;
import com.meawallet.parkingapp.in.converter.*;
import com.meawallet.parkingapp.in.dto.*;
import lombok.AllArgsConstructor;
import org.hibernate.sql.Delete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ParkingSlotController {
    private final SaveParkingSlotUseCase saveParkingSlotUseCase;
    private final FindParkingSlotUseCase findParkingSlotUseCase;
    private final DeleteParkingSlotUseCase deleteParkingSlotUseCase;
    private final UpdateParkingSlotUseCase updateParkingSlotUseCase;
    private final CreateParkingSlotInRequestToDomain createParkingSlotInRequestToDomain;
    private final ParkingSlotToCreateParkingSlotInResponseConverter parkingSlotToCreateParkingSlotInResponseConverter;
    private final ParkingSlotToGetParkingSlotInResponseConverter parkingSlotToGetParkingSlotInResponseConverter;
    private final UpdateParkingSlotInRequestToDomain updateParkingSlotInRequestToDomain;
    private final ParkingSlotToUpdateParkingSlotInResponseConverter parkingSlotToUpdateParkingSlotInResponseConverter;

    @PostMapping(value = "/parking-slots")
    public ResponseEntity<CreateParkingSlotInResponse> createParkingSlot (@RequestBody CreateParkingSlotInRequest request) {
        var parkingSlot = createParkingSlotInRequestToDomain.convert(request);
        var savedParkingLot = saveParkingSlotUseCase.saveParkingSlot(parkingSlot);

        var responseBody = parkingSlotToCreateParkingSlotInResponseConverter.convert(savedParkingLot);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(value = "/parking-slots/{id}")
    public GetParkingSlotInResponse findParkingSlotById(@PathVariable Integer id) {
        var parkingSlot = findParkingSlotUseCase.findParkingSlotById(id);
        return parkingSlotToGetParkingSlotInResponseConverter.convert(parkingSlot);
    }

    @DeleteMapping(value = "/parking-slots/{id}")
    public ResponseEntity<String> deleteParkingSlotById(@PathVariable Integer id) {
        deleteParkingSlotUseCase.deleteParkingSlotById(id);
        return new ResponseEntity<>("Deleted id: " + id, HttpStatus.OK);
    }

    @PutMapping(value = "/parking-slots/{id}")
    public ResponseEntity<UpdateParkingSlotInResponse> updateParkingSlot (@PathVariable Integer id,
                                                                        @RequestBody UpdateParkingSlotInRequest request) {

        var parkingSlotForUpdate = updateParkingSlotInRequestToDomain.convert(request);
        var updatedParkingSlot = updateParkingSlotUseCase.updateParkingSlot(id, parkingSlotForUpdate);
        var responseBody = parkingSlotToUpdateParkingSlotInResponseConverter.convert(updatedParkingSlot);

        return ResponseEntity.ok(responseBody);
    }
}
