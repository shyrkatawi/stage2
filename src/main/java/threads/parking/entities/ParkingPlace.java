package threads.parking.entities;

public class ParkingPlace {
    private static int ID = 1;
    private final int placeId;
    private Car car;
    private boolean isAvailable;
//    private Car car = null;
//    private boolean isAvailable = true;

//    public ParkingPlace() {
//        placeId = ID;
//        ID++;
//    }

    public ParkingPlace() {
        car = null;
        isAvailable = true;
        placeId = ID;
        ID++;
    }

    public Car getCar() {
        return car;
    }

    public void parkCar(Car car) {
        this.car = car;
        isAvailable = false;
    }

    public void removeCar() {
        car = null;
        isAvailable = true;
    }

    public boolean checkIsAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return "placeId=" + placeId +
                ", car=" + car;
    }
}
