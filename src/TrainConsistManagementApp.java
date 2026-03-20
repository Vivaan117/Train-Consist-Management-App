import java.util.*;

// Coach Model
class Coach {
    private String coachId;
    private String type;

    public Coach(String coachId, String type) {
        this.coachId = coachId;
        this.type = type;
    }

    public String getCoachId() {
        return coachId;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return coachId + " (" + type + ")";
    }
}

// Train Class (LinkedHashSet)
class Train {
    private String trainName;
    private LinkedHashSet<String> bogieOrder; // maintains insertion order
    private Map<String, Coach> coachMap; // store coach details

    public Train(String trainName) {
        this.trainName = trainName;
        this.bogieOrder = new LinkedHashSet<>();
        this.coachMap = new HashMap<>();
    }

    // Add bogie
    public void addPassengerBogie(Coach coach) {

        if (!bogieOrder.add(coach.getCoachId())) {
            System.out.println("❌ Duplicate Bogie ID not allowed: " + coach.getCoachId());
            return;
        }

        coachMap.put(coach.getCoachId(), coach);
        System.out.println("✅ Added: " + coach);
    }

    // Display consist (in insertion order)
    public void displayConsist() {
        System.out.println("\n🚆 Train: " + trainName);
        System.out.println("Bogie Sequence (Insertion Order):");

        if (bogieOrder.isEmpty()) {
            System.out.println("No bogies available.");
            return;
        }

        for (String id : bogieOrder) {
            System.out.println("-> " + coachMap.get(id));
        }

        System.out.println("Total Bogies: " + bogieOrder.size());
    }
}

// Main Class
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Step 1: Initialize Train
        Train train = new Train("Express 505");

        // Step 2: Add Bogies
        train.addPassengerBogie(new Coach("P3", "General"));
        train.addPassengerBogie(new Coach("P1", "Sleeper"));
        train.addPassengerBogie(new Coach("P2", "AC"));
        train.addPassengerBogie(new Coach("P1", "Duplicate")); // duplicate

        // Step 3: Display consist (in insertion order)
        train.displayConsist();
    }
}