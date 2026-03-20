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

// Train Class (ArrayList + TreeSet)
class Train {
    private String trainName;
    private ArrayList<Coach> passengerBogies;
    private TreeSet<String> sortedBogieIds; // Sorted + Unique

    public Train(String trainName) {
        this.trainName = trainName;
        this.passengerBogies = new ArrayList<>();
        this.sortedBogieIds = new TreeSet<>();
    }

    // Add bogie with sorting + uniqueness
    public void addPassengerBogie(Coach coach) {

        // TreeSet handles uniqueness automatically
        if (!sortedBogieIds.add(coach.getCoachId())) {
            System.out.println("❌ Duplicate Bogie ID not allowed: " + coach.getCoachId());
            return;
        }

        passengerBogies.add(coach);
        System.out.println("✅ Added: " + coach);
    }

    // Display train consist
    public void displayConsist() {
        System.out.println("\n🚆 Train: " + trainName);
        System.out.println("Passenger Bogies:");

        for (Coach coach : passengerBogies) {
            System.out.println("-> " + coach);
        }

        System.out.println("Total Bogies: " + passengerBogies.size());
    }

    // Display sorted bogie IDs
    public void displaySortedBogieIds() {
        System.out.println("\n📌 Sorted Bogie IDs:");
        for (String id : sortedBogieIds) {
            System.out.println(id);
        }
    }
}

// Main Class
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Step 1: Initialize Train
        Train train = new Train("Express 404");

        // Step 2: Add Bogies (unsorted input)
        train.addPassengerBogie(new Coach("P3", "General"));
        train.addPassengerBogie(new Coach("P1", "Sleeper"));
        train.addPassengerBogie(new Coach("P2", "AC"));
        train.addPassengerBogie(new Coach("P1", "Duplicate")); // duplicate

        // Step 3: Display original consist
        train.displayConsist();

        // Step 4: Display sorted IDs
        train.displaySortedBogieIds();
    }
}