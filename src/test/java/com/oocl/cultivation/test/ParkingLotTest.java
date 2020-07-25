package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void should_park_multiCar_when_park_by_packingBoy_give_car() {
        // given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        int size = parkingBoy.parkCar(car);
        // then
        Assertions.assertEquals(parkingBoy.getCars().size(), size);

    }

    @Test
    void should_return_car_when_fetch_car_by_carTicket_give_carTicket() {
        // given
        CarTicket carTicket = new CarTicket();
        ParkingBoy parkingBoy = new ParkingBoy();

        // when
        Car car = parkingBoy.fetch(carTicket);

        // then
        Assertions.assertEquals(parkingBoy.getParkingLot().fetch(carTicket), car);
    }

    @Test
    void should_return_no_car_when_parkingBoy_get_car_give_wrong_carTicket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();

        // when
        CarTicket carTicket = null;
        Car car = parkingBoy.fetch(carTicket);

        // then
        assertNull(car);
    }

    @Test
    void should_return_no_car_when_fetch_car_give_is_used_carTicket() {
        // given
        ParkingLot parkingLot = new ParkingLot();
        Car firstCar = new Car();

        // when
        CarTicket carTicket = parkingLot.park(firstCar);
        Car SecondCar = parkingLot.fetch(carTicket);
        // then
        assertNull(SecondCar);
    }
}
