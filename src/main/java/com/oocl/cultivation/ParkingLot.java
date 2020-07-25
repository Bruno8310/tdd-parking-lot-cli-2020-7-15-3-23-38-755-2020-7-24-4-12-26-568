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

    public Map<CarTicket, Car> getCarTicketCarMap() {
        return carTicketCarMap;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity() {
         --this.capacity;
    }
}
