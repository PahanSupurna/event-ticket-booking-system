--Real-Time Ticket Booking System--

Introduction
  - The Real-Time Ticket Booking System is a multi-threaded application designed to simulate a ticket booking process. The system involves vendors adding tickets
    to a pool and customers purchasing tickets from the pool. The application ensures that the number of tickets in the system does not exceed a specified capacity
    and that all tickets are sold in a controlled manner.

Setup Instructions
  Prerequisites
    -Java: Ensure you have Java Development Kit (JDK) 11 or higher installed.
    -IDE: An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse is recommended for development and debugging.
    -Build Tool: Maven or Gradle can be used to manage dependencies and build the project.


--How to Configure and Start the System--

Start the Application:
  -Run the Main class from the com.example.event_ticket_booking_system.CLI package.

Initial Prompt:
  -The application will display a welcome message and prompt you to press the ENTER key to start the configuration process.

Configuration:
  -Total Number of Tickets: Enter the total number of tickets available for sale.
  -Maximum Number of Tickets in the System: Enter the maximum number of tickets that can be stored in the system at any given time.
  -Ticket Retrieval Rate: Enter the rate at which customers retrieve tickets (in seconds).
  -Ticket Release Rate: Enter the rate at which vendors release tickets (in seconds).

Validation:
  -The system will validate the inputs and save the configuration in a JSON file if the inputs are valid. If the inputs are invalid, the system will prompt you to re-enter the values.

--Explanation of UI Controls--

Welcome Message:
  -The application starts with a welcome message and prompts you to press the ENTER key to proceed.

Input Prompts:
  The application will ask for the following inputs:
    -Total Number of Tickets: The total number of tickets available for sale.
    -Maximum Number of Tickets in the System: The maximum number of tickets that can be stored in the system at any given time.
    -Ticket Retrieval Rate: The rate at which customers retrieve tickets (in seconds).
    -Ticket Release Rate: The rate at which vendors release tickets (in seconds).
  
  Validation Messages:
    -The system will display validation messages if the inputs are invalid and prompt you to re-enter the values.
    
  System Operation:
    -Once the configuration is valid, the system will start the ticket booking process. Vendors will add tickets to the system, and customers will purchase tickets.
     The system will display messages indicating the addition and purchase of tickets.

  Completion:
    -The system will stop once all tickets have been sold. Vendors and customers will stop their operations, and the application will terminate.
