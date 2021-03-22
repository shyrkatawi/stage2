package threads.parking;

import threads.parking.entities.Car;
import threads.parking.entities.Parking;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ParkingManager {
    Parking parking;
    Semaphore semaphore;

    public ParkingManager(int parkingSize) {
        if (parkingSize < 1) {
            throw new IllegalArgumentException("Parking size must be more than 0");
        }
        parking = new Parking(parkingSize);
        semaphore = new Semaphore(parkingSize, true);
    }

    public void startParking(Car car, int waitTimeForParking, int parkingTime) throws InterruptedException {
        if (semaphore.tryAcquire(waitTimeForParking, TimeUnit.SECONDS)) {
            parking.addCar(car);
            TimeUnit.SECONDS.sleep(parkingTime);
            parking.removeCar(car);
            semaphore.release();
        } else {
            System.out.println(car + " can not wait for parking anymore");
        }
    }
}
