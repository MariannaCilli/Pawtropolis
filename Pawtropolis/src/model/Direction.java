package model;

public enum Direction {

    North("north"),
    East("east"),
    South("south"),
    West("west");

    private String direction;


    Direction (String direction) {
        this.direction = direction;
    }

    public String getDirection () {
        return direction;
    }

    public void setDirection (String direction) {
        this.direction = direction;
    }

    @Override
    public String toString () {
        return "Direction{"+
                "direction='"+direction+'\''+
                '}';
    }


}