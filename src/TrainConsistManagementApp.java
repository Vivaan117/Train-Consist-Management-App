import java.util.*;

public class UC18_LinearSearch {
    public static void main(String[] args) {

        // Step 1: Create array of bogie IDs
        String[] bogieIDs = {
                "BG101",
                "BG205",
                "BG309",
                "BG412",
                "BG550"
        };

        // Step 2: Input search key
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        // Step 3: Linear Search
        boolean found = false;

        for (String id : bogieIDs) {
            if (id.equals(key)) {
                found = true;
                break; // early termination
            }
        }

        // Step 4: Output result
        if (found) {
            System.out.println("Bogie Found!");
        } else {
            System.out.println("Bogie Not Found!");
        }
    }
}