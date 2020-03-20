import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Workout
{
    private String title;
    private List<Exercise> exercises;
    public Workout()
    {
        exercises = new ArrayList<Exercise>();
    }

    public Workout(ArrayList<Exercise> exercises, String title){
        this.exercises = exercises;
        this.title = title;
    }


    public void addExercise(Exercise e)
    {
        exercises.add(e);
    }

    public void setTitle(String title){
        this.title = title;
    }

    public List getWorkout()
    {
        return exercises;
    }

    public String toString(){
        String result = title + "\n";
        for(Exercise e: exercises)
            result += e.toString();

        result += "\n";
        return result;
    }



}
