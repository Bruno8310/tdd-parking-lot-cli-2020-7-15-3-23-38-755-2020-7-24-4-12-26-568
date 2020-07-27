package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public CarTicket park(Car car) {
       return this.parkingLot.park(car);
    }

    public Car fetch(CarTicket carTicket) {
        return this.parkingLot.fetch(carTicket);
    }

    public Car fetch() {
        return this.parkingLot.fetch();
    }


    public String getMessage() {
        return this.parkingLot.getMessage();
    }
}
