package com.meawallet.parkingapp.in.controller;

import com.meawallet.parkingapp.core.port.in.parkingSlotUseCases.*;
import com.meawallet.parkingapp.in.converter.*;
import com.meawallet.parkingapp.in.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class ParkingSlotController {
    private final SaveParkingSlotUseCase saveParkingSlotUseCase;
    private final FindParkingSlotUseCase findParkingSlotUseCase;
    private final DeleteParkingSlotUseCase deleteParkingSlotUseCase;
    private final UpdateParkingSlotUseCase updateParkingSlotUseCase;
    private final FindAllParkingSlotsUseCase findAllParkingSlotsUseCase;
    private final CreateParkingSlotInRequestToDomain createParkingSlotInRequestToDomain;
    private final ParkingSlotToCreateParkingSlotInResponseConverter parkingSlotToCreateParkingSlotInResponseConverter;
    private final ParkingSlotToGetParkingSlotInResponseConverter parkingSlotToGetParkingSlotInResponseConverter;
    private final UpdateParkingSlotInRequestToDomain updateParkingSlotInRequestToDomain;

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParkingSlotById(@PathVariable Integer id) {
        deleteParkingSlotUseCase.deleteParkingSlotById(id);
    }

    @PutMapping(value = "/parking-slots/{id}")
    public void updateParkingSlot (@RequestBody UpdateParkingSlotInRequest request, @PathVariable Integer id) {

        var parkingSlotForUpdate = updateParkingSlotInRequestToDomain.convert(request, id);
        updateParkingSlotUseCase.updateParkingSlot(parkingSlotForUpdate);
    }

    @GetMapping(value = "/parking-slots")
    public List<GetParkingSlotInResponse> findAllParkingSlots() {
        return findAllParkingSlotsUseCase.findAllParkingSlots().stream()
                .map(parkingSlotToGetParkingSlotInResponseConverter::convert)
                .collect(Collectors.toList());
    }
}
