import java.util.LinkedList;

public class TicketPool {
    private final LinkedList<Integer> tickets;
    private final int ticketCapacity;

    public TicketPool(Configuration configuration) {
        this.tickets = new LinkedList<>();
        this.ticketCapacity = configuration.getTicketCapacity();
    }


}
