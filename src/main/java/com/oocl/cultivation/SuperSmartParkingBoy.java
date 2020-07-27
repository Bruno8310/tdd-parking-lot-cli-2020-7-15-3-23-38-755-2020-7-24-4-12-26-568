package com.oocl.cultivation;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{


    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public CarTicket park(Car car) {

        Collections.sort(this.getParkingLotList(), new Comparator<ParkingLot>() {
            @Override
            public int compare(ParkingLot o1, ParkingLot o2) {
                return  -(o1.getCapacity() - o1.getCarTicketCarMap().size()) / o1.getCapacity() + (o2.getCapacity() - o2.getCarTicketCarMap().size()) / o2.getCapacity();
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
            return this.parkingLot.park(car);
        }
        return null;
    }
}
