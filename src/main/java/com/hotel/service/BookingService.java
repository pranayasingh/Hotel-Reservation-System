package com.hotel.service;

import com.hotel.model.Customer;
import com.hotel.model.Reservation;
import com.hotel.model.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingService {

    private ArrayList<Reservation> reservations;
    private HotelService hotelService;
    private PaymentService paymentService;
    private Scanner scanner;

    private int reservationCounter = 1001;

    public BookingService(HotelService hotelService,
                          PaymentService paymentService) {

        this.hotelService = hotelService;
        this.paymentService = paymentService;

        reservations = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Book Room
    public void bookRoom() {

        System.out.println("\n========= BOOK ROOM =========");

        System.out.print("Enter Customer ID : ");
        int customerId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Customer Name : ");
        String name = scanner.nextLine();

        System.out.print("Enter Phone Number : ");
        String phone = scanner.nextLine();

        System.out.print("Enter Room Number : ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();

        Room room = hotelService.findRoom(roomNumber);

        if (room == null) {
            System.out.println("Room does not exist.");
            return;
        }

        if (!room.isAvailable()) {
            System.out.println("Room is already booked.");
            return;
        }

        System.out.print("Enter Check-In Date : ");
        String checkIn = scanner.nextLine();

        System.out.print("Enter Check-Out Date : ");
        String checkOut = scanner.nextLine();

        boolean paymentDone = paymentService.makePayment(room.getPrice());

        if (!paymentDone) {
            System.out.println("Booking Cancelled.");
            return;
        }

        Customer customer =
                new Customer(customerId, name, phone);

        Reservation reservation =
                new Reservation(
                        reservationCounter++,
                        customer,
                        room,
                        checkIn,
                        checkOut,
                        "Booked"
                );

        reservations.add(reservation);

        room.setAvailable(false);

        System.out.println("\nRoom Booked Successfully.");
        System.out.println("Reservation ID : "
                + reservation.getReservationId());

    }

    // View Reservations
    public void viewReservations() {

        if (reservations.isEmpty()) {

            System.out.println("No Reservations Found.");
            return;

        }

        for (Reservation reservation : reservations) {

            reservation.displayReservation();

        }

    }

    // Cancel Reservation
    public void cancelReservation() {

        System.out.print("Enter Reservation ID : ");

        int id = scanner.nextInt();

        for (Reservation reservation : reservations) {

            if (reservation.getReservationId() == id) {

                reservation.setStatus("Cancelled");

                reservation.getRoom().setAvailable(true);

                System.out.println("Reservation Cancelled.");

                return;
            }

        }

        System.out.println("Reservation Not Found.");

    }

    // Search Reservation
    public void searchReservation() {

        System.out.print("Enter Reservation ID : ");

        int id = scanner.nextInt();

        for (Reservation reservation : reservations) {

            if (reservation.getReservationId() == id) {

                reservation.displayReservation();

                return;
            }

        }

        System.out.println("Reservation Not Found.");

    }

    // Getter
    public ArrayList<Reservation> getReservations() {

        return reservations;

    }

}
