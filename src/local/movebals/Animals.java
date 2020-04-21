package local.movebals;

public class Animals implements Movable {

    private String name;
    private int legs;
    private boolean rideable;
    private boolean afraid;

    public Animals(String name, int legs, boolean rideable) {
        this.name = name;
        this.legs = legs;
        this.rideable = rideable;
        afraid = false;
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

}
