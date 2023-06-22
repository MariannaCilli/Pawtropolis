package command;


import controller.GameController;
import model.Item;

import java.util.List;

public class ShowBagCommand implements GameCommand{

    private GameController gameController;;

    public ShowBagCommand (GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void execute () {

        List <Item> items = gameController.getPlayer().getItemsInBag();
        if (items.isEmpty()) {
            System.out.println("\nYour bag is empty");

        } else {
            System.out.print("\nIn bag: "+ gameController.getPlayer().showBag());
           // gameController.getPlayer().showBag();
           // for (int i = 0; i < items.size(); i++) {
           //    System.out.print(items.get(i).getName());
           //     if (i < items.size()-1) {
           //         System.out.print(", ");
           //     }

          //  }

            }


        System.out.println("\nRemaining space in bag: " + gameController.getPlayer().getAvailableSpaceInBag());
    }

   }

