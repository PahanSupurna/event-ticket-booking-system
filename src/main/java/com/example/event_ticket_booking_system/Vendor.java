package com.example.event_ticket_booking_system;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final Configuration configuration;
    private final int vendorId;

    // Constructor
    public Vendor(TicketPool ticketPool, Configuration configuration, int vendorId) {
        this.ticketPool = ticketPool;
        this.configuration = configuration;
        this.vendorId = vendorId;
    }
}