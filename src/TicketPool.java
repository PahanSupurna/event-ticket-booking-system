public class TicketPool {
    private int ticketCapacity;
    private int totalTickets;
    private int[] ticketStoreArray;

    public TicketPool(Configuration configuration){
        this.ticketCapacity = configuration.getTicketCapacity();
        this.ticketStoreArray = new int[configuration.getTotalTickets()];
    }

    public synchronized void addTicket(int ticket){
        if(ticketStoreArray.length < ticketCapacity){

        }
    }
}
