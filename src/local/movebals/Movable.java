package local.movebals;

public interface Movable {

    boolean move();

    default String getName() {
        return "Default getName";
    }

    default int getPrice() {
        return 0;
    }

}
