package threads.parking.entities;

import threads.parking.ParkingManager;

public class Car implements Runnable {
    private static int id = 1;
    private String name;
    private ParkingManager parkingManager;
    private int waitTimeForParking;
    private int parkingTime;

    public Car(ParkingManager parkingManager, int waitTimeForParking, int parkingTime) {
        this.parkingManager = parkingManager;
        name = "car" + id;
        id++;
        this.waitTimeForParking = waitTimeForParking;
        this.parkingTime = parkingTime;
    }

    @Override
    public void run() {
        try {
            parkingManager.startParking(this, waitTimeForParking, parkingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
