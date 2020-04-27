package local.movebals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public abstract class Car implements Movable {

    protected String name;
    protected int number;
    protected String color;
    protected Calendar dateRelease;
    protected CarBrand brand;
    protected boolean isRide;
    protected final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("d MMMM yyyy");

    public abstract boolean move();

    public abstract boolean braking();



    public Car(String name, int number, String color, int day, int month, int year, CarBrand brand) {
        this.name = name;
        this.number = number;
        this.color = color;
        this.dateRelease = new Calendar.Builder().setDate(year, month, day).build();
        this.brand = brand;
        this.isRide = false;
    }

    private Car() {

    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Car{")
                .append("\nname='").append(name).append('\'')
                .append(", \nnumber=").append(number)
                .append(", \ncolor='").append(color).append('\'')
                .append(", \ndateRelease=").append(getDateRelease())
                .append(", \nbrand=").append(brand)
                .append(", \nisRide=").append(isRide)
                .append("\n}");
        return output.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name) &&
                color.equals(car.color) &&
                brand == car.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, color, dateRelease, brand);
    }

    public String getDateRelease() {
        return DATE_FORMAT.format(dateRelease.getTime());
    }

    public String getName() {
        return name;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public boolean isRide() {
        return isRide;
    }

}
