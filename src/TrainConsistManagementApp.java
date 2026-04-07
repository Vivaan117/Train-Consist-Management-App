import java.util.*;

public class UC20_SearchException {
    public static void main(String[] args) {

        String[] bogieIDs = {
                "BG101", "BG205", "BG309", "BG412", "BG550"
        };

        Scanner sc = new Scanner(System.in);

        try {
            // Input
            System.out.print("Enter Bogie ID to search: ");
            String key = sc.nextLine();

            // Validate input
            if (key == null || key.isEmpty()) {
                throw new IllegalArgumentException("Bogie ID cannot be empty");
            }

            // Linear Search
            boolean found = false;
            for (String id : bogieIDs) {
                if (id.equals(key)) {
                    found = true;
                    break;
                }
            }

            // Output
            if (found) {
                System.out.println("Bogie Found!");
            } else {
                System.out.println("Bogie Not Found!");
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected Error Occurred");

        } finally {
            System.out.println("Search operation completed.");
        }
    }
}