package com.meawallet.parkingapp.in.controller;

import com.meawallet.parkingapp.exception.EntityNotFoundException;
import com.meawallet.parkingapp.core.port.in.parkingSlotUseCases.*;
import com.meawallet.parkingapp.in.converter.parkingSlot.CreateParkingSlotInRequestToDomainConverter;
import com.meawallet.parkingapp.in.converter.parkingSlot.ParkingSlotToCreateParkingSlotInResponseConverter;
import com.meawallet.parkingapp.in.converter.parkingSlot.ParkingSlotToGetParkingSlotInResponseConverter;
import com.meawallet.parkingapp.in.converter.parkingSlot.UpdateParkingSlotInRequestToDomainConverter;
import com.meawallet.parkingapp.in.dto.parkingSlot.CreateParkingSlotInRequest;
import com.meawallet.parkingapp.in.dto.parkingSlot.CreateParkingSlotInResponse;
import com.meawallet.parkingapp.in.dto.parkingSlot.GetParkingSlotInResponse;
import com.meawallet.parkingapp.in.dto.parkingSlot.UpdateParkingSlotInRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
public class ParkingSlotController {
    private final SaveParkingSlotUseCase saveParkingSlotUseCase;
    private final FindParkingSlotUseCase findParkingSlotUseCase;
    private final DeleteParkingSlotUseCase deleteParkingSlotUseCase;
    private final UpdateParkingSlotUseCase updateParkingSlotUseCase;
    private final FindAllParkingSlotsUseCase findAllParkingSlotsUseCase;
    private final CreateParkingSlotInRequestToDomainConverter createParkingSlotInRequestToDomainConverter;
    private final ParkingSlotToCreateParkingSlotInResponseConverter parkingSlotToCreateParkingSlotInResponseConverter;
    private final ParkingSlotToGetParkingSlotInResponseConverter parkingSlotToGetParkingSlotInResponseConverter;
    private final UpdateParkingSlotInRequestToDomainConverter updateParkingSlotInRequestToDomainConverter;

    @PostMapping(value = "/parking-slots")
    public ResponseEntity<CreateParkingSlotInResponse> createParkingSlot (@Valid @RequestBody CreateParkingSlotInRequest request) {
        log.debug("Received create PARKING SLOT request: {}", request);
        var parkingSlot = createParkingSlotInRequestToDomainConverter.convert(request);
        var savedParkingLot = saveParkingSlotUseCase.saveParkingSlot(parkingSlot);

        var responseBody = parkingSlotToCreateParkingSlotInResponseConverter.convert(savedParkingLot);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseBody.id())
                .toUri();

        return ResponseEntity.created(location)
                .body(responseBody);
    }

    @GetMapping(value = "/parking-slots/{id}")
    public GetParkingSlotInResponse findParkingSlotById(@PathVariable Integer id) throws EntityNotFoundException {
        log.debug("Received find PARKING SLOT by id request: {}", id);
        var parkingSlot = findParkingSlotUseCase.findParkingSlotById(id);
        return parkingSlotToGetParkingSlotInResponseConverter.convert(parkingSlot);
    }

    @DeleteMapping(value = "/parking-slots/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParkingSlotById(@PathVariable Integer id) {
        log.debug("Received delete PARKING SLOT by id request: {}", id);
        deleteParkingSlotUseCase.deleteParkingSlotById(id);
    }

    @PutMapping(value = "/parking-slots/{id}")
    public void updateParkingSlot (@Valid @RequestBody UpdateParkingSlotInRequest request, @PathVariable Integer id) {
        log.debug("Received update PARKING SLOT request: {}, id: {}", request, id);
        var parkingSlotForUpdate = updateParkingSlotInRequestToDomainConverter.convert(request, id);
        updateParkingSlotUseCase.updateParkingSlot(parkingSlotForUpdate);
    }

    @GetMapping(value = "/parking-slots")
    public List<GetParkingSlotInResponse> findAllParkingSlots() {
        log.debug("Received find all PARKING SLOTS request");
        return findAllParkingSlotsUseCase.findAllParkingSlots().stream()
                .map(parkingSlotToGetParkingSlotInResponseConverter::convert)
                .collect(Collectors.toList());
    }
}
