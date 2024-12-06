package com.example.event_ticket_booking_system.CLI;

import com.example.event_ticket_booking_system.multiThreading.Configuration;
import com.example.event_ticket_booking_system.multiThreading.Customer;
import com.example.event_ticket_booking_system.multiThreading.TicketPool;
import com.example.event_ticket_booking_system.multiThreading.Vendor;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String [] args) {

        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("---WELCOME TO THE REAL TIME TICKET BOOKING SYSTEM---");
        System.out.println("To start the process please press ENTER key.");

        scanner.nextLine();

        while(!validInput) {
            try {
                System.out.println("---------------------------------------");
                System.out.print("Enter the total number of tickets : ");
                int totalTickets = scanner.nextInt();

                System.out.print("Enter the Maximum number of tickets that can be stored : ");
                int ticketCapacity = scanner.nextInt();

                System.out.print("Enter the ticket retrieval rate : ");
                int retrievalRate = scanner.nextInt();

                System.out.print("Enter the ticket release rate : ");
                int releaseRate = scanner.nextInt();

                System.out.println("---------------------------------------");

                Configuration configuration = new Configuration(totalTickets, retrievalRate, releaseRate, ticketCapacity);

                if (configuration.validate()) {
                    System.out.println("Inputs are valid.");
                    configuration.SaveInJson(); //Saves the information in a json file if the inputs are valid
                    validInput = true;

                    // Initialized the TicketPool with the configuration object
                    TicketPool ticketPool = new TicketPool(configuration);

                    Vendor vendor = new Vendor(ticketPool,configuration); //Create an instance of a vendor class
                    Customer customer = new Customer(ticketPool,configuration); //Creates an instance of a customer class

                    int noOfVendors = 5;
                    for (int i = 0; i < noOfVendors; i++) {
                        Thread thread1 = new Thread(vendor);
                        thread1.start();
                    }

                    int noOfCustomers = 5;
                    for (int i = 0; i < noOfCustomers; i++) {
                        Thread thread2 = new Thread(customer);
                        thread2.start();
                    }

                } else {
                    System.out.println(" Inputs are invalid.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
            } catch (Exception e) {
                System.out.println("Error occurred.");
            }
        }
    }
}