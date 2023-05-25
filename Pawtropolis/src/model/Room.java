package model;


import zoo.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;  //mappare e metterci dentro le cose e poi se è randomizzarla
import java.util.Map;


public class Room {

    private String nameRoom;
    private List <Item> itemsInRoom;
    private List<Animal> animalsInRoom;
    private Map <Direction, Room> adjoiningRooms;

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public List<Item> getItemsInRoom() {
        return itemsInRoom;
    }

    public void setItemsInRoom(List<Item> itemsInRoom) {
        this.itemsInRoom = itemsInRoom;
    }


    public Map<Direction, Room> getAdjoiningRooms() {
        return adjoiningRooms;
    }

    public void setAdjoiningRooms (Map <Direction, Room> adjoiningRooms) {
        this.adjoiningRooms = adjoiningRooms;
    }

    public Room(String nameRoom /*, List<Item> itemsInRoom, List<Animal> animalsInRoom, List<Room> adjoiningRooms*/)  {
        this.nameRoom = nameRoom;
        this.itemsInRoom = new ArrayList<>();
        this.animalsInRoom = new ArrayList<>();
        this.adjoiningRooms = new HashMap <>();
    }

    public void addAdjoiningRoom( Direction direction, Room room) {  //aggiunge la stanza alla lista
        adjoiningRooms.put(direction, room);
    }

    public Room getAdjoiningRoom (Direction direction) {
        return adjoiningRooms.get(direction);
    }

    //modificare metodi usando classe stream enum
}
