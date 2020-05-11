package local.movebals.cars;

public class SportCar extends Car {

    private int maxSpeed;
    private double upTo100;
    private int power;

    public SportCar(String name, int number, String color, int day, int month, int year, CarBrand brand,
                    int maxSpeed, double upTo100, int power, int price) {
        super(name, number, color, day, month, year, brand);
        this.maxSpeed = maxSpeed;
        this.upTo100 = upTo100;
        this.power = power;
        this.price = price;
    }

    @Override
    public boolean move() {
        if (!isRide) {
            isRide = true;
        }
        return true;
    }

    @Override
    public boolean braking() {
        if (isRide) {
            isRide = false;
        }
        return false;
    }

    public double timeLap(double length) {
        double time = 0;
        for (int i = 0; i < (int) length; i++) {
            time += Math.random() * length;
        }
        return time;
    }

    public double quarterTime() {
        double time;
        double lengthOfQuarter = 402;

        time = Math.sqrt(lengthOfQuarter * 2 / accelerationMSS());

        return time;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double accelerationMSS() {
        final double SPEED_KM_H = 100;
        final double SECONDS_IN_HOUR = 3600;
        final double METERS_IN_KILOMETER = 1000;
        return SPEED_KM_H * METERS_IN_KILOMETER / SECONDS_IN_HOUR / upTo100;
    }

    public double getUpTo100() {
        return upTo100;
    }

    public void setUpTo100(int upTo100) {
        this.upTo100 = upTo100;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getPrice() {
        return price;
    }

}
