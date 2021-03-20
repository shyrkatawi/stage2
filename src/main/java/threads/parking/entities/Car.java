package threads.parking.entities;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    private String name;
    private Parking parking;

    public Car(String name, Parking parking) {
        this.name = name;
        this.parking = parking;
    }

    public void tryToTakeParkingPlace() {
        System.out.println(name+" is trying to take parking place");
        parking.setParkingPlace(this);
        parking.showParking();
    }

    public void leaveParkingPlace() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
//        parking.removeCarFromParkingPlace(this);
        parking.showParking();
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(name+" started");
// need to create timer and while()
        try {
            tryToTakeParkingPlace();
            leaveParkingPlace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return name.equals(car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
