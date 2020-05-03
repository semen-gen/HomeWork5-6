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
            System.out.println(i + ": " + inStock[i].getName() + ", цена: " + inStock[i].getPrice());
        }
        if (inStock == null || inStock.length == 0) {
            System.out.println("В магазине нет товара");
        }
    }

    public void purchase(int productIndex, int amountMoney) {
        if (productIndex <= inStock.length) {
            if (amountMoney >= getPriceByIndex(productIndex)) {
                cashBox += getPriceByIndex(productIndex);
                popProduct(productIndex);
                System.out.println("Товар преобретён");
            }
            else {
                System.out.println("Недостаточно денег");
            }
        }
        else {
            System.out.println("Такого товара не существует");
        }
    }

    public M[] getInStock() {
        return inStock;
    }

    public int getCashBox() {
        return cashBox;
    }

    public void setCashBox(int cashBox) {
        this.cashBox = cashBox;
    }


    private int getPriceByIndex(int index) {
        return inStock[index].getPrice();
    }

    private void popProduct(int index) {
        int newLength = inStock.length - 1;
        M[] tempArray = (M[]) new Movable[newLength];

        for (int i = 0, n = 0; i < inStock.length; i++, n++) {
            if (i == index) {
                n--;
                continue;
            }
            tempArray[n] = inStock[i];
        }
        inStock = tempArray;
    }

    private void pushProduct(M product) {
        int newLength = inStock.length + 1;
        M[] tempArray = (M[]) new Movable[newLength];

        for (int i = 0; i < inStock.length; i++) tempArray[i] = inStock[i];

        tempArray[inStock.length] = product;
        inStock = tempArray;
    }

}
