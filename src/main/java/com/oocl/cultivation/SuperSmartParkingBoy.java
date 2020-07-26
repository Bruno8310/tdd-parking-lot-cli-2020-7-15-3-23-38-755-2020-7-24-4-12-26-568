package com.oocl.cultivation;


import java.util.Collections;
import java.util.Comparator;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy() {
        super();
    }

    @Override
    public CarTicket judgeCapacityPark(Car car) {

        Collections.sort(this.getParkingLotList(), new Comparator<ParkingLot>() {
            @Override
            public int compare(ParkingLot o1, ParkingLot o2) {
                return (o2.getCapacity() - o2.getCarTicketCarMap().size()) / o2.getCapacity() - (o1.getCapacity() - o1.getCarTicketCarMap().size()) / o1.getCapacity();
            }
        });

        boolean isFull = true;
        for (ParkingLot lot : parkingLotList) {
            if (lot.getCarTicketCarMap().size() < lot.getCapacity()) {
                this.setParkingLot(lot);
                isFull = false;
                break;
            }
        }
        if (!isFull) {
            CarTicket carTicket = this.park(car);
            return carTicket;
        } else {
            this.setResponseMessage("Not enough position.");
            return null;
        }
    }
}
