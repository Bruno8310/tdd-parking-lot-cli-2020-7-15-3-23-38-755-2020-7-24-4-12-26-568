package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {

    private ArrayList<Car> cars;

    public ParkingBoy() {
        this.cars = new ArrayList<>();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public int parkCar(Car car) {
        this.cars.add(car);
        return this.cars.size();
    }
}
