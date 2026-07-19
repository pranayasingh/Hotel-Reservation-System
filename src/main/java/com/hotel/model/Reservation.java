package com.hotel.model;

public class Reservation {

    private int reservationId;
    private Customer customer;
    private Room room;
    private String checkInDate;
    private String checkOutDate;
    private String status;

    // Constructor
    public Reservation(int reservationId,
                       Customer customer,
                       Room room,
                       String checkInDate,
                       String checkOutDate,
                       String status) {

        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
    }

    // Getters
    public int getReservationId() {
        return reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Display Reservation Details
    public void displayReservation() {

        System.out.println("\n=========================================");
        System.out.println("         RESERVATION DETAILS");
        System.out.println("=========================================");

        System.out.println("Reservation ID : " + reservationId);

        System.out.println("\nCustomer Details");
        customer.displayCustomer();

        System.out.println("\nRoom Details");
        room.displayRoom();

        System.out.println("Check In Date  : " + checkInDate);
        System.out.println("Check Out Date : " + checkOutDate);
        System.out.println("Status         : " + status);

        System.out.println("=========================================");
    }

}