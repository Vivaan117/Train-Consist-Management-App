import java.util.*;

// Coach Model
class Coach {
    private String coachId;
    private String type; // Engine, Sleeper, AC, General

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

// Train Class (LinkedList for dynamic structure)
class Train {
    private String trainName;
    private LinkedList<Coach> coaches;

    public Train(String trainName) {
        this.trainName = trainName;
        this.coaches = new LinkedList<>();
    }

    public void addCoach(Coach coach) {
        coaches.add(coach);
    }

    public void displayConsist() {
        System.out.println("🚆 Train: " + trainName);
        System.out.println("Consist Summary:");

        if (coaches.isEmpty()) {
            System.out.println("No coaches available.");
            return;
        }

        for (Coach coach : coaches) {
            System.out.println("-> " + coach);
        }

        System.out.println("Total Coaches: " + coaches.size());
    }
}

// Main Class (UPDATED NAME)
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Step 1: Initialize Train
        Train train = new Train("Express 101");

        // Step 2: Add Coaches
        train.addCoach(new Coach("C1", "Engine"));
        train.addCoach(new Coach("C2", "Sleeper"));
        train.addCoach(new Coach("C3", "AC"));
        train.addCoach(new Coach("C4", "General"));

        // Step 3: Display Consist
        train.displayConsist();
    }
}