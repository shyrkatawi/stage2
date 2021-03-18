package threads.parking.entities;

public class Parking {
    ParkingPlace[] parkingPlaces;

    public Parking(int parkingSize) {
        parkingPlaces = new ParkingPlace[parkingSize];
        for (int i = 0; i < parkingPlaces.length; i++) {
            parkingPlaces[i] = new ParkingPlace();
        }
    }

    synchronized public boolean setParkingPlace(Car car) {
        for (ParkingPlace parkingPlace : parkingPlaces) {
            if (parkingPlace.checkIsAvailable()) {
                parkingPlace.parkCar(car);
                return true;
            }
        }
        return false;
    }

    synchronized public boolean removeCarFromParkingPlace(Car car) {
        for (ParkingPlace parkingPlace : parkingPlaces) {
            if (car.equals(parkingPlace.getCar())) {
                parkingPlace.removeCar();
                return true;
            }
        }
        return false;
    }


    public void showParking() {
        System.out.print("parking now: ");
        for (ParkingPlace parkingPlace : parkingPlaces) {
            System.out.print(parkingPlace + ", ");
        }
        System.out.println();
    }
}
