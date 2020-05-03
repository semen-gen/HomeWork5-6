package local.movebals.animals;

import local.movebals.Movable;

public class Animals implements Movable {

    public Rideable rState;
    public Unrideable unRState;

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

        if (rideable) rState = new Rideable(false, false, 0);
        else unRState = new Unrideable(false, false, 0);

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
        return rideable ? price + rState.getPrice() : price + unRState.getPrice();
    }

    public void setState(boolean first, boolean second) {
        if (rideable) {
            rState.setHarness(first);
            rState.setHorseshoes(second);
        }
        else {
            unRState.setBowlForFeed(first);
            unRState.setCage(second);
        }
    }

    class Rideable {

        private boolean harness;
        private boolean horseshoes;
        private int price;

        Rideable(boolean harness, boolean horseshoes, int price) {
            this.harness = harness;
            this.horseshoes = horseshoes;
            this.price = price;
        }

        public boolean getHarness() {
            return harness;
        }

        public boolean getHorseshoes() {
            return horseshoes;
        }

        public int getPrice() {
            return price;
        }

        public void setHarness(boolean harness) {
            int price = 50;
            this.harness = harness;
            if (harness) this.price += price;
        }

        public void setHorseshoes(boolean horseshoes) {
            int price = 10;
            this.horseshoes = horseshoes;
            if (horseshoes) this.price += price;
        }

    }

    class Unrideable {

        private boolean bowlForFeed;
        private boolean cage;
        private int price;

        Unrideable(boolean bowlForFeed, boolean cage, int price) {
            this.bowlForFeed = bowlForFeed;
            this.cage = cage;
            this.price = price;
        }

        public boolean getBowlForFeed() {
            return bowlForFeed;
        }

        public boolean getCage() {
            return cage;
        }

        public int getPrice() {
            return price;
        }

        public void setBowlForFeed(boolean bowlForFeed) {
            int price = 3;
            this.bowlForFeed = bowlForFeed;
            this.price += price;
        }

        public void setCage(boolean cage) {
            int price = 25;
            this.cage = cage;
            this.price += price;
        }

    }

}
