package com.oocl.cultivation.test;

import com.oocl.cultivation.Manager;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceManagerTest {

    @Test
    void should_return_parkingBoy_id_when_add_parkingBoy_give_manager_and_parkingBoy() {
        // given
        List<ParkingLot> parkingLots = new ArrayList<>();

        ParkingLot parkingLotA = new ParkingLot();
        ParkingLot parkingLotB = new ParkingLot();
        parkingLots.add(parkingLotA);
        parkingLots.add(parkingLotB);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Manager manager = new Manager();

        // when
        int result = manager.addParkingBoyList(parkingBoy);

        // then
        assertEquals(1, result);
    }



}
