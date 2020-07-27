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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();
        // when
        CarTicket carTicket = parkingBoy.park(car);
        // then
        assertNotNull(carTicket);
    }

    @Test
    void should_fetch_car_when_fetch_from_packingLot_give_carTicket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car carA = new Car();
        CarTicket carTicket = parkingBoy.park(carA);

        // when
        Car carB = parkingBoy.fetch(carTicket);
        // then
        assertEquals(carA, carB);

    }

    @Test
    void should_return_right_car_when_park_multiple_car_give_mutiple_carTicket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car carA = new Car();
        Car carB = new Car();

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
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();
        // when
        CarTicket carTicket = parkingBoy.park(car);
        Car car1 = parkingBoy.fetch(carTicket);
        Car car2 = parkingBoy.fetch(carTicket);
        assertNotEquals(car1, car2);
    }

    @Test
    void should_get_message_when_parking_car_give_wrong_ticket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();

        // when
        parkingBoy.park(car);
        CarTicket carTicket = new CarTicket();
        Car car1 = parkingBoy.fetch(carTicket);
        // then
        assertNull(car1);
    }

    @Test
    void should_return_no_ticket_when_parkingLot_is_full_give_car() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        // when
        for (int i = 0; i < 10; i++) {
            parkingBoy.park(new Car());
        }
        CarTicket carTicket = parkingBoy.park(new Car());
        // then
        assertNull(carTicket);
    }


    @Test
    void should_get_message_when_parking_car_give_null_carTicket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());

        // when
        parkingBoy.fetch();
        // then
        assertEquals("Please provide your parking ticket.", parkingBoy.getMessage());
    }

    @Test
    void should_get_message_when_parking_car_give_wrong_carTicket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy(new ParkingLot());
        Car car = new Car();

        // when
        parkingBoy.park(car);
        CarTicket carTicket = new CarTicket();
        Car car1 = parkingBoy.fetch(carTicket);

        // then
        assertEquals("Unrecognized parking ticket.", parkingBoy.getMessage());

    }

    @Test
    void should_get_message_when_parking_car_and_parkingLot_is_full_give_car() {

    }
}
