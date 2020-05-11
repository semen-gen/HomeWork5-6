package local.store;

import local.movebals.cars.*;


public class MovableStore<P extends Purchasable> {

    private P[] inStock;
    private int cashBox;

    public MovableStore(P[] products) {
        inStock = products;
        if (products instanceof SportCar[]) cashBox = 1_000_000;
        else if (products instanceof OffRoadCar[]) cashBox = 100_000;
        else if (products instanceof Car[]) cashBox = 50_000;
        else cashBox = 10_000;
    }

    public void printProducts() {
        if (inStock == null || inStock.length == 0) {
            System.out.println("В магазине нет товара");
        }
        else {
            for (int i = 0; i < inStock.length; i++) {
                System.out.println(i + ": " + inStock[i].getName() + ", цена: " + inStock[i].getPrice());
            }
        }
    }

    public void purchase(int productIndex, int amountMoney) {
        if (productIndex <= inStock.length) {
            if (amountMoney >= getPriceByIndex(productIndex)) {
                P product = inStock[productIndex];
                cashBox += getPriceByIndex(productIndex);
                popProduct(productIndex);
                System.out.println("Вы преобрели " + product.getName() + " у магазина за " + product.getPrice());
            }
            else {
                System.out.println("Недостаточно денег");
            }
        }
        else {
            System.out.println("Такого товара не существует");
        }
    }

    public void sell(P product, int coast) {
        int commissionStore = 10;
        int sellCost = product.getPrice() - product.getPrice() * commissionStore / 100;
        if (coast <= sellCost) {
            if (coast <= cashBox) {
                cashBox -= coast;
                pushProduct(product);
                System.out.println("Магазин купил " + product.getName() + " за " + coast);
            }
            else {
                System.out.println("Не хватает денег в кассе. Перезвоните позже :-)");
            }
        }
        else {
            System.out.println("Предложите цену ниже");
        }

    }

    public P[] getInStock() {
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
        P[] tempArray = (P[]) new Purchasable[newLength];

        for (int i = 0, n = 0; i < inStock.length; i++, n++) {
            if (i == index) {
                n--;
                continue;
            }
            tempArray[n] = inStock[i];
        }
        inStock = tempArray;
    }

    private void pushProduct(P product) {
        int newLength = inStock.length + 1;
        P[] tempArray = (P[]) new Purchasable[newLength];

        for (int i = 0; i < inStock.length; i++) tempArray[i] = inStock[i];

        tempArray[inStock.length] = product;
        inStock = tempArray;
    }

}
