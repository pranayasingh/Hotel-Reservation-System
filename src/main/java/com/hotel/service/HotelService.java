package com.hotel.service;

import com.hotel.model.Room;

import java.util.ArrayList;

public class HotelService {

    private ArrayList<Room> rooms;

    // Constructor
    public HotelService() {

        rooms = new ArrayList<>();

        // Standard Rooms
        rooms.add(new Room(101, "Standard", 1500, true));
        rooms.add(new Room(102, "Standard", 1500, true));

        // Deluxe Rooms
        rooms.add(new Room(201, "Deluxe", 2500, true));
        rooms.add(new Room(202, "Deluxe", 2500, true));

        // Suite Rooms
        rooms.add(new Room(301, "Suite", 5000, true));
        rooms.add(new Room(302, "Suite", 5000, true));
    }

    // Display All Rooms
    public void displayAllRooms() {

        System.out.println("\n========== ALL ROOMS ==========");

        for (Room room : rooms) {
            room.displayRoom();
        }

    }

    // Display Available Rooms
    public void displayAvailableRooms() {

        System.out.println("\n====== AVAILABLE ROOMS ======");

        boolean found = false;

        for (Room room : rooms) {

            if (room.isAvailable()) {
                room.displayRoom();
                found = true;
            }

        }

        if (!found) {
            System.out.println("No Rooms Available.");
        }

    }

    // Search Room by Category
    public void searchRoomByCategory(String category) {

        boolean found = false;

        System.out.println("\nSearching Rooms...");

        for (Room room : rooms) {

            if (room.getCategory().equalsIgnoreCase(category)
                    && room.isAvailable()) {

                room.displayRoom();
                found = true;

            }

        }

        if (!found) {

            System.out.println("No Room Found.");

        }

    }

    // Find Room using Room Number
    public Room findRoom(int roomNumber) {

        for (Room room : rooms) {

            if (room.getRoomNumber() == roomNumber) {

                return room;

            }

        }

        return null;

    }

    // Getter
    public ArrayList<Room> getRooms() {
        return rooms;
    }

}
