package com.hotel;

import com.hotel.service.BookingService;
import com.hotel.service.HotelService;
import com.hotel.service.PaymentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        HotelService hotelService = new HotelService();
        PaymentService paymentService = new PaymentService();
        BookingService bookingService =
                new BookingService(hotelService, paymentService);

        int choice;

        do {

            System.out.println("\n========================================");
            System.out.println("     HOTEL RESERVATION SYSTEM");
            System.out.println("========================================");
            System.out.println("1. Display All Rooms");
            System.out.println("2. Display Available Rooms");
            System.out.println("3. Search Room By Category");
            System.out.println("4. Book Room");
            System.out.println("5. View Reservations");
            System.out.println("6. Search Reservation");
            System.out.println("7. Cancel Reservation");
            System.out.println("8. Exit");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    hotelService.displayAllRooms();
                    break;

                case 2:
                    hotelService.displayAvailableRooms();
                    break;

                case 3:
                    System.out.print("Enter Category (Standard/Deluxe/Suite): ");
                    String category = scanner.nextLine();
                    hotelService.searchRoomByCategory(category);
                    break;

                case 4:
                    bookingService.bookRoom();
                    break;

                case 5:
                    bookingService.viewReservations();
                    break;

                case 6:
                    bookingService.searchReservation();
                    break;

                case 7:
                    bookingService.cancelReservation();
                    break;

                case 8:
                    System.out.println("Thank You for using Hotel Reservation System.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 8);

        scanner.close();
    }
}