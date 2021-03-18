package threads.parking;

import threads.parking.entities.Car;
import threads.parking.entities.Parking;

/**
 * Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
 * Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Parking parking = new Parking(3);
        for (int i = 1; i < 20; i++) {
            Thread thread = new Thread(new Car("car" + i, parking));
            thread.start();
            Thread.sleep(300);
        }
    }
}
// Car method run()
// ParkingPlace constructor
// Parking synchronized with boolean methods