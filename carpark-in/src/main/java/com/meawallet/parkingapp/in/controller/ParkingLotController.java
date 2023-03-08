package com.meawallet.parkingapp.in.controller;

import com.meawallet.parkingapp.core.port.in.parkingLotUseCases.*;

import com.meawallet.parkingapp.domain.ParkingSlot;
import com.meawallet.parkingapp.in.converter.parkingLot.CreateParkingLotInRequestToDomainConverter;
import com.meawallet.parkingapp.in.converter.parkingLot.ParkingLotToCreateParkingLotInResponseConverter;
import com.meawallet.parkingapp.in.converter.parkingLot.ParkingLotToGetParkingLotInResponseConverter;
import com.meawallet.parkingapp.in.converter.parkingLot.UpdateParkingLotInRequestToDomainConverter;
import com.meawallet.parkingapp.in.dto.parkingLot.CreateParkingLotInRequest;
import com.meawallet.parkingapp.in.dto.parkingLot.CreateParkingLotInResponse;
import com.meawallet.parkingapp.in.dto.parkingLot.GetParkingLotInResponse;
import com.meawallet.parkingapp.in.dto.parkingLot.UpdateParkingLotInRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@AllArgsConstructor
public class ParkingLotController {
    private final SaveParkingLotUseCase saveParkingLotUseCase;
    private final FindParkingLotUseCase findParkingLotUseCase;
    private final DeleteParkingLotUseCase deleteParkingLotUseCase;
    private final UpdateParkingLotUseCase updateParkingLotUseCase;
    private final FindAllParkingLotsUseCase findAllParkingLotsUseCase;
    private final GetParkingSlotsForParkingLotUseCase getParkingSlotsForParkingLotUseCase;
    private final CreateParkingLotInRequestToDomainConverter createParkingLotInRequestToDomainConverter;
    private final UpdateParkingLotInRequestToDomainConverter updateParkingLotInRequestToDomainConverter;
    private final ParkingLotToGetParkingLotInResponseConverter parkingLotToGetParkingLotInResponseConverter;
    private final ParkingLotToCreateParkingLotInResponseConverter parkingLotToCreateParkingLotInResponseConverter;

    @PostMapping(value = "/parking-lots")
    public ResponseEntity<CreateParkingLotInResponse> createParkingLot (@RequestBody CreateParkingLotInRequest request) {
        var parkingLot = createParkingLotInRequestToDomainConverter.convert(request);
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteParkingLotById(@PathVariable Integer id) {
        deleteParkingLotUseCase.deleteParkingLotById(id);
    }

    @PutMapping(value = "/parking-lots/{id}")
        public void updateParkingLot (@RequestBody UpdateParkingLotInRequest request, @PathVariable Integer id) {

            var parkingLotForUpdate = updateParkingLotInRequestToDomainConverter.convert(request, id);
            updateParkingLotUseCase.updateParkingLot(parkingLotForUpdate);
    }

    @GetMapping(value = "/parking-lots")
    public List<GetParkingLotInResponse> findAllParkingLots() {
        return findAllParkingLotsUseCase.findAllParkingLots().stream()
                .map(parkingLotToGetParkingLotInResponseConverter::convert)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/parking-lots/{parkingLotId}/parking-slots")
    public List<ParkingSlot> getParkingSlotsForParkingLot(@PathVariable Integer parkingLotId) {
        return getParkingSlotsForParkingLotUseCase.findParkingSlotsByParkingLotId(parkingLotId);
    }

    @GetMapping(value = "/test")
    public String test() {
        return "Test";
    }
}
