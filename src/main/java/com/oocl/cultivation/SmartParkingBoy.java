package com.oocl.cultivation;


import java.util.Collections;
import java.util.Comparator;

public class SmartParkingBoy extends ParkingBoy {

    public SmartParkingBoy() {
        super();
    }

    @Override
    public CarTicket judgeCapacityPark(Car car) {

        Collections.sort(this.getParkingLotList(), new Comparator<ParkingLot>() {
            @Override
            public int compare(ParkingLot o1, ParkingLot o2) {
                return o1.getCarTicketCarMap().size() - o2.getCarTicketCarMap().size();
            }
        });
        ParkingLot firstparkingLot = this.getParkingLotList().get(0);
        if (firstparkingLot.getCapacity() > 0) {
            CarTicket carTicket = this.park(car);
            firstparkingLot.setCapacity();
            return carTicket;
        } else {
            this.setResponseMessage("Not enough position.");
            return null;
        }


    }
}
