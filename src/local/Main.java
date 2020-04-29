package local;

import local.movebals.Movable;
import local.movebals.animals.Animals;
import local.movebals.cars.Car;
import local.movebals.cars.CarBrand;
import local.movebals.cars.OffRoadCar;
import local.movebals.cars.SportCar;
import local.movebals.notalives.NotAlive;
import local.store.Store;

import java.util.Arrays;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        Car i530 = new SportCar("530", 53, "Синий", 2, Calendar.JULY, 2019, CarBrand.BMW,
                350, 3.8, 638, 700000);
        System.out.println("Данные по машине " + i530.getBrand().getNameRu() + " " + i530.getName());
        System.out.println("Кватер за: " + ((SportCar) i530).quarterTime());
        System.out.println("Время круга: " + ((SportCar) i530).timeLap(15));
        i530.move();
        System.out.println("Машина едет " + i530.isRide());
        i530.braking();
        System.out.println("Машина едет " + i530.isRide());
        System.out.println(i530);
        System.out.println('\n');


        Car niva = new OffRoadCar("Niva 4x4", 2145, "Зелёный", 15, Calendar.AUGUST, 2003,
                CarBrand.LADA, 29, 35, 180, 185, 6000);
        System.out.println("Данные по машине " + niva.getBrand().getNameRu() + " " + niva.getName());
        System.out.println("Преодолеет брод 150см: " + ((OffRoadCar) niva).fordDepth(150));
        System.out.println("Проедет между двумя деревьями (200см): " + ((OffRoadCar) niva).canPassBetween(200));
        niva.move();
        System.out.println("Машина едет " + niva.isRide());
        niva.braking();
        System.out.println("Машина едет " + niva.isRide());
        System.out.println(niva);
        System.out.println('\n');

        System.out.println("Сравнение машин");
        System.out.println(niva.equals(i530));
        System.out.println('\n');

        Animals hare = new Animals("Зайчик", 4, false, 20);
        System.out.println("Животное " + hare.getName());
        System.out.println(hare.getName() + " двигается? " + hare.move());
        hare.toScare();
        System.out.println(hare.getName() + " двигается? " + hare.move());
        hare.toReassure();
        System.out.println(hare.getName() + " двигается? " + hare.move());
        System.out.println('\n');

        NotAlive stone = new NotAlive("Каменюка", 3, 50, 0);
        System.out.println("Предмет " + stone.getName());
        stone.printIsMove();
        stone.force = 30;
        stone.printIsMove();
        stone.printIsMove(60);
        stone.printIsMove();
        System.out.println(stone);

        System.out.println("===================");
        Movable[] test = new SportCar[]{(SportCar) i530};
        Store<Movable> topGear = new Store<>(test);



//        System.out.println(Arrays.toString(topGear.getInStock()));
        System.out.println(topGear.getCashBox());


    }

}
