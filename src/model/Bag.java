package model;

import java.util.*;

public class Bag {


    public static final int BAG_SPACE = 4;
    private final List <Item> items;
    private int availableSpace;


    public Bag () {
        this.items = new ArrayList <>(BAG_SPACE);
        this.availableSpace = BAG_SPACE;
    }

    public List <Item> getItems () {
        return items;
    }

    public int getAvailableSpace () {
        return availableSpace;
    }

    public void setAvailableSpace (int availableSpace) {
        this.availableSpace = availableSpace;
    }


    @Override
    public String toString () {
        return "Bag{"+
                "listItem="+items+
                ",availableSpace="+availableSpace+
                '}';
    }


    public Item addItem (Item item) {

        if (item != null && availableSpace-item.getRequiredSpace() >= 0) {
            items.add(item);
            availableSpace -= item.getRequiredSpace();
        }
        return null;
    }

    public Item removeItem (Item item) {
        items.remove(item);
        availableSpace += item.getRequiredSpace();
        return null;

    }

       public String showBag() {//costruisce la stringa con la conoscenza dei propri item, la darà poi al player
           StringBuilder sb = new StringBuilder();
           for (int i = 0; i < items.size(); i++) {
               sb.append(items.get(i).getName());
               if (i < items.size() - 1) {
                   sb.append(", ");
               }
           }
           return sb.toString();
       }

}