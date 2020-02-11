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
}
