package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {

    @Test
    void should_select_large_position_rate_to_parking_when_parking_cars_give_car_list_and_parkingLot_list() {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            parkingLots.add(new ParkingLot());
        }
        SuperSmartParkingBoy supertParkingBoyarkingBoy = new SuperSmartParkingBoy(parkingLots);
        // when
        for (int j = 0; j < 3; j++) {
            supertParkingBoyarkingBoy.park(new Car());
        }
        // then
        assertEquals(2, supertParkingBoyarkingBoy.getParkingLotList().get(0).getCarTicketCarMap().size());
        assertEquals(1, supertParkingBoyarkingBoy.getParkingLotList().get(1).getCarTicketCarMap().size());
    }
}
