import java.util.ArrayList;
import java.util.HashSet;

public class WorkoutGenerator {

    public ArrayList<Workout> generateWorkout(User user, HashSet<Exercise> exercises){
        ArrayList<Workout> workouts = new ArrayList<>();
        int numExercises = user.getTime().intValue()/10;
        for(int i=0; i<user.getDays(); i++){

        }
        return workouts;
    }

    private String getSetsAndReps(User user, Exercise e){
        String experience = user.getExperience();
        if(e.getLocationType().equals("GYM")){
            if(e.getType().equals("POWER")){
                switch (experience) {
                    case "BEGINNER":
                        return "3x8";
                    case "NOVICE":
                        return "3x5";
                    case "INTERMEDIATE":
                        return "4x5";
                    case "ADVANCED":
                        return "5x5";
                    case "ELITE":
                        return "5x5";
                }
            }
            else if(e.getType().equals("HYPERTROPHY")){
                switch (experience) {
                    case "BEGINNER":
                        return "3x10";
                    case "NOVICE":
                        return "3x12";
                    case "INTERMEDIATE":
                        return "4x12";
                    case "ADVANCED":
                        return "4x12";
                    case "ELITE":
                        return "4x12";
                }
            }
            else if(e.getType().equals("ENDURANCE")) {
                switch (experience) {
                    case "BEGINNER":
                        return "3x15";
                    case "NOVICE":
                        return "4x15";
                    case "INTERMEDIATE":
                        return "4x20";
                    case "ADVANCED":
                        return "5x18";
                    case "ELITE":
                        return "5x20";
                }
            }
        }
        else if(e.getLocationType().equals("BODYWEIGHT")){
            if(e.getType().equals("POWER")){
                switch (experience) {
                    case "BEGINNER":
                        return "3x8";
                    case "NOVICE":
                        return "3x5";
                    case "INTERMEDIATE":
                        return "4x5";
                    case "ADVANCED":
                        return "5x5";
                    case "ELITE":
                        return "5x5";
                }
            }
            else if(e.getType().equals("HYPERTROPHY")){
                switch (experience) {
                    case "BEGINNER":
                        return "3x10";
                    case "NOVICE":
                        return "3x12";
                    case "INTERMEDIATE":
                        return "4x12";
                    case "ADVANCED":
                        return "4x12";
                    case "ELITE":
                        return "4x12";
                }
            }
            else if(e.getType().equals("ENDURANCE")) {
                switch (experience) {
                    case "BEGINNER":
                        return "3x15";
                    case "NOVICE":
                        return "4x15";
                    case "INTERMEDIATE":
                        return "4x20";
                    case "ADVANCED":
                        return "5x18";
                    case "ELITE":
                        return "5x20";
                }
            }
        }
        return "3x8";
    }
}
