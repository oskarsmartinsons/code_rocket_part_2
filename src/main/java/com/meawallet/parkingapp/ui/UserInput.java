package com.meawallet.parkingapp.ui;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.dto.CreateParkingLotRequest;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class UserInput {
    public Integer requestMenuNumber() {
        System.out.println("Input menu number: ");
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Please enter correct menu number");
        }
    }

    public CreateParkingLotRequest getCreateParkingLotRequest() {
        try {
            System.out.println("Specify Lot Name: ");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            System.out.println("Specify Slot Count in Lot: ");
            Integer count = Integer.valueOf(input.nextLine());
            return new CreateParkingLotRequest(name, count, count);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Please enter integer number for Slot Count, not");
        }
    }

    public Integer requestIdNumber() {
        System.out.println("Enter Parking lot Id number: ");
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Incorrect id - it can contain only numbers");
        }
    }
}
