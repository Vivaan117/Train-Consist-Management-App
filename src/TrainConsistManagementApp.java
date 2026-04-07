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

public class UC8_FilterBogies {
    public static void main(String[] args) {

        // Step 1: Reuse list from UC7
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        // Step 2: Apply Stream Filtering (capacity > 60)
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Step 3: Display result
        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie b : filtered) {
            System.out.println(b.name + " -> " + b.capacity);
        }
    }
}