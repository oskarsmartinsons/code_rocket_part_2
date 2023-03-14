package com.meawallet.parkingapp.in.controller;

import com.meawallet.parkingapp.core.port.in.carUseCases.*;
import com.meawallet.parkingapp.in.converter.car.CarToCreateCarInResponseConverter;
import com.meawallet.parkingapp.in.converter.car.CarToGetCarInResponseConverterConverter;
import com.meawallet.parkingapp.in.converter.car.CreateCarInRequestToDomainConverter;
import com.meawallet.parkingapp.in.converter.car.UpdateCarInRequestToDomainConverter;
import com.meawallet.parkingapp.in.dto.car.CreateCarInRequest;
import com.meawallet.parkingapp.in.dto.car.CreateCarInResponse;
import com.meawallet.parkingapp.in.dto.car.GetCarInResponse;
import com.meawallet.parkingapp.in.dto.car.UpdateCarInRequest;
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
public class CarController {
    private final SaveCarUseCase saveCarUseCase;
    private final FindCarUseCase findCarUseCase;
    private final DeleteCarUseCase deleteCarUseCase;
    private final UpdateCarUseCase updateCarUseCase;
    private final FindAllCarsUseCase findAllCarsUseCase;
    private final AddCarToParkingSlotUseCase addCarToParkingSlotUseCase;
    private final RemoveCarFromParkingSlotUseCase removeCarFromParkingSlotUseCase;
    private final CreateCarInRequestToDomainConverter createCarInRequestToDomainConverter;
    private final CarToCreateCarInResponseConverter carToCreateCarInResponseConverter;
    private final CarToGetCarInResponseConverterConverter carToGetCarInResponseConverterConverter;
    private final UpdateCarInRequestToDomainConverter updateCarInRequestToDomainConverter;

    @PostMapping(value = "/cars")
    public ResponseEntity<CreateCarInResponse> createCar(@Valid @RequestBody CreateCarInRequest request) {
        log.debug("Received create CAR request: {}", request);
        var car = createCarInRequestToDomainConverter.convert(request);
        var savedCar = saveCarUseCase.save(car);

        var responseBody = carToCreateCarInResponseConverter.convert(savedCar);

        return ResponseEntity.ok(responseBody);
    }

    @GetMapping(value = "cars/{id}")
    public GetCarInResponse findCarById(@PathVariable Integer id) {
        log.debug("Received find CAR by id request: {}", id);
        var car = findCarUseCase.findCarById(id);
        return carToGetCarInResponseConverterConverter.convert(car);
    }

    @DeleteMapping(value = "cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCarById(@PathVariable Integer id) {
        log.debug("Received delete CAR by id request: {}", id);
        deleteCarUseCase.deleteCarById(id);
    }

    @PutMapping(value = "cars/{id}")
    public void updateCar(@Valid @RequestBody UpdateCarInRequest request,@PathVariable Integer id) {
        log.debug("Received update CAR request: {}, id: {}", request, id);
        var carForUpdate = updateCarInRequestToDomainConverter.convert(request, id);

        updateCarUseCase.updateCar(carForUpdate);
    }

    @GetMapping(value = "/cars")
    public List<GetCarInResponse> findAllCars() {
        log.debug("Received find all CARS request");
        return findAllCarsUseCase.findAllCars().stream()
                .map(carToGetCarInResponseConverterConverter::convert)
                .collect(Collectors.toList());
    }

    @PutMapping (value = "/parking-slot/{slotId}/add-car")
    public void addCarToParkingSlot(@RequestBody CreateCarInRequest request, @PathVariable ("slotId") Integer slotId) {
        log.debug("Received add CAR request");
        var car = createCarInRequestToDomainConverter.convert(request);
        addCarToParkingSlotUseCase.addCarInParkingSlot(car,slotId);
    }

    @PutMapping (value = "/parking-slot/{slotId}/remove-car")
    public void removeCarFromParkingSlot(@PathVariable ("slotId") Integer slotId) {
        log.debug("Received remove CAR request");
        removeCarFromParkingSlotUseCase.removeCarFromParkingSlot(slotId);
    }
}
