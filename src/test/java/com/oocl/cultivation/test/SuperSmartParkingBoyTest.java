package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {

    @Test
    void should_park_cars_when_parkingLot_hava_large_position_rate_give_parkingLot_list() {
        // give
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();

        // when
        for (int i = 0; i < 3; i++) {
            superSmartParkingBoy.judgeCapacityPark(new Car());
        }
        ParkingLot firstParkingLot = superSmartParkingBoy.getParkingLotList().get(0);
        ParkingLot secondParkingLot = superSmartParkingBoy.getParkingLotList().get(1);

        int firstParkingLotSize = firstParkingLot.getCarTicketCarMap().size();
        int secondParkingLotSize = secondParkingLot.getCarTicketCarMap().size();

        // then
        assertEquals(2, firstParkingLotSize);
        assertEquals(1, secondParkingLotSize);
    }
}
