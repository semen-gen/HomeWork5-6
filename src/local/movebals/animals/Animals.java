package local.movebals.animals;

import local.movebals.Movable;

public class Animals implements Movable {

    private String name;
    private int legs;
    private boolean rideable;
    private boolean afraid;
    private final int price;

    public Animals(String name, int legs, boolean rideable, int price) {
        this.name = name;
        this.legs = legs;
        this.rideable = rideable;
        afraid = false;
        this.price = price;
    }

    public void toScare() {
        afraid = true;
    }

    public void toReassure() {
        afraid = false;
    }

    @Override
    public boolean move() {
        if (afraid && !rideable) {
            return true;
        }
        else if (!afraid && rideable) {
            return true;
        }
        else {
            return false;
        }
    }

    public int getLegs() {
        return legs;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    public boolean isRideable() {
        return rideable;
    }

    public void setRideable(boolean rideable) {
        this.rideable = rideable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

}
