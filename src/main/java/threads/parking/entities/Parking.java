package threads.parking.entities;

public class Parking {
    Car[] cars;

    public Parking(int parkingSize) {
        cars = new Car[parkingSize];
    }

    public synchronized void showParkingState() {
        System.out.println("parking now:");
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    public synchronized void addCar(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (null == cars[i]) {
                cars[i] = car;
                break;
            }
        }
        System.out.println(car + " in the parking " );
        showParkingState();
    }

    public synchronized void removeCar(Car car) {
        for (int i = 0; i < cars.length; i++) {
            if (car.equals(cars[i])) {
                cars[i] = null;
                break;
            }
        }
        System.out.println(car + " left the parking");
        showParkingState();
    }

}
