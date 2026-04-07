import java.util.*;

// Step 1: Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    CargoSafetyException(String message) {
        super(message);
    }
}

// Step 2: Goods Bogie Class
class GoodsBogie {
    String type;
    String cargo;

    GoodsBogie(String type) {
        this.type = type;
    }

    void assignCargo(String cargo) {
        try {
            // Rule: Rectangular cannot carry Petroleum
            if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Unsafe: Rectangular bogie cannot carry Petroleum");
            }

            this.cargo = cargo;
            System.out.println("Cargo assigned: " + cargo + " to " + type);

        } catch (CargoSafetyException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Assignment process completed.\n");
        }
    }
}

// Step 3: Main Class
public class UC15_CargoHandling {
    public static void main(String[] args) {

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        // Safe case
        b1.assignCargo("Petroleum");

        // Unsafe case
        b2.assignCargo("Petroleum");

        // Program continues
        b2.assignCargo("Coal");
    }
}