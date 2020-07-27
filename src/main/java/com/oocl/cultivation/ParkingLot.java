package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    Map<CarTicket, Car> carTicketCarMap;

    int capacity;

    public ParkingLot() {
        this.carTicketCarMap = new HashMap<>();
        this.capacity = 10;
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        if (this.carTicketCarMap.size() < this.capacity) {

            this.carTicketCarMap.put(carTicket, car);
            return carTicket;
        }
        return null;
    }

    public Car fetch(CarTicket carTicket) {
        if (carTicket != null && this.carTicketCarMap.containsKey(carTicket)) {
            Car car = this.carTicketCarMap.remove(carTicket);
            return car;
        }
        return null;
    }
}
