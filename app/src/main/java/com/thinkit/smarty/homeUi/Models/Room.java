package com.thinkit.smarty.homeUi.Models;

public class Room {
    private String name;
    private String deviceNumber;
    private int image;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeviceNumber() {
        return deviceNumber;
    }

    public void setDeviceNumber(String deviceNumber) {
        this.deviceNumber = deviceNumber;
    }

    public Room(String name, String deviceNumber, int image) {
        this.name = name;
        this.deviceNumber = deviceNumber;
        this.image = image;
    }
}
