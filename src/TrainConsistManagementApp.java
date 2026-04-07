import java.util.*;

// Step 1: Custom Exception Class
class InvalidCapacityException extends Exception {
    InvalidCapacityException(String message) {
        super(message);
    }
}

// Step 2: Passenger Bogie Class
class PassengerBogie {
    String name;
    int capacity;

    PassengerBogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.name = name;
        this.capacity = capacity;
    }
}

// Step 3: Main Class
public class UC14_CustomException {
    public static void main(String[] args) {

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created: " + b1.name + " -> " + b1.capacity);

            PassengerBogie b2 = new PassengerBogie("AC Chair", -10); // Invalid
            System.out.println("Created: " + b2.name + " -> " + b2.capacity);

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}