package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    public Map<CarTicket, Car> carTicketCarMap;

    private int capacity;

    public ParkingLot() {
        this.carTicketCarMap = new HashMap<>();
        this.capacity = 10;
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        this.carTicketCarMap.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        return this.carTicketCarMap.remove(carTicket);
    }

    public CarTicket judgeCapacityPark(Car car) {
        if (this.carTicketCarMap.size() <= this.capacity) {
           CarTicket carTicket = this.park(car);
           this.capacity--;
           return carTicket;
        }
        return null;
    }
}
