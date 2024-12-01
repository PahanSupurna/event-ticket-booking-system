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
        for (int i = 0; i < totalTickets; i++) {
            try {
                //Adds the ticket to the pool
                ticketPool.addTicket();
                //Waiting time before releasing the next ticket
                Thread.sleep(releaseRate * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}