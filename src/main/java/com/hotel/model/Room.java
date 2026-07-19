package com.hotel.model;

public class Room {

    private int roomNumber;
    private String category;
    private double price;
    private boolean available;

    // Constructor
    public Room(int roomNumber, String category, double price, boolean available) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.available = available;
    }

    // Getters
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    // Setters
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    // Display Room Details
    public void displayRoom() {

        System.out.println("-------------------------------------");
        System.out.println("Room Number : " + roomNumber);
        System.out.println("Category    : " + category);
        System.out.println("Price       : ₹" + price);
        System.out.println("Status      : " + (available ? "Available" : "Booked"));
        System.out.println("-------------------------------------");

    }

}