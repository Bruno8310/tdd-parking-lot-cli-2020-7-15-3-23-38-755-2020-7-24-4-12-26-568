package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    protected List<ParkingLot> parkingLotList;

    protected ParkingLot parkingLot ;

    protected String responseMessage;

    public ParkingBoy() {
        this.parkingLotList = new ArrayList<>();
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }


    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        this.getParkingLot().getCarTicketCarMap().put(carTicket, car);
        return carTicket;
    }

    public CarTicket judgeCapacityPark(Car car) {
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

    public Car fetch(CarTicket carTicket) {
        if (carTicket != null && this.getParkingLot().getCarTicketCarMap().containsKey(carTicket)) {
            Car car = this.getParkingLot().getCarTicketCarMap().get(carTicket);
            this.getParkingLot().getCarTicketCarMap().remove(carTicket);
            return car;
        }
        this.setResponseMessage("Unrecognized parking ticket.");
        return null;
    }

    public void fetch() {
        this.setResponseMessage("Please provide your parking ticket.");
    }
}
