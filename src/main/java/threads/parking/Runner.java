package threads.parking;

import threads.parking.entities.Car;


/**
 * Автостоянка. Доступно несколько машиномест. На одном месте может находиться только один автомобиль.
 * Если все места заняты, то автомобиль не станет ждать больше определенного времени и уедет на другую стоянку.
 */
public class Runner {
    public static void main(String[] args) {
        ParkingManager parkingManager = new ParkingManager(3);
        for (int i = 0; i < 10; i++) {
            new Thread(new Car(parkingManager, 2, 1)).start();
        }
    }
}