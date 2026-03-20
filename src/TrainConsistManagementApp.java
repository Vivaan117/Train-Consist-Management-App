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

// Train Class (ArrayList for passenger bogies)
class Train {
    private String trainName;
    private ArrayList<Coach> passengerBogies;

    public Train(String trainName) {
        this.trainName = trainName;
        this.passengerBogies = new ArrayList<>();
    }

    // Add passenger bogie
    public void addPassengerBogie(Coach coach) {
        passengerBogies.add(coach);
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
        Train train = new Train("Express 202");

        // Step 2: Add Passenger Bogies
        train.addPassengerBogie(new Coach("P1", "Sleeper"));
        train.addPassengerBogie(new Coach("P2", "AC"));
        train.addPassengerBogie(new Coach("P3", "General"));

        // Step 3: Display Consist
        train.displayConsist();
    }
}