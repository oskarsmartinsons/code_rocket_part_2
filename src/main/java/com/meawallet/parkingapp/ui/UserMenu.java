package com.meawallet.parkingapp.ui;

import com.meawallet.parkingapp.ui.exceptions.EntityNotFoundException;
import com.meawallet.parkingapp.ui.exceptions.ParkingLotRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserMenu {
    UserInput userInput;
    List<MenuActions> menuActionsList;

    public void startMenu() {
        while (true) {
            try {
                System.out.println("\nPARKING APP menu:");
                var mainMenuList = getMenuByName(MenuName.MAIN);
                print(mainMenuList);
                Integer optionNr = userInput.requestMenuNumber();

                if(mainMenuList.get(optionNr).hasSubMenu()) {
                    var subMenuName = mainMenuList.get(optionNr).getSubMenuName();
                    var subMenuList =  getMenuByName(subMenuName);

                    System.out.println(mainMenuList.get(optionNr).getActionName());
                    print(subMenuList);
                    optionNr = userInput.requestMenuNumber();
                    start(subMenuList,optionNr);

                } else {
                    start(mainMenuList, optionNr);
                }

            } catch (IndexOutOfBoundsException iob) {
                System.out.println("Please enter correct menu number: " + iob.getMessage() +"\n");
            } catch (ParkingLotRequestException | EntityNotFoundException requestException) {
                System.out.println(requestException.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private List<MenuActions> getMenuByName(MenuName menuName) {
        return menuActionsList.stream().filter(m->m.getMenuAppearanceName().equals(menuName)).toList();
    }

    private void print(List<MenuActions> menuActionList) {
        for (int i = 0; i < menuActionList.size(); i++) {
            System.out.println(i + ". " + menuActionList.get(i).getActionName());
        }
    }

    private void start(List<MenuActions> actionsList, Integer optionNr) {
        actionsList.get(optionNr).execute();
    }
}
