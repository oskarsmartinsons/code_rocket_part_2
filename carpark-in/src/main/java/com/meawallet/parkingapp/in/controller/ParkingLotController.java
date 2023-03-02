package com.meawallet.parkingapp.in.controller;

import com.meawallet.parkingapp.core.port.in.DeleteParkingLotUseCase;
import com.meawallet.parkingapp.core.port.in.FindParkingLotUseCase;
import com.meawallet.parkingapp.core.port.in.SaveParkingLotUseCase;
import com.meawallet.parkingapp.core.port.in.UpdateParkingLotUseCase;
import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.in.converter.CreateParkingLotInRequestToDomain;
import com.meawallet.parkingapp.in.converter.ParkingLotToCreateParkingLotInResponseConverter;
import com.meawallet.parkingapp.in.converter.ParkingLotToGetParkingLotInResponseConverter;
import com.meawallet.parkingapp.in.converter.UpdateParkingLotInRequestToDomain;
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

    @PostMapping(value = "/parking")
    public ResponseEntity<CreateParkingLotInResponse> createParkingLot (@RequestBody CreateParkingLotInRequest request) {
        var parkingLot = createParkingLotInRequestToDomain.convert(request);
        var savedParkingLot = saveParkingLotUseCase.saveParkingLot(parkingLot);
        var responseBody = parkingLotToCreateParkingLotInResponseConverter.convert(savedParkingLot);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseBody.id())
                .toUri();

        return ResponseEntity.created(location)
                .body(responseBody);
    }

    @GetMapping(value = "/parking/{id}")
    public GetParkingLotInResponse findParkingLotById(@PathVariable Integer id) {
        var parkingLot = findParkingLotUseCase.findParkingLotById(id);
        return parkingLotToGetParkingLotInResponseConverter.convert(parkingLot);
    }

    @DeleteMapping(value = "/parking/{id}")
    public ResponseEntity<Integer> deleteParkingLotById(@PathVariable Integer id) {
        deleteParkingLotUseCase.deleteParkingLotById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/parking/{id}")
    public ResponseEntity<Integer>  updateParkingLot(@PathVariable Integer id, @RequestBody ParkingLot parkingLot) {
      //  var parkingLotForUpdate = updateParkingLotInRequestToDomain.convert(request);
        updateParkingLotUseCase.updateParkingLot(id, parkingLot);

     //   return new ResponseEntity<>();
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


    @GetMapping(value = "/test")
    public String findUserById() {
        return "Test";
    }
}
