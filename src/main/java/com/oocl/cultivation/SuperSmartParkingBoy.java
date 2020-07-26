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
                return (o1.getCapacity() - o1.getCarTicketCarMap().size()) / o1.getCapacity() - (o2.getCapacity() - o2.getCarTicketCarMap().size()) / o2.getCapacity();
            }
        });

        ParkingLot firstparkingLot = this.getParkingLotList().get(0);
        if (this.getParkingLot().getCapacity() > 0) {
            CarTicket carTicket = this.park(car);
            this.getParkingLot().setCapacity();
            return carTicket;
        } else {
            this.setResponseMessage("Not enough position.");
            return null;
        }
    }
}
