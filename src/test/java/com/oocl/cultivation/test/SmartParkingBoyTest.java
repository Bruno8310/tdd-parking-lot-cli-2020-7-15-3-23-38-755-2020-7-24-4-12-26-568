package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_park_cars_when_parkingLot_hava_max_position_give_parkingLot_list() {
        // give
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();

        // when
        for (int i = 0; i < 3; i++) {
            smartParkingBoy.judgeCapacityPark(new Car());
        }

        ParkingLot firstParkingLot = smartParkingBoy.getParkingLotList().get(0);
        ParkingLot secondParkingLot = smartParkingBoy.getParkingLotList().get(1);

        int firstParkingLotSize = firstParkingLot.getCarTicketCarMap().size();
        int secondParkingLotSize = secondParkingLot.getCarTicketCarMap().size();
        // then
        assertEquals(2, firstParkingLotSize);
        assertEquals(1, secondParkingLotSize);
    }
}
