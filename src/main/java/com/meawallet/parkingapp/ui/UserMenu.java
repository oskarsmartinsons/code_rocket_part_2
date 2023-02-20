package com.meawallet.parkingapp.ui;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
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

                if (menuActionList.get(optionNr).getName().equals("Settings")) {
                    System.out.println("SubMenu");
                } else {
                    startAction(optionNr);
                }
            } catch (IndexOutOfBoundsException iob) {
                System.out.println("Please enter correct menu number: " + iob.getMessage() +"\n");
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
