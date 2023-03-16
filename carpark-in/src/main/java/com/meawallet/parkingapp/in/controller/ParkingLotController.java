package com.meawallet.parkingapp.in.controller;

import com.meawallet.parkingapp.core.exception.EntityNotFoundException;
import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.*;
import com.meawallet.parkingapp.in.converter.parkingLot.*;
import com.meawallet.parkingapp.in.dto.parkingLot.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@AllArgsConstructor
public class ParkingLotController {
    private final SaveParkingLotUseCase saveParkingLotUseCase;
    private final FindParkingLotUseCase findParkingLotUseCase;
    private final DeleteParkingLotUseCase deleteParkingLotUseCase;
    private final UpdateParkingLotUseCase updateParkingLotUseCase;
    private final FindAllParkingLotsUseCase findAllParkingLotsUseCase;
    private final CreateParkingLotInRequestToDomainConverter createParkingLotInRequestToDomainConverter;
    private final UpdateParkingLotInRequestToDomainConverter updateParkingLotInRequestToDomainConverter;
    private final ParkingLotToGetParkingLotInResponseConverter parkingLotToGetParkingLotInResponseConverter;
    private final ParkingLotToCreateParkingLotInResponseConverter parkingLotToCreateParkingLotInResponseConverter;
    private final ParkingLotToUpdateParkingLotInResponseConverter parkingLotToUpdateParkingLotInResponseConverter;

    @PostMapping(value = "/parking-lots")
    public ResponseEntity<CreateParkingLotInResponse> createParkingLot (@Valid @RequestBody CreateParkingLotInRequest request){
        log.debug("Received create PARKING LOT WITH SLOTS request: {}", request);
        var parkingLot = createParkingLotInRequestToDomainConverter.convert(request);
        var savedParkingLot = saveParkingLotUseCase.saveParkingLot(parkingLot);

        var responseBody = parkingLotToCreateParkingLotInResponseConverter.convert(savedParkingLot);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(value = "/parking-lots/{id}")
    public GetParkingLotInResponse findParkingLotById(@PathVariable Integer id) throws EntityNotFoundException {
        log.debug("Received find PARKING LOT by id request: {}", id);
        var parkingLot = findParkingLotUseCase.findParkingLotById(id);

        return parkingLotToGetParkingLotInResponseConverter.convert(parkingLot);
    }

    @DeleteMapping(value = "/parking-lots/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParkingLotById(@PathVariable Integer id) {
        log.debug("Received delete PARKING LOT by id request: {}", id);
        deleteParkingLotUseCase.deleteParkingLotById(id);
    }

    @PutMapping(value = "/parking-lots/{id}")
    public ResponseEntity<UpdateParkingLotInResponse> updateParkingLot (@Valid @RequestBody UpdateParkingLotInRequest request, @PathVariable Integer id) {
        log.debug("Received update PARKING LOT request: {}, id: {}", request, id);
        var parkingLotForUpdate = updateParkingLotInRequestToDomainConverter.convert(request, id);
        var updatedParkingLot = updateParkingLotUseCase.updateParkingLot(parkingLotForUpdate);

        var responseBody = parkingLotToUpdateParkingLotInResponseConverter.convert(updatedParkingLot);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(value = "/parking-lots")
    public List<GetParkingLotInResponse> findAllParkingLots() {
        log.debug("Received find all PARKING LOTS request");
        return findAllParkingLotsUseCase.findAllParkingLots().stream()
                .map(parkingLotToGetParkingLotInResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Test";
    }


/*    @PutMapping(value = "/parking-lots/{lotId}/parking-slots/{slotId}")
    public void updateParkingSlotInParkingLot(
            @Valid @RequestBody UpdateParkingSlotInRequest request,
            @PathVariable Integer lotId,
            @PathVariable Integer slotId) {
        log.debug("Received update PARKING SLOT request: {}, lotId: {}, slotId: {}", request, lotId, slotId);
        var parkingSlotForUpdate = updateParkingSlotInRequestToDomainConverter.convert(request, slotId);
        updateParkingSlotInParkingLotUseCase.updateParkingSlotInParkingLot(lotId, parkingSlotForUpdate);
    }*/
}
