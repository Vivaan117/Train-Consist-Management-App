import java.util.*;
import java.util.stream.*;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
}

public class UC9_GroupBogies {
    public static void main(String[] args) {

        // Step 1: Create list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("First Class", 24));

        // Step 2: Group using Stream
        Map<String, List<Bogie>> grouped =
                bogies.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        // Step 3: Display grouped data
        System.out.println("Grouped Bogies:");

        for (String key : grouped.keySet()) {
            System.out.println("\n" + key + ":");
            for (Bogie b : grouped.get(key)) {
                System.out.println("Capacity -> " + b.capacity);
            }
        }
    }
}