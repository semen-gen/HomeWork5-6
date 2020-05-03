package local.movebals;

public interface Movable {

    boolean move();

    default String getName() {
        return "Default getName";
    }

}
