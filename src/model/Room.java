package model;

import zoo.Animal;

import java.util.*;

public class Room {

    private final String name;
    private final List <Item> items;
    private final List<Animal> animals;
    private final  Map <Direction, Room> adjoiningRooms;



    public String getName () {
        return name;
    }

    public Room(String nameRoom)  {
        this.name = nameRoom;
        this.items = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.adjoiningRooms = new EnumMap <>(Direction.class);

    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" +name+ '\'' +
                ", adjoiningRooms=" + adjoiningRooms +
                '}';
    }

    public void addAdjoiningRoom( Direction direction, Room room) {  //aggiunge la stanza alla lista
        adjoiningRooms.put(direction, room);
    }

    public Room getAdjoiningDirectionRoom (Direction direction) {
        return adjoiningRooms.get(direction);
    }



    public void addItem (Item item){
        items.add(item);
    }

    public void addAnimal (Animal animal){
        animals.add(animal);
    }

    public void removeAnimal (Animal animal) {
        animals.remove(animal);
    }


    public void removeItem (Item item) {
        items.remove(item);
    }

    public List<Item> getItemsInRoom() {
        return new ArrayList<>(items);
    }

    public List<Animal> getAnimalsInRoom() {
        return new ArrayList<>(animals);
    }


}
