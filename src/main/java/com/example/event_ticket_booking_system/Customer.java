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
            synchronized (ticketPool) {
                while (ticketPool.getSoldTickets() < totalTickets) {
                    // Attempt to buy a ticket
                    ticketPool.buyTicket();
                    // Notify any waiting thread that a ticket is available (optional)
                    ticketPool.notifyAll();

                    // Wait for the next cycle based on retrievalRate
                    ticketPool.wait(retrievalRate * 1000L);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();  // Handle interrupt properly
        }
    }
}
