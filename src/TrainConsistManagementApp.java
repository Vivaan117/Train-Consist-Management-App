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

// Train Class (ArrayList + HashSet)
class Train {
    private String trainName;
    private ArrayList<Coach> passengerBogies;
    private HashSet<String> bogieIds; // To track uniqueness

    public Train(String trainName) {
        this.trainName = trainName;
        this.passengerBogies = new ArrayList<>();
        this.bogieIds = new HashSet<>();
    }

    // Add bogie with uniqueness check
    public void addPassengerBogie(Coach coach) {

        if (bogieIds.contains(coach.getCoachId())) {
            System.out.println("❌ Duplicate Bogie ID not allowed: " + coach.getCoachId());
            return;
        }

        passengerBogies.add(coach);
        bogieIds.add(coach.getCoachId());

        System.out.println("✅ Added: " + coach);
    }

    // Display consist
    public void displayConsist() {
        System.out.println("\n🚆 Train: " + trainName);
        System.out.println("Passenger Bogies:");

        if (passengerBogies.isEmpty()) {
            System.out.println("No bogies available.");
            return;
        }

        for (Coach coach : passengerBogies) {
            System.out.println("-> " + coach);
        }

        System.out.println("Total Bogies: " + passengerBogies.size());
    }
}

// Main Class
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Step 1: Initialize Train
        Train train = new Train("Express 303");

        // Step 2: Add Bogies (with duplicate test)
        train.addPassengerBogie(new Coach("P1", "Sleeper"));
        train.addPassengerBogie(new Coach("P2", "AC"));
        train.addPassengerBogie(new Coach("P1", "General")); // duplicate

        // Step 3: Display
        train.displayConsist();
    }
}