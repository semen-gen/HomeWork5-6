package local.movebals.notalives;

import local.movebals.Movable;

import java.util.Objects;

public class NotAlive implements Movable {

    public int force;

    private String name;
    private int weight;
    private int minForceToMove;
    private final int price;

    public NotAlive(String name, int weight, int minForceToMove, int price) {
        this.name = name;
        this.weight = weight;
        this.minForceToMove = minForceToMove;
        this.price = price;
    }

    public void printIsMove() {
        System.out.println("Сдвинется ли " + this.getName() + " при силе " + force + "Н? " + move());
    }

    public void printIsMove(int force) {
        this.force = force;
        printIsMove();
    }

    @Override
    public boolean move() {
        boolean isTrue = force > minForceToMove;
        force = 0;
        return isTrue;
    }

    @Override
    public String toString() {
        return "NotAlive{" +
                "\nname = '" + name + '\'' +
                ", \nweight=" + weight +
                ", \nminForceToMove=" + minForceToMove +
                "\n}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotAlive notAlive = (NotAlive) o;
        return weight == notAlive.weight &&
                minForceToMove == notAlive.minForceToMove &&
                name.equals(notAlive.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, minForceToMove);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMinForceToMove() {
        return minForceToMove;
    }

    public void setMinForceToMove(int minForceToMove) {
        this.minForceToMove = minForceToMove;
    }

    public int getPrice() {
        return price;
    }

}
