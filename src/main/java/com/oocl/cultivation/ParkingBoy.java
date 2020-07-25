package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {

    private ParkingLot parkingLot;

    private ArrayList<Car> cars;

    public ParkingBoy() {
        this.cars = new ArrayList<>();
        this.parkingLot = new ParkingLot();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public int parkCar(Car car) {
        this.cars.add(car);

        this.parkingLot.carTicketCarMap.put(new CarTicket(), car);

        return this.cars.size();
    }

    public Car fetch(CarTicket carTicket) {
        return this.parkingLot.carTicketCarMap.get(carTicket);
    }
}
