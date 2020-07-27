package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {



    @Test
    void should_return_no_car_when_fetch_car_give_is_used_carTicket() {
        // given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car firstCar = new Car();

        // when
        CarTicket carTicket = parkingBoy.park(firstCar);
        parkingBoy.fetch(carTicket);

        Car thirdCar = parkingBoy.fetch(carTicket);
        // then
        assertNull(thirdCar);
    }

    @Test
    void should_judge_parkingLotCapacity_when_parkingBoy_park_give_car() {
        // TODO The parking lot has a capacity (the default capacity of a parking lot is 10).
        //   If there is no position, then the user cannot park the car into it. Thus (s)he will not get any ticket.

        // give
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket carTicket = Mockito.mock(CarTicket.class);
        // when
        for (int i = 0; i < 21; i++) {
            Car car = new Car();
            carTicket = parkingBoy.judgeCapacityPark(car);
        }
        // then
        assertNull(carTicket);
    }

    @Test
    void should_get_message_when_parking_car_give_wrong_ticket_or_used_ticket() {
        // give
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket carTicket = parkingBoy.judgeCapacityPark(new Car());
        CarTicket wrongTicket = new CarTicket();

        // when
        parkingBoy.fetch(carTicket);
        parkingBoy.fetch(carTicket);
        parkingBoy.fetch(wrongTicket);
        // then
        assertEquals("Unrecognized parking ticket.", parkingBoy.getResponseMessage());
        assertEquals("Unrecognized parking ticket.", parkingBoy.getResponseMessage());
    }

    @Test
    void should_get_message_when_parking_car_give_null_carTicket() {
        // give
        ParkingBoy parkingBoy = new ParkingBoy();
        // when
        parkingBoy.fetch();
        // then
        assertEquals("Please provide your parking ticket.", parkingBoy.getResponseMessage());
    }

    @Test
    void should_get_message_when_parking_car_give_without_position() {
        // give
        ParkingBoy parkingBoy = new ParkingBoy();

        // when
        for (int i = 0; i < 21; i++) {
            Car car = new Car();
            parkingBoy.judgeCapacityPark(car);
        }
        // then
        assertEquals("Not enough position.", parkingBoy.getResponseMessage());
    }

    @Test
    void should_park_multiple_cars_when_in_order_parking_give_parkingLot_list() {
        // give
        ParkingBoy parkingBoy = new ParkingBoy();
        CarTicket carTicket = Mockito.mock(CarTicket.class);
        for (int i = 0; i < 2; i++) {
            parkingBoy.getParkingLotList().add(new ParkingLot());
        }
        // when
        for (int i = 0; i < 21; i++) {
            Car car = new Car();
            carTicket = parkingBoy.judgeCapacityPark(car);
        }
        // then
        assertNull(carTicket);
    }

}
