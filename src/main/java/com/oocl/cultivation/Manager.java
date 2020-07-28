package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class Manager {

    List<ParkingBoy> parkingBoyList;

    public Manager() {
        this.parkingBoyList = new ArrayList<>();
    }

    public int addParkingBoyList(ParkingBoy parkingBoy) {
        this.parkingBoyList.add(parkingBoy);
        return this.parkingBoyList.size();
    }
}
