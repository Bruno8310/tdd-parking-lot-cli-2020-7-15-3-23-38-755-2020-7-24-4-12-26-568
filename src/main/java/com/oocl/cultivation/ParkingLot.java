package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Car car;
    private CarTicket carTicket;

    Map<CarTicket, Car> carTicketCarMap = new HashMap<>();

    public CarTicket park(Car car) {
        return new CarTicket();
    }

    public Car fetch(CarTicket carTicket) {
        return new Car();
    }
}
