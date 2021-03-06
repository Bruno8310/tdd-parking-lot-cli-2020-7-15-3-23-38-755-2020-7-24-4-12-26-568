package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    Map<CarTicket, Car> carTicketCarMap;

    int capacity;

    String message;

    public ParkingLot() {
        this.carTicketCarMap = new HashMap<>();
        this.capacity = 10;
    }

    public CarTicket park(Car car) {
        if (this.carTicketCarMap.size() < this.capacity) {
            CarTicket carTicket = new CarTicket();
            this.carTicketCarMap.put(carTicket, car);
            return carTicket;
        }
        this.setMessage("Not enough position.");
        return null;
    }

    public Car fetch(CarTicket carTicket) {
        if (carTicket != null && this.carTicketCarMap.containsKey(carTicket)) {
            Car car = this.carTicketCarMap.remove(carTicket);
            return car;
        }
        this.setMessage("Unrecognized parking ticket.");
        return null;
    }

    public Car fetch() {
        this.setMessage("Please provide your parking ticket.");
        return null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<CarTicket, Car> getCarTicketCarMap() {
        return carTicketCarMap;
    }

    public int getCapacity() {
        return capacity;
    }
}
