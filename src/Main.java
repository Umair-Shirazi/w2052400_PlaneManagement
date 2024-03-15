import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static int[] rowA = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] rowB = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] rowC = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static int[] rowD = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        /*Person person = new Person ("Umair", "Shirazi", "umairshirazi2005@gmail.com");
        Ticket ticket = new Ticket(1,1,50.35, person);
        ticket.printTicketInfo();*/

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Plane Management Application!");

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
                    case 6:
                    case 7:
                    case 8:
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

//        System.out.println("Loop Exited");
    }

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
                        loop = false;
                    } else if (buyingRow.equals("B") && rowB[buyingSeat - 1] == 0) {
                        rowB[buyingSeat - 1] = 1;
                        loop = false;
                    } else if (buyingRow.equals("C") && rowC[buyingSeat - 1] == 0) {
                        rowC[buyingSeat - 1] = 1;
                        loop = false;
                    } else if (buyingRow.equals("D") && rowD[buyingSeat - 1] == 0) {
                        rowD[buyingSeat - 1] = 1;
                        loop = false;
                    } else if (buyingRow.equals("A") || buyingRow.equals("B") || buyingRow.equals("C") || buyingRow.equals("D")) {
                        System.out.println("This seat is occupied");
                        loop = false;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

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
                        loop = false;
                    } else if (buyingRow.equals("B") && rowB[buyingSeat - 1] == 1) {
                        rowB[buyingSeat - 1] = 0;
                        loop = false;
                    } else if (buyingRow.equals("C") && rowC[buyingSeat - 1] == 1) {
                        rowC[buyingSeat - 1] = 0;
                        loop = false;
                    } else if (buyingRow.equals("D") && rowD[buyingSeat - 1] == 1) {
                        rowD[buyingSeat - 1] = 0;
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

    public static void show_seating_plan(){

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

    private static int getRowLength(String row) {
        if (row.equals("A") || row.equals("D")) {
            return 14;
        } else {
            return 12;
        }
    }

}




