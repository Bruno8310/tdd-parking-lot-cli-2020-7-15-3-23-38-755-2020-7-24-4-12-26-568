package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SmartParkingBoyTest {
    @Test
    void should_return_first_parkingLot_size_1_when_parkingLot_hava_max_position_give_2_parkingLot_and_3_cars() {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            parkingLots.add(new ParkingLot());
        }
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
        // when
        for (int j = 0; j < 3; j++) {
            smartParkingBoy.park(new Car());
        }
        // then
        assertEquals(1, smartParkingBoy.getParkingLot().getCarTicketCarMap().size());
    }
}
