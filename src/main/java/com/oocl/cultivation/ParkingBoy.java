package com.oocl.cultivation;

import java.util.ArrayList;

public class ParkingBoy {

    private final ParkingLot parkingLot;

    private final ArrayList<Car> cars;

    private String responseMessage;

    public ParkingBoy() {
        this.cars = new ArrayList<>();
        this.parkingLot = new ParkingLot();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public int parkCarGetCarsSize(Car car) {
        this.getCars().add(car);
        this.getParkingLot().getCarTicketCarMap().put(new CarTicket(), car);
        return this.getCars().size();
    }

    public CarTicket park(Car car) {
        CarTicket carTicket = new CarTicket();
        this.getParkingLot().getCarTicketCarMap().put(carTicket, car);
        return carTicket;
    }

    public CarTicket judgeCapacityPark(Car car) {
        if (this.getParkingLot().getCapacity() > 0) {
            CarTicket carTicket = this.park(car);
            this.getParkingLot().setCapacity();
            return carTicket;
        }
        return null;
    }

    public Car fetch(CarTicket carTicket) {
        if (!carTicket.equals(null) && this.getParkingLot().getCarTicketCarMap().containsKey(carTicket)) {
            Car car = this.getParkingLot().getCarTicketCarMap().get(carTicket);
            this.getParkingLot().getCarTicketCarMap().remove(carTicket);
            return car;
        }
        this.setResponseMessage("Unrecognized parking ticket.");
        return null;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
