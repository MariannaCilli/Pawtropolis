package model;

import model.Bag;
import model.Direction;
import model.Item;

import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);


        List<Item> items = new ArrayList<>();
        Item pino = new Item("pinolo", "nanan", 2);
        Item pina = new Item("pinola", "nananaaa", 2);

        //se si aggiunge uno slot used >> di SPACE_BAG non verrà aggiunto alla lista
        Bag prova = new Bag(items, 0);

        prova.addItems(pino);
        prova.addItems(pina);

        System.out.println("OGGETTO AGGIUNTO" + prova );

        prova.dropItems(pino);
        prova.dropItems(pina);
        System.out.println("OGGETTO LEVATO" + prova );

    }
}
