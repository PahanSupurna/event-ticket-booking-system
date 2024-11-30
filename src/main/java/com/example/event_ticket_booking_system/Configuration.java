package com.example.event_ticket_booking_system;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Configuration {
    //Initializing the attributes
    private int totalTickets;
    private int releaseRate;
    private int retrievalRate;
    private int ticketCapacity;

    //Constructor
    public Configuration(int totalTickets, int retrievalRate, int releaseRate, int ticketCapacity) {
        this.totalTickets = totalTickets;
        this.releaseRate = releaseRate;
        this.retrievalRate = retrievalRate;
        this.ticketCapacity = ticketCapacity;
    }

    //Getters of the attributes
    public int getTotalTickets() {
        return totalTickets;
    }

    public int getReleaseRate() {
        return releaseRate;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }

    public int getTicketCapacity() {
        return ticketCapacity;
    }

    //Setters of the attributes
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void setReleaseRate(int releaseRate) {
        this.releaseRate = releaseRate;
    }

    public void setRetrievalRate(int retrievalRate) {
        this.retrievalRate = retrievalRate;
    }

    public void setTicketCapacity(int ticketCapacity) {
        this.ticketCapacity = ticketCapacity;
    }

    //Method for validate the user inputs
    public boolean validate() {
        //check if the number is a positive or not.
        if (totalTickets < 0 || ticketCapacity < 0 || retrievalRate < 0 || releaseRate < 0) {
            System.out.println("Invalid input! Please enter a positive number.");
            return false;
        }
        //ticket capacity should be higher than total ticket count.
        if (totalTickets > ticketCapacity) {
            System.out.println("Invalid input! Please enter a number smaller than the total ticket count.");
            return false;
        }
        //checks if the ticket release rate is lower than the ticket retrieval rate.
        if (retrievalRate < releaseRate) {
            System.out.println("Invalid input! Ticket release rate should be higher than ticket retrieval rate.");
            return false;
        }
        return true;
    }
}
