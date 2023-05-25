package model;

public class Player {

    private String name;

    private int lifePoints;  //fare get e setter

    //private Bag bag;              inserire il metodo go

    public Player ( String name, int lifePoints) {
        this.name= name;
        this.lifePoints = lifePoints;
    }
    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }


    public int getLifePoints () {
        return lifePoints;
    }

    public void setLifePoints (int lifePoints) {
        this.lifePoints = lifePoints;
    }

    @Override
    public String toString () {
        return "Player{"+
                "name='"+name+'\''+
                ", lifePoint="+lifePoints+
                '}';
    }
}