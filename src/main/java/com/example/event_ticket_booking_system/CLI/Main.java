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

                    int numberOfVendors = 5;
                    Thread[] vendorThreads = new Thread[numberOfVendors];
                    for (int i = 0; i < numberOfVendors; i++) {
                        vendorThreads[i] = new Thread(new Vendor(ticketPool, configuration), "Vendor " + (i + 1));
                        vendorThreads[i].start();
                    }

                    // Start CustomerLogic threads
                    int numberOfCustomers = 5;
                    Thread[] customerThreads = new Thread[numberOfCustomers];
                    for (int i = 0; i < customerThreads.length; i++) {
                        customerThreads[i] = new Thread(new Customer(ticketPool, configuration), "Customer " + (i + 1));
                        customerThreads[i].start();
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