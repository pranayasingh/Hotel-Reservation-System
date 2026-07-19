package com.hotel.util;

import com.hotel.model.Reservation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "bookings.txt";

    // Save all reservations to file
    public void saveReservations(ArrayList<Reservation> reservations) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Reservation reservation : reservations) {

                writer.write(
                        reservation.getReservationId() + "," +
                                reservation.getCustomer().getCustomerId() + "," +
                                reservation.getCustomer().getName() + "," +
                                reservation.getCustomer().getPhoneNumber() + "," +
                                reservation.getRoom().getRoomNumber() + "," +
                                reservation.getRoom().getCategory() + "," +
                                reservation.getRoom().getPrice() + "," +
                                reservation.getCheckInDate() + "," +
                                reservation.getCheckOutDate() + "," +
                                reservation.getStatus()
                );

                writer.newLine();
            }

            System.out.println("Reservations saved successfully.");

        } catch (IOException e) {

            System.out.println("Error while saving reservations.");

        }

    }

}
