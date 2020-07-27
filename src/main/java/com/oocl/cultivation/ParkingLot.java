package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    Map<CarTicket, Car> carTicketCarMap;

    public ParkingLot() {
        this.carTicketCarMap = new HashMap<>();
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        this.carTicketCarMap.put(carTicket, car);
        return carTicket;
    }

    public Car fetch(CarTicket carTicket) {
        Car car = this.carTicketCarMap.get(carTicket);
        return car;
    }
}
