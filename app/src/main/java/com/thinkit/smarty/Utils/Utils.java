package com.thinkit.smarty.Utils;

import com.thinkit.smarty.R;
import com.thinkit.smarty.homeUi.Models.Room;

import java.util.ArrayList;

public class Utils {

    public final static String NAME_KEY = "NAMEKEY";

    public static ArrayList<Room> createRoomsList(){
        ArrayList<Room> roomArrayList = new ArrayList<>();
        roomArrayList.add(new Room("Living Room","4 Devices", R.drawable.livingroom));
        roomArrayList.add(new Room("Media Room","6 Devices",R.drawable.mediaroom));
        roomArrayList.add(new Room("Bathroom","1 Device",R.drawable.bathroom));
        roomArrayList.add(new Room("Bedroom","3 Devices",R.drawable.bedroom));
        return roomArrayList;
    }
}
