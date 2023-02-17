package com.meawallet.parkingapp.ui;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;
@AllArgsConstructor
public class UserMenu {
    UserInput userInput;
    List<MenuAction> menuActionList;

    public void startMenu() {
        System.out.println("PARKING APP:");
        while (true) {
            try {
                printMenu();
                Integer optionNr = userInput.requestMenuNumber();
                startAction(optionNr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    private void startAction(Integer optionNr) {
        menuActionList.get(optionNr).execute();
    }

    private void printMenu() {
        for (int i = 0; i < menuActionList.size(); i++) {
            System.out.println(i + ". " + menuActionList.get(i).getName());
        }
    }
}
