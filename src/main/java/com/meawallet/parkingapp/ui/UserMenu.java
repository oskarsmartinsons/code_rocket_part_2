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
                printMenuActions(MenuName.MAIN);
                var mainActionNr = requestMenuActionNumber();

                if(doesMainActionHasSubMenu(mainActionNr)) {
                    var subMenuName = getSubMenuNameFromMainAction(mainActionNr);
                    printMenuActions(subMenuName);
                    var subActionNr = requestMenuActionNumber();
                    startSubMenuAction(subActionNr);

                } else {
                    startMainMenuAction(mainActionNr);
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

    private void printMenuActions(MenuName menuName) {
        var menuActions = getMenuActionsByMenuName(menuName);
        for (int i = 0; i < menuActions.size(); i++) {
            System.out.println(i + ". " + menuActions.get(i).getActionName());
        }
    }

    private List<MenuActions> getMenuActionsByMenuName(MenuName menuName) {
        return menuActionsList.stream().filter(m->m.getMenuAppearanceName().equals(menuName)).toList();
    }

    private Integer requestMenuActionNumber() {
        return userInput.requestMenuNumber();
    }
    private boolean doesMainActionHasSubMenu(Integer actionNumber){
        var mainMenuActions = getMenuActionsByMenuName(MenuName.MAIN);
        return mainMenuActions.get(actionNumber).hasSubMenu();
    }
    private MenuName getSubMenuNameFromMainAction(Integer actionNr) {
        return getMenuActionsByMenuName(MenuName.MAIN).get(actionNr).getSubMenuName();
    }

    private void startMainMenuAction (Integer actionNumber) {
        var actionList = getMenuActionsByMenuName(MenuName.MAIN);
        actionList.get(actionNumber).execute();
    }
    private void startSubMenuAction (Integer actionNumber) {
        var actionList = getMenuActionsByMenuName(MenuName.SUB);
        actionList.get(actionNumber).execute();
    }

}
