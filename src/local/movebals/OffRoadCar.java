package local.movebals;

public class OffRoadCar extends Car {

    private int clarence;
    private int wheelSize;
    private int height;
    private int width;


    public OffRoadCar(String name, int number, String color, int day, int month, int year, CarBrand brand,
                      int clarence, int wheelSize, int height, int width) {
        super(name, number, color, day, month, year, brand);
        this.clarence = clarence;
        this.wheelSize = wheelSize;
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean move() {
        isRide = true;
        return true;
    }

    @Override
    public boolean braking() {
        isRide = false;
        return false;
    }

    public boolean canPassBetween(int width) {
        return this.width < width;
    }

    public boolean fordDepth(int deep) {
        return height > deep;
    }

    public int getClarence() {
        return clarence;
    }

    public void setClarence(int clarence) {
        this.clarence = clarence;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
