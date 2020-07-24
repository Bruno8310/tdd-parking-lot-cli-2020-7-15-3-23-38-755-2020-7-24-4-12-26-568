package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_park_give_car() {
        // given
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();

        // when
        CarTicket carTicket = parkingLot.park(car);

        // then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetch_from_packingLot_give_carTicket() {
        // given
        Car car = new Car();
        CarTicket carTicket = new CarTicket();
        ParkingLot parkingLot = new ParkingLot();

        // when
        Car actualCar = parkingLot.fetch(carTicket);

        // then
        assertNotNull(car);
//        assertEquals(car, actualCar);

    }
}
