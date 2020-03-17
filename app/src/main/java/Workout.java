import java.util.ArrayList;
import java.util.Collections;
public class Workout {

    private ArrayList<Exercise> exercises;
    //private int totalTime=0;


    public Workout()
    {
        this.exercises = new ArrayList<>();
    }

    public void addExcercise(Exercise e){
        exercises.add(e);
    }

    public String toString(){
        StringBuilder allExercises = new StringBuilder();
        allExercises.append("Workout:\n");

        for(Exercise ex : exercises)
        {
            allExercises.append(ex.toString() + "\n");
        }

        allExercises.append("\n");
        return(allExercises.toString());
    }
    public void shuffleList(){
        Collections.shuffle(exercises);
    }

}
