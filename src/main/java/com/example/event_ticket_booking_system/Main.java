package com.example.event_ticket_booking_system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String [] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the total number of tickets? ");
            int totalTickets = scanner.nextInt();

            System.out.println("Enter the Maximum number of tickets that can be stored? ");
            int ticketCapacity = scanner.nextInt();

            System.out.println("Enter the ticket retrieval rate? ");
            int retrievalRate = scanner.nextInt();

            System.out.println("Enter the ticket release rate? ");
            int releaseRate = scanner.nextInt();

            Configuration configuration = new Configuration(totalTickets, ticketCapacity, retrievalRate, releaseRate);

            if (configuration.validate()) {
                System.out.println("Inputs are valid.");
            } else {
                System.out.println("Inputs are invalid.");
            }

            // Initialized the TicketPool with the configuration object
            TicketPool ticketPool = new TicketPool(configuration);

        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter an integer.");
        } catch (Exception e) {
            System.out.println("Error occurred.");
        }


    }
}