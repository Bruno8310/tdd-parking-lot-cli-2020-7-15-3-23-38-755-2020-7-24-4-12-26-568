package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_park_give_car() {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < 2; i++) {
            parkingBoy.getParkingLotList().add(new ParkingLot());
        }
        parkingBoy.setParkingLot(parkingBoy.getParkingLotList().get(0));
        // when
        CarTicket carTicket = parkingBoy.park(car);

        // then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetch_from_packingLot_give_carTicket() {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < 2; i++) {
            parkingBoy.getParkingLotList().add(new ParkingLot());
        }
        parkingBoy.setParkingLot(parkingBoy.getParkingLotList().get(0));
        // when
        CarTicket carTicket = parkingBoy.park(car);
        Car autualCar = parkingBoy.fetch(carTicket);

        // then
        assertNotNull(autualCar);
    }

    @Test
    void should_return_right_car_when_park_multiple_car_give_mutiple_carTicket() {
        // given
        Car carA = new Car();
        Car carB = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        for (int i = 0; i < 2; i++) {
            parkingBoy.getParkingLotList().add(new ParkingLot());
        }
        parkingBoy.setParkingLot(parkingBoy.getParkingLotList().get(0));
        // when
        CarTicket carTicketA = parkingBoy.park(carA);
        CarTicket carTicketB = parkingBoy.park(carB);

        // then
        assertNotEquals(carA, parkingBoy.fetch(carTicketB));
        assertNotEquals(carB, parkingBoy.fetch(carTicketA));
    }

    @Test
    void should_return_no_car_when_fetch_car_give_is_used_carTicket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car firstCar = new Car();
        for (int i = 0; i < 2; i++) {
            parkingBoy.getParkingLotList().add(new ParkingLot());
        }
        parkingBoy.setParkingLot(parkingBoy.getParkingLotList().get(0));

        // when
        CarTicket carTicket = parkingBoy.park(firstCar);
        parkingBoy.fetch(carTicket);

        Car thirdCar = parkingBoy.fetch(carTicket);
        // then
        assertNull(thirdCar);
    }
}
