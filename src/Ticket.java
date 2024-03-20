import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //Getters
    public String getRow() {
        return this.row;
    }

    public int getSeat() {
        return this.seat;
    }

    public double getPrice() {
        return price;
    }

    public Person getPerson() {
        return person;
    }

    //Setters

    public void setRow(String row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void printTicketInfo (){
        System.out.println("Ticket Information:");
        System.out.println("Row: " + row);
        System.out.println("Seat: " + seat);
        System.out.println("Price: £" + price);
        person.printPersonInfo();
        System.out.println("\n");
    }

    public void save(){
        try {
            String filename = row + seat + ".txt";
            FileWriter myWriter = new FileWriter(filename);

            myWriter.write("Ticket Information:\n");
            myWriter.write("Row: " + row + "\n");
            myWriter.write("Seat: " + seat + "\n");
            myWriter.write("Price: £" + price + "\n");
            myWriter.write("Passenger Information:\n");
            myWriter.write("Name: " + person.getName() + "\n");
            myWriter.write("Surname: " + person.getSurname() + "\n");
            myWriter.write("Email: " + person.getEmail() + "\n");

            myWriter.close();

            System.out.println("File created: " + filename);
        } catch (IOException e ){
            System.out.println("An error occurred when saving file.");
        }
    }
}
