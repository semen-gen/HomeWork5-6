package local.store;

import local.movebals.Movable;
import local.movebals.cars.*;


public class Store<M extends Movable> {

    private M[] inStock;
    private int cashBox;

    public Store(M product) {
        inStock = (M[]) new Movable[]{product};
        if (product instanceof SportCar) cashBox = 1_000_000;
        else if (product instanceof OffRoadCar) cashBox = 100_000;
        else if (product instanceof Car) cashBox = 50_000;
        else cashBox = 10_000;
    }

    public Store(M[] products) {
        inStock = products;
        if (products instanceof SportCar[]) cashBox = 1_000_000;
        else if (products instanceof OffRoadCar[]) cashBox = 100_000;
        else if (products instanceof Car[]) cashBox = 50_000;
        else cashBox = 10_000;
    }

    public void printProducts() {
        for (int i = 0; i < inStock.length; i++) {
            System.out.println(i + ": "+ inStock[i].getName());
        }

    }

    public M[] getInStock() {
        return inStock;
    }

    public void addInStock(M product) {

    }

    public int getCashBox() {
        return cashBox;
    }

    public void setCashBox(int cashBox) {
        this.cashBox = cashBox;
    }

}
