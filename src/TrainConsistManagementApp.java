import java.util.*;

public class UC17_ArraySort {
    public static void main(String[] args) {

        // Step 1: Create array of bogie names
        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        // Step 2: Sort using Arrays.sort()
        Arrays.sort(bogieNames);

        // Step 3: Display sorted result
        System.out.println("Sorted Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));
    }
}