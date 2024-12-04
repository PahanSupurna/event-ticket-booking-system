package com.example.event_ticket_booking_system;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int totalTickets;
    private final int releaseRate;

    // Constructor
    public Vendor(TicketPool ticketPool, Configuration configuration) {
        this.ticketPool = ticketPool;
        this.releaseRate = configuration.getReleaseRate();
        this.totalTickets = configuration.getTotalTickets();
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (ticketPool) {
                    if (ticketPool.getSoldTickets() >= totalTickets) {
                        break; // Stop if total tickets have been sold
                    }

                    if (ticketPool.getSoldTickets() < totalTickets) {
                        ticketPool.addTicket();
                        System.out.println("Ticket Number " + ticketPool.getTicketNumber() + " Successfully added to the system.");
                    } else {
                        System.out.println("Ticket system is full, please wait till a customer buys a ticket.");
                        ticketPool.wait(); // Wait until a customer buys a ticket and frees space
                    }
                }
                Thread.sleep(releaseRate*1000L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}