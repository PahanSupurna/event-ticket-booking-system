import java.util.LinkedList;
import java.util.Queue;

//Initialized the class
public class TicketPool {
    private final Queue<String> ticketQueue; //Queue to store tickets in the system
    private final Configuration configuration; // Object of Configuration class
    private int ticketNumber; //To get the ticket number for displaying.

    // Constructor
    public TicketPool (Configuration configuration){
        this.ticketQueue = new LinkedList<>();
        this.configuration = configuration;
        this.ticketNumber = 0;
    }

    // Method for adding the tickets to the system by Vendors.
    public synchronized void addTicket() throws InterruptedException{
        //checks if the number of tickets in the system is higher than the maximum capacity.
        while (ticketQueue.size() >= configuration.getTicketCapacity()){
            System.out.println("Ticket system is full, please wait till a customer buys a ticket.");
            wait(); //waits till a customer buys a ticket
        }

        ticketNumber ++;
        String ticket = "Ticket Number " + ticketNumber; //creates the ticket name to display
        ticketQueue.offer(ticket); //Adds the ticket to the queue
        System.out.println(ticket + "Successfully added to the system. Number of tickets in the system = "+ ticketQueue.size());
        notifyAll(); //Notifies the customers about the added tickets.
    }

    // Method for buying tickets in the system by customers.
    public synchronized String buyTicket() throws InterruptedException{
        // Checks if there is no available tickets in the system.
        while (ticketQueue.isEmpty()){
            System.out.println("There are no available tickets in the system. Please wait!");
            wait(); //waits till a vendor adds tickets to the system
        }

        String ticket = ticketQueue.poll(); //Removes the ticket from the system
        System.out.println(ticket + "is successfully purchased. Number of tickets remaining in the system = "+ ticketQueue.size());
        notifyAll(); //Notifies the vendors about the available ticket slot
        return ticket;
    }
}