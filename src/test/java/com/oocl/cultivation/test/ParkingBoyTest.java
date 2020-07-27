package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.CarTicket;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
