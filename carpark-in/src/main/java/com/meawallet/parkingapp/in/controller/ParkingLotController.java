package com.meawallet.parkingapp.in.controller;

import com.meawallet.parkingapp.core.port.in.DeleteParkingLotUseCase;
import com.meawallet.parkingapp.core.port.in.FindParkingLotUseCase;
import com.meawallet.parkingapp.core.port.in.SaveParkingLotUseCase;
import com.meawallet.parkingapp.core.port.in.UpdateParkingLotUseCase;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.converter.*;
import com.meawallet.parkingapp.in.dto.*;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@AllArgsConstructor
public class ParkingLotController {
    private final SaveParkingLotUseCase saveParkingLotUseCase;
    private final FindParkingLotUseCase findParkingLotUseCase;
    private final DeleteParkingLotUseCase deleteParkingLotUseCase;
    private final UpdateParkingLotUseCase updateParkingLotUseCase;
    private final CreateParkingLotInRequestToDomain createParkingLotInRequestToDomain;
    private final UpdateParkingLotInRequestToDomain updateParkingLotInRequestToDomain;
    private final ParkingLotToGetParkingLotInResponseConverter parkingLotToGetParkingLotInResponseConverter;
    private final ParkingLotToCreateParkingLotInResponseConverter parkingLotToCreateParkingLotInResponseConverter;
    private final ParkingLotToUpdateParkingLotInResponseConverter parkingLotToUpdateParkingLotInResponseConverter;

    @PostMapping(value = "/parking-lots")
    public ResponseEntity<CreateParkingLotInResponse> createParkingLot (@RequestBody CreateParkingLotInRequest request) {
        var parkingLot = createParkingLotInRequestToDomain.convert(request);
        var savedParkingLot = saveParkingLotUseCase.saveParkingLot(parkingLot);

        var responseBody = parkingLotToCreateParkingLotInResponseConverter.convert(savedParkingLot);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(value = "/parking-lots/{id}")
    public GetParkingLotInResponse findParkingLotById(@PathVariable Integer id) {
        var parkingLot = findParkingLotUseCase.findParkingLotById(id);
        return parkingLotToGetParkingLotInResponseConverter.convert(parkingLot);
    }

    @DeleteMapping(value = "/parking-lots/{id}")
    public ResponseEntity<String> deleteParkingLotById(@PathVariable Integer id) {
        deleteParkingLotUseCase.deleteParkingLotById(id);
        return new ResponseEntity<>("Deleted id: " + id, HttpStatus.OK);
    }

    @PutMapping(value = "/parking-lots/{id}")
    public ResponseEntity<UpdateParkingLotInResponse> updateParkingLot (@PathVariable Integer id,
                                                                        @RequestBody UpdateParkingLotInRequest request) {

        var parkingLotForUpdate = updateParkingLotInRequestToDomain.convert(request);
        var updatedParkingLot = updateParkingLotUseCase.updateParkingLot(id, parkingLotForUpdate);
        var responseBody = parkingLotToUpdateParkingLotInResponseConverter.convert(updatedParkingLot);

        return ResponseEntity.ok(responseBody);
    }


    @GetMapping(value = "/test")
    public String test() {
        return "Test";
    }
}
