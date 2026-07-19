package com.hotel.service;

import java.util.Scanner;

public class PaymentService {

    private Scanner scanner = new Scanner(System.in);

    public boolean makePayment(double amount) {

        System.out.println("\n=================================");
        System.out.println("       PAYMENT PORTAL");
        System.out.println("=================================");

        System.out.println("Amount to Pay : ₹" + amount);

        System.out.println("\nChoose Payment Method");

        System.out.println("1. UPI");
        System.out.println("2. Credit/Debit Card");
        System.out.println("3. Cash");

        System.out.print("Enter Choice : ");

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Processing UPI Payment...");
                break;

            case 2:
                System.out.println("Processing Card Payment...");
                break;

            case 3:
                System.out.println("Cash Payment Selected...");
                break;

            default:
                System.out.println("Invalid Payment Method.");
                return false;
        }

        System.out.println("Payment Successful.");
        return true;
    }

}
