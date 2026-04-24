package application.domain;

import java.util.Scanner;

public class BedRoom {


    Scanner sc = new Scanner(System.in);


    private int roomId;
    private String room;
    private BedRoomType bedRoomType;
    private double price;
    private String state;


    // Constructors

    public BedRoom(){

    }

    public BedRoom(int roomId, String room,BedRoomType type,double price, String state) {
        this.roomId = roomId;
        this.room = room;
        this.bedRoomType = type;
        this.price = price;
        this.state = state;
    }

    public BedRoom(String room) {
        this.room = room;
    }

    // Getter and Setters


    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BedRoomType getBedRoomType() {
        return bedRoomType;
    }

    public void setBedRoomType(BedRoomType bedRoomType) {
        this.bedRoomType = bedRoomType;
    }

    // Methods



}
