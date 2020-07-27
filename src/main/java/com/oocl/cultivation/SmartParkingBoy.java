package com.oocl.cultivation;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {


    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {
        Collections.sort(this.getParkingLotList(), new Comparator<ParkingLot>() {
            @Override
            public int compare(ParkingLot o1, ParkingLot o2) {
                return o1.getCarTicketCarMap().size() - o2.getCarTicketCarMap().size();
            }
        });
        boolean isFull = true;
        for (ParkingLot lot: parkingLotList) {
            if (lot.getCarTicketCarMap().size() < lot.getCapacity()) {
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
}
