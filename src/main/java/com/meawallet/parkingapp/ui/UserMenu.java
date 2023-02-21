package com.meawallet.parkingapp.ui;

import com.meawallet.parkingapp.ui.exceptions.CreateParkingLotRequestException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserMenu {
    UserInput userInput;
    List<MenuActions> menuActionsList;
    List<SubMenuActions> subMenuActionsList;

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

                    System.out.println(mainMenuList.get(optionNr).getName());
                    print(subMenuList);
                    optionNr = userInput.requestMenuNumber();
                    start(subMenuList,optionNr);

                } else {
                    start(mainMenuList, optionNr);
                }

       /*         System.out.println("\nPARKING APP menu:");
                printMenu(MenuType.MAIN);
                Integer optionNr = userInput.requestMenuNumber();

                if (menuActionsList.get(optionNr).getMenuType().equals(MenuType.SUB)) {
                    System.out.println("\nSET UP my Parking Lot menu:");
                    printMenu(MenuType.SUB);
                    optionNr = userInput.requestMenuNumber();
                    startAction(optionNr,MenuType.SUB);
                } else {
                    startAction(optionNr, MenuType.MAIN);
                }*/

            } catch (IndexOutOfBoundsException iob) {
                System.out.println("Please enter correct menu number: " + iob.getMessage() +"\n");
            } catch (CreateParkingLotRequestException createEx) {
                System.out.println(createEx.getMessage());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private List<MenuActions> getMenuByName(MenuName menuName) {
        return menuActionsList.stream().filter(m->m.getMenuAppearanceName().equals(menuName)).toList();
    }
    private void print(List<MenuActions> menuActionList) {
        for (int i = 0; i < menuActionList.size(); i++) {
            System.out.println(i + ". " + menuActionList.get(i).getName());
        }
    }

    private void start(List<MenuActions> actionsList, Integer optionNr) {
        actionsList.get(optionNr).execute();
    }

 /*   private void startAction(Integer optionNr, MenuType type) {
        if (type.equals(MenuType.MAIN)) {
            menuActionsList.get(optionNr).execute();
        } else {
            subMenuActionsList.get(optionNr).execute();
        }
    }*/

/*    private void printMenu(MenuType type) {
        if (type.equals(MenuType.MAIN)) {
            for (int i = 0; i < menuActionsList.size(); i++) {
                System.out.println(i + ". " + menuActionsList.get(i).getName());
            }
        } else {
            for (int i = 0; i < subMenuActionsList.size(); i++) {
                System.out.println(i + ". " + subMenuActionsList.get(i).getName());
            }
        }
    }*/
}
