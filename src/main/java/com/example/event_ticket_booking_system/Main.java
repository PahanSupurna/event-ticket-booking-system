package com.example.event_ticket_booking_system;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String [] args) {

        boolean validInput = false;
        Scanner scanner = new Scanner(System.in);

        while(!validInput) {
            try {
                System.out.println("Enter the total number of tickets? ");
                int totalTickets = scanner.nextInt();

                System.out.println("Enter the Maximum number of tickets that can be stored? ");
                int ticketCapacity = scanner.nextInt();

                System.out.println("Enter the ticket retrieval rate? ");
                int retrievalRate = scanner.nextInt();

                System.out.println("Enter the ticket release rate? ");
                int releaseRate = scanner.nextInt();

                Configuration configuration = new Configuration(totalTickets, retrievalRate, releaseRate, ticketCapacity);

                if (configuration.validate()) {
                    System.out.println("Inputs are valid.");
                    configuration.SaveInJson();
                    validInput = true;//Saves the information in a json file if the inputs are valid

                    // Initialized the TicketPool with the configuration object
                    TicketPool ticketPool = new TicketPool(configuration);

                    Vendor vendor = new Vendor(ticketPool,configuration); //Create an instance of a vendor class
                    Customer customer = new Customer(ticketPool,configuration); //Creates an instance of a customer class

                    Thread thread1 = new Thread(vendor);
                    thread1.start();

                    Thread thread2 = new Thread(customer);
                    thread2.start();

                    thread1.join();
                    thread2.join();
                } else {
                    System.out.println("Inputs are invalid.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer.");
            }
            catch (InterruptedException e){
                System.out.println("Thread interrupted during the process."+e.getMessage());
            }
            catch (Exception e) {
                System.out.println("Error occurred.");
            }
        }
    }
}