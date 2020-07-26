package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private final List<ParkingLot> parkingLotList;

    private ParkingLot parkingLot;

    private final ArrayList<Car> cars;

    private String responseMessage;

    public ParkingBoy() {
        this.cars = new ArrayList<>();
        this.parkingLotList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            this.getParkingLotList().add(new ParkingLot());
        }
        this.parkingLot = this.parkingLotList.get(0);
    }

    public int parkCarGetCarsSize(Car car) {
        this.getCars().add(car);
        this.getParkingLot().getCarTicketCarMap().put(new CarTicket(), car);
        return this.getCars().size();
    }

    public ArrayList<Car> getCars() {
        return cars;
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
