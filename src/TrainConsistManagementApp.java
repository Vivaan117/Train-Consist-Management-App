import java.util.*;

public class UC19_BinarySearch {
    public static void main(String[] args) {

        // Step 1: Sorted array (IMPORTANT)
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

        // Step 3: Binary Search
        int left = 0;
        int right = bogieIDs.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            int result = key.compareTo(bogieIDs[mid]);

            if (result == 0) {
                found = true;
                break;
            } else if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Step 4: Output
        if (found) {
            System.out.println("Bogie Found!");
        } else {
            System.out.println("Bogie Not Found!");
        }
    }
}