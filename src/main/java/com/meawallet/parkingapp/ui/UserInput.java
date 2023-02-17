package com.meawallet.parkingapp.ui;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.dto.CreateParkingLotRequest;

import java.util.Scanner;

public class UserInput {
    public Integer requestMenuNumber(){
        System.out.println("Input menu number: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public CreateParkingLotRequest getCreateParkingLotRequest() {
        System.out.println("Specify Lot Name: ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Specify Slot Count in Lot: ");
        Integer count = Integer.valueOf(input.nextLine());
        return new CreateParkingLotRequest(name,count,count);
    }
}
