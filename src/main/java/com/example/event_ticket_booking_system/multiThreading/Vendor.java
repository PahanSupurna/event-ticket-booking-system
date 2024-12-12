package com.example.event_ticket_booking_system.multiThreading;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int releaseRate;

    // Constructor
    public Vendor(TicketPool ticketPool, Configuration configuration) {
        this.ticketPool = ticketPool;
        this.releaseRate = configuration.getReleaseRate();
    }

    @Override
    public void run() {
        try {
            while (true) {
                synchronized (ticketPool) {
                    if (ticketPool.allTicketsSold()) {
                        System.out.println(Thread.currentThread().getName() + " stopped.");
                        break; // Stop if total tickets have been sold
                    }
                    ticketPool.addTicket();
                }
                Thread.sleep(releaseRate*1000L);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}