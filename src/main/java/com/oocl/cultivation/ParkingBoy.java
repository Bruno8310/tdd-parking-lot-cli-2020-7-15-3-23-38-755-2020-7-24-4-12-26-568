package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    List<ParkingLot> parkingLotList;

    ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLotList = parkingLots;
        this.parkingLot = this.parkingLotList.get(0);
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public CarTicket park(Car car) {
       boolean isFull = true;
       for (ParkingLot lot: parkingLotList) {
           if (lot.getCarTicketCarMap().size() < lot.gerCapacity()) {
               this.setParkingLot(lot);
               isFull = false;
               break;
           }
       }
       if (!isFull) {
           return this.parkingLot.park(car);
       }
       return null;
}

    private void setParkingLot(ParkingLot lot) {
        this.parkingLot = lot;
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

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }
}
