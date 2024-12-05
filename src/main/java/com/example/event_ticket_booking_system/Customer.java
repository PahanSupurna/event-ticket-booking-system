package com.example.event_ticket_booking_system;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int totalTickets;
    private final int retrievalRate;

    public Customer(TicketPool ticketPool, Configuration configuration) {
        this.ticketPool = ticketPool;
        this.totalTickets = configuration.getTotalTickets();
        this.retrievalRate = configuration.getRetrievalRate();
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (ticketPool) {
                    if (ticketPool.allTicketsSold()) {
                        break; // Stop if all tickets are sold
                    }
                    ticketPool.buyTicket();
                }
                Thread.sleep(retrievalRate * 1000L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Handle interrupt properly
        }
    }
}
