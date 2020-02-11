import java.util.ArrayList;
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


}
