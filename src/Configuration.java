public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int retrievalRate;
    private int ticketCapacity;

    public Configuration(){
        totalTickets = 120;
        ticketReleaseRate = 5;
        retrievalRate = 2;
        ticketCapacity = 100;
    }

    public int getTotalTickets(){
        return totalTickets;
    }

    public int getTicketReleaseRate(){
        return ticketReleaseRate;
    }

    public int getRetrievalRate(){
        return retrievalRate;
    }

    public int getTicketCapacity(){
        return ticketCapacity;
    }
}
