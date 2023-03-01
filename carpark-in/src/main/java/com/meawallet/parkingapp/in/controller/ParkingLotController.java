package com.meawallet.parkingapp.in.controller;

import com.meawallet.parkingapp.core.port.in.FindParkingLotUseCase;
import com.meawallet.parkingapp.core.port.in.SaveParkingLotUseCase;
import com.meawallet.parkingapp.in.converter.CreateParkingLotRequestToDomain;
import com.meawallet.parkingapp.in.converter.ParkingLotToCreateUserInResponseConverter;
import com.meawallet.parkingapp.in.converter.ParkingLotToGetParkingLotInResponseConverter;
import com.meawallet.parkingapp.in.dto.CreateParkingLotInRequest;
import com.meawallet.parkingapp.in.dto.CreateParkingLotInResponse;
import com.meawallet.parkingapp.in.dto.GetParkingLotInResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@AllArgsConstructor
public class ParkingLotController {
    private final SaveParkingLotUseCase saveParkingLotUseCase;
    private final FindParkingLotUseCase findParkingLotUseCase;
    private final CreateParkingLotRequestToDomain createParkingLotRequestToDomain;
    private final ParkingLotToGetParkingLotInResponseConverter parkingLotToGetParkingLotInResponseConverter;
    private final ParkingLotToCreateUserInResponseConverter parkingLotToCreateUserInResponseConverter;


    @PostMapping(value = "/parking")
    public ResponseEntity<CreateParkingLotInResponse> create (@RequestBody CreateParkingLotInRequest request) {
        var parkingLot = createParkingLotRequestToDomain.convert(request);
        var savedParkingLot = saveParkingLotUseCase.saveParkingLot(parkingLot);
        var responseBody = parkingLotToCreateUserInResponseConverter.convert(savedParkingLot);

        var location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(responseBody.id())
                .toUri();

        return ResponseEntity.created(location)
                .body(responseBody);
    }
    @GetMapping(value = "/parking/{id}")
    public GetParkingLotInResponse findUserById(@PathVariable Integer id) {
        var parkingLot = findParkingLotUseCase.findParkingLot(id);
        return parkingLotToGetParkingLotInResponseConverter.convert(parkingLot);
    }

    @GetMapping(value = "/test")
    public String findUserById() {
        return "Test";
    }

}
