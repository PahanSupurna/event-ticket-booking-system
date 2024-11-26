import java.util.Scanner;

public class Main{
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the total number of tickets? ");
        int totalTickets = scanner.nextInt();

        System.out.println("Enter the Maximum number of tickets that can be stored? ");
        int ticketCapacity = scanner.nextInt();

        System.out.println("Enter the ticket retrieval rate? ");
        int retrievalRate = scanner.nextInt();

        System.out.println("Enter the ticket release rate? ");
        int releaseRate = scanner.nextInt();

        Configuration configuration = new Configuration(totalTickets, ticketCapacity, retrievalRate, releaseRate);

        if (configuration.validate()) {
            System.out.println("Inputs are valid.");
        } else {
            System.out.println("Inputs are invalid.");
        }
        
        scanner.close();
    }
}