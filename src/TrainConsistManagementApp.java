import java.util.*;

// Coach Model
class Coach {
    private String coachId;
    private String type;
    private int capacity;

    public Coach(String coachId, String type, int capacity) {
        this.coachId = coachId;
        this.type = type;
        this.capacity = capacity;
    }

    public String getCoachId() {
        return coachId;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return coachId + " (" + type + ", Capacity: " + capacity + ")";
    }
}

// Train Class (LinkedHashSet + HashMap)
class Train {
    private String trainName;
    private LinkedHashSet<String> bogieOrder;
    private Map<String, Coach> coachMap;
    private HashMap<String, Integer> capacityMap; // NEW

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogieOrder = new LinkedHashSet<>();
        this.coachMap = new HashMap<>();
        this.capacityMap = new HashMap<>();
    }

    // Add bogie
    public void addPassengerBogie(Coach coach) {

        if (!bogieOrder.add(coach.getCoachId())) {
            System.out.println("❌ Duplicate Bogie ID: " + coach.getCoachId());
            return;
        }

        coachMap.put(coach.getCoachId(), coach);
        capacityMap.put(coach.getCoachId(), coach.getCapacity());

        System.out.println("✅ Added: " + coach);
    }

    // Display consist
    public void displayConsist() {
        System.out.println("\n🚆 Train: " + trainName);

        for (String id : bogieOrder) {
            System.out.println("-> " + coachMap.get(id));
        }

        System.out.println("Total Bogies: " + bogieOrder.size());
    }

    // Display capacity mapping
    public void displayCapacityMap() {
        System.out.println("\n📊 Bogie Capacity Mapping:");

        for (String id : capacityMap.keySet()) {
            System.out.println(id + " -> " + capacityMap.get(id));
        }
    }

    // Get capacity of specific bogie
    public void getCapacity(String bogieId) {
        if (!capacityMap.containsKey(bogieId)) {
            System.out.println("❌ Bogie not found: " + bogieId);
            return;
        }

        System.out.println("Capacity of " + bogieId + " = " + capacityMap.get(bogieId));
    }
}

// Main Class
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Step 1: Initialize Train
        Train train = new Train("Express 606");

        // Step 2: Add Bogies
        train.addPassengerBogie(new Coach("P1", "Sleeper", 72));
        train.addPassengerBogie(new Coach("P2", "AC", 48));
        train.addPassengerBogie(new Coach("P3", "General", 90));

        // Step 3: Display
        train.displayConsist();

        // Step 4: Show mapping
        train.displayCapacityMap();

        // Step 5: Fetch capacity
        train.getCapacity("P2");
        train.getCapacity("P5"); // invalid
    }
}