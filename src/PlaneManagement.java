import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaneManagement {

    static int[] rowA = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] rowB = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] rowC = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] rowD = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static Ticket[] tickets = new Ticket[52];

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Plane Management Application!\n");

        boolean isNotExit = true;

        while (isNotExit) {
            try {
                System.out.print("""
                        *************************************************
                        *               MENU OPTIONS                    *
                        *************************************************
                                        
                              1) Buy a seat
                              2) Cancel a seat
                              3) Find first available seat
                              4) Show seating plan
                              5) Print ticket information and total sales
                              6) Search ticket
                              0) Quit
                                        
                        *************************************************
                                        
                        Please select an option:\s
                        """);

                int menuOption = input.nextInt();

                switch (menuOption) {
                    case 1:
                        buy_seat();
                        break;
                    case 2:
                        cancel_seat();
                        break;
                    case 3:
                        find_first_available();
                        break;
                    case 4:
                        show_seating_plan();
                        break;
                    case 5:
                        print_tickets_info();
                        break;
                    case 6:
                        search_ticket();
                        break;
                    case 0:
                        isNotExit = false;
                        break;
                    default:
                        System.out.println("Please Enter valid menu option");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Please Enter valid menu option");
                input.next();
            }
        }

    }

    /**
     * Allows users to purchase a seat by entering the row and seat number
     */
    public static void buy_seat() {

        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            try {

                System.out.print("Please Enter Row : ");
                String buyingRow = (input.next()).toUpperCase();

                System.out.print("Please Enter Seat No. : ");
                int buyingSeat = input.nextInt();

                if (validateRowAndSeat(buyingRow, buyingSeat)) {
                    if (buyingRow.equals("A") && rowA[buyingSeat - 1] == 0) {
                        rowA[buyingSeat - 1] = 1;
                        enterBuyerInfo(buyingRow, buyingSeat);
                        loop = false;
                    } else if (buyingRow.equals("B") && rowB[buyingSeat - 1] == 0) {
                        rowB[buyingSeat - 1] = 1;
                        enterBuyerInfo(buyingRow, buyingSeat);
                        loop = false;
                    } else if (buyingRow.equals("C") && rowC[buyingSeat - 1] == 0) {
                        rowC[buyingSeat - 1] = 1;
                        enterBuyerInfo(buyingRow, buyingSeat);
                        loop = false;
                    } else if (buyingRow.equals("D") && rowD[buyingSeat - 1] == 0) {
                        rowD[buyingSeat - 1] = 1;
                        enterBuyerInfo(buyingRow, buyingSeat);
                        loop = false;
                    } else if (buyingRow.equals("A") || buyingRow.equals("B") || buyingRow.equals("C") || buyingRow.equals("D")) {
                        System.out.println("This seat is occupied");
                        loop = false;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
                input.next();
            }
        }
    }

    /**
     * Allows the users to cancel a reservation by entering the row and seat number.
     */
    public static void cancel_seat() {
        Scanner input = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            try {

                System.out.print("Please Enter Row : ");
                String buyingRow = (input.next()).toUpperCase();

                System.out.print("Please Enter Seat No. : ");
                int buyingSeat = input.nextInt();

                if (validateRowAndSeat(buyingRow, buyingSeat)) {
                    if (buyingRow.equals("A") && rowA[buyingSeat - 1] == 1) {
                        rowA[buyingSeat - 1] = 0;
                        cancelTicket(buyingRow, buyingSeat);
                        loop = false;
                    } else if (buyingRow.equals("B") && rowB[buyingSeat - 1] == 1) {
                        rowB[buyingSeat - 1] = 0;
                        cancelTicket(buyingRow, buyingSeat);
                        loop = false;
                    } else if (buyingRow.equals("C") && rowC[buyingSeat - 1] == 1) {
                        rowC[buyingSeat - 1] = 0;
                        cancelTicket(buyingRow, buyingSeat);
                        loop = false;
                    } else if (buyingRow.equals("D") && rowD[buyingSeat - 1] == 1) {
                        rowD[buyingSeat - 1] = 0;
                        cancelTicket(buyingRow, buyingSeat);
                        loop = false;
                    } else if (buyingRow.equals("A") || buyingRow.equals("B") || buyingRow.equals("C") || buyingRow.equals("D")) {
                        System.out.println("This seat is not occupied");
                        loop = false;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    /**
     * Displays the location of the first unoccupied seat.
     */
    public static void find_first_available() {
        for (String row : new String[]{"A", "B", "C", "D"}) {
            for (int seat = 0; seat < getRowLength(row); seat++) {
                if (row.equals("A") && rowA[seat] == 0) {
                    System.out.println("First available seat: Row " + row + ", Seat " + (seat + 1));
                    return;
                } else if (row.equals("B") && rowB[seat] == 0) {
                    System.out.println("First available seat: Row " + row + ", Seat " + (seat + 1));
                    return;
                } else if (row.equals("C") && rowC[seat] == 0) {
                    System.out.println("First available seat: Row " + row + ", Seat " + (seat + 1));
                    return;
                } else if (row.equals("D") && rowD[seat] == 0) {
                    System.out.println("First available seat: Row " + row + ", Seat " + (seat + 1));
                    return;
                }

            }
        }
        System.out.println("No available seats found.");
    }

    /**
     * Print the seating plan, showing the booked seats.
     */
    public static void show_seating_plan() {

        for (String row : new String[]{"A", "B", "C", "D"}) {
            System.out.print(row + "  ");
            for (int seat = 0; seat < getRowLength(row); seat++) {
                if (row.equals("A") && rowA[seat] == 0) {
                    System.out.print("O ");
                } else if (row.equals("B") && rowB[seat] == 0) {
                    System.out.print("O ");
                } else if (row.equals("C") && rowC[seat] == 0) {
                    System.out.print("O ");
                } else if (row.equals("D") && rowD[seat] == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Print the information of all the booked tickets and the total price of ticket sold during the session
     */
    public static void print_tickets_info() {
        double total = 0;
        for (Ticket ticket : tickets) {
            if (ticket != null) {
                ticket.printTicketInfo();
                total += ticket.getPrice();
            }
        }
        System.out.println("Total Price of tickets sold during session : £" + total);
    }

    /**
     * Search for a specific Ticket entered by the user and Print if the Ticket is occupied or not
     */
    public static void search_ticket() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter Row : ");
        String row = (input.next()).toUpperCase();

        System.out.print("Please Enter Seat No. : ");
        int seat = input.nextInt();

        if (validateRowAndSeat(row, seat)) {
            for (Ticket ticket : tickets) {
                if (ticket != null && ticket.getRow().equals(row) && ticket.getSeat() == seat) {
                    System.out.println("Ticket Found!");
                    ticket.printTicketInfo();
                    return;
                }
            }
            System.out.println("This seat is available.");
        }
    }

    /**
     * Create a new person and ticket. Adds the created ticket to the Ticket array.
     * Loops with error handling until valid information is entered.
     *
     * @param row  row entered by user for the ticket in buy_seat().
     * @param seat seat entered by the user for the ticket in buy_seat().
     */
    public static void enterBuyerInfo(String row, int seat) {
        /*
          Title: Simple Email Validation in Java
          Author: Denys Velykozhon
          Date: January 31, 2020
          Availability: https://mailtrap.io/blog/java-email-validation/
          Reference for the email regex pattern
         */
        String emailRegexPattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        boolean loop = true;

        Scanner input = new Scanner(System.in);

        while (loop)
            try {
                System.out.print("Enter first name: ");
                String firstName = input.nextLine();
                System.out.print("Enter last name: ");
                String lastName = input.nextLine();
                System.out.print("Enter email address: ");
                String email = input.nextLine();

                if (patternMatches(email, emailRegexPattern)) {

                    Person newPerson = new Person(firstName, lastName, email);

                    if (seat > 0 && seat <= 5) {
                        Ticket newTicket = new Ticket(row, seat, 200.00, newPerson);
                        addTicket(newTicket);
                        loop = false;
                    } else if (seat > 5 && seat <= 9) {
                        Ticket newTicket = new Ticket(row, seat, 150.00, newPerson);
                        addTicket(newTicket);
                        loop = false;
                    } else if (seat > 9 && seat <= 14) {
                        Ticket newTicket = new Ticket(row, seat, 180.00, newPerson);
                        addTicket(newTicket);
                        loop = false;
                    }

                } else {
                    System.out.println("Invalid Email address. Please enter your details again");
                }
            } catch (InputMismatchException e) {
                System.out.print("");
            }
    }

    /**
     * Cancel a selected ticket. Removes the selected ticket from the Ticket array.
     *
     * @param row  row entered by user for the ticket in cancel_seat().
     * @param seat seat entered by the user for the ticket in cancel_seat().
     */
    public static void cancelTicket(String row, int seat) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null && tickets[i].getRow().equals(row) && tickets[i].getSeat() == seat) {
                tickets[i] = null;
                System.out.println("Ticket Cancelled Successfully");
                return;
            }
        }
        System.out.println("Ticket Not Found");
    }

    /**
     * Validate Rows and seats to check if the entered Row and Seat is in the correct range
     *
     * @param row  row entered by the buyer
     * @param seat seat number entered by the buyer
     * @return returns a boolean if it is valid will return true and will return false if invalid
     */
    private static boolean validateRowAndSeat(String row, int seat) {

        String[] validRows = {"A", "B", "C", "D"};

        boolean validRowAndSeat = false;

        boolean inValidRows = inArray(validRows, row);
        if (inValidRows) {
            if (row.equals("A") || row.equals("D")) {
                if (seat < 15 && seat > 0) {
                    validRowAndSeat = true;
                } else {
                    System.out.println("Incorrect seat number. Please enter again");
                }
            } else if (row.equals("B") || row.equals("C")) {
                if (seat < 13 && seat > 0) {
                    validRowAndSeat = true;
                } else {
                    System.out.println("Incorrect seat number. Please enter again");
                }
            }
        } else {
            System.out.println("Incorrect row. Please enter again");
        }
        return validRowAndSeat;
    }

    /**
     * Get a String array and a string and check if the value is present in the array
     *
     * @param arr           String Array to check if value is in it
     * @param checkingValue string value to check
     * @return boolean if the checkingValue is in the array its will return true, if not false.
     */
    private static boolean inArray(String[] arr, String checkingValue) {
        boolean found = false;
        for (String value : arr) {
            if (value.equals(checkingValue)) {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Get the number of seats in an entered row
     *
     * @param row the row to get the seats from
     * @return the number of seats in the entered row
     */
    private static int getRowLength(String row) {
        if (row.equals("A") || row.equals("D")) {
            return 14;
        } else {
            return 12;
        }
    }

    /**
     * Validates email address to entered regex pattern
     *
     * @param emailAddress entered email address
     * @param regexPattern entered regex pattern to validate email
     * @return true if email is valid, false if it isn't valid
     */
    public static boolean patternMatches(String emailAddress, String regexPattern) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches();
    }

    /**
     * Add a ticket and the ticket information in a file
     * @param newTicket The ticket needed to be added to the tickets array
     */
    public static void addTicket(Ticket newTicket) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                tickets[i] = newTicket;
                tickets[i].save();
                System.out.println("Booking Successful!");
                break;
            }
            if (i == tickets.length - 1) {
                System.out.println("Cannot book anymore seats");
            }
        }
    }
}




