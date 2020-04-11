package com.example.mypersonaltrainer.ObjectClasses;

import android.content.Context;
import android.os.CpuUsageInfo;

import java.util.ArrayList;

public class WorkoutGenerator { //TODO make WorkoutGenerator class into singleton
    private Context context;
    private ExerciseBank eBank;
    private ArrayList<Workout> routine;
    private ArrayList<Exercise> exercises;
    public WorkoutGenerator(Context context){
        this.context = context;
        eBank = new ExerciseBank(context);
        routine = new ArrayList<Workout>();
        exercises = new ArrayList<Exercise>();
    }

    public static WorkoutGenerator getWorkoutGenerator(){
        return null;
    }

    public ArrayList<Workout> getRoutine(Integer days, String trainingLocation, String targetArea){
        switch(days){
            case 2: return get2DayRoutine(trainingLocation, targetArea);
            case 3: return get3DayRoutine(trainingLocation, targetArea);
            //case 4: return get4DayRoutine(trainingLocation, targetArea);
            case 5: return get5DayRoutine(trainingLocation, targetArea);
            case 6: return get6DayRoutine(trainingLocation, targetArea);
            default: return get4DayRoutine(trainingLocation, targetArea);
        }
    }

    public ArrayList<Workout> get2DayRoutine(String trainingLocation, String targetArea){
        exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CALVES, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 1"));
        exercises.clear();
        exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
        exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CALVES, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 2"));
        return routine;
    }

    public ArrayList<Workout> get3DayRoutine(String trainingLocation, String targetArea){
        exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
        exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 1"));
        exercises.clear();
        exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CALVES, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
        exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.TRICEPS, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 2"));
        exercises.clear();
        exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CALVES, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
        exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.BICEPS, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 3"));
        return routine;
    }

    public ArrayList<Workout> get4DayRoutine(String trainingLocation, String targetArea){
        String title;
        for(int i=1; i<4; i=i+2){
            exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
            if(!(targetArea.equals(Constants.QUADS) || targetArea.equals(Constants.HAM) || targetArea.equals(Constants.CALVES) || targetArea.equals(Constants.BUTT) || targetArea.equals(Constants.NONE)))
                exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.BICEPS, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.TRICEPS, trainingLocation);
            title = "Day " + i + ": Upper";
            routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), title));
            exercises.clear();
            exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
            if((targetArea.equals(Constants.QUADS) || targetArea.equals(Constants.HAM) || targetArea.equals(Constants.CALVES) || targetArea.equals(Constants.BUTT) || targetArea.equals(Constants.ABS)))
                exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.CALVES, trainingLocation);
            title = "Day " + (i+1) + ": Lower";
            routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), title));
            exercises.clear();
        }
        return routine;
    }

    public ArrayList<Workout> get5DayRoutine(String trainingLocation, String targetArea) {
        exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
        if(!(targetArea.equals(Constants.QUADS) || targetArea.equals(Constants.HAM) || targetArea.equals(Constants.CALVES) || targetArea.equals(Constants.BUTT) || targetArea.equals(Constants.NONE)))
            exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.BICEPS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.TRICEPS, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 1: Upper"));
        exercises.clear();
        exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CALVES, trainingLocation);
        if((targetArea.equals(Constants.QUADS) || targetArea.equals(Constants.HAM) || targetArea.equals(Constants.CALVES) || targetArea.equals(Constants.BUTT) || targetArea.equals(Constants.ABS)))
            exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 2: Lower"));
        exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
        if((targetArea.equals(Constants.BACK) || targetArea.equals(Constants.SHOULDERS)))
            exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 3: Back/Shoulders"));
        exercises.clear();
        exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CALVES, trainingLocation);
        if((targetArea.equals(Constants.QUADS) || targetArea.equals(Constants.HAM) || targetArea.equals(Constants.CALVES) || targetArea.equals(Constants.BUTT) || targetArea.equals(Constants.ABS)))
            exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 4: Lower"));
        exercises.clear();
        exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.BICEPS, trainingLocation);
        exercises=eBank.getExercise(exercises, Constants.TRICEPS, trainingLocation);
        if((targetArea.equals(Constants.CHEST) || targetArea.equals(Constants.BICEPS) || targetArea.equals(Constants.TRICEPS)))
            exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
        routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day 5: Back/Shoulders"));
        return routine;
    }

    public ArrayList<Workout> get6DayRoutine(String trainingLocation, String targetArea){
        for(int i=0; i<2; i++){
            exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.BACK, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.BICEPS, trainingLocation);
            if((targetArea.equals(Constants.BACK) || targetArea.equals(Constants.BICEPS)))
                exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
            routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day " + (1+(3*i)) + ": Pull"));
            exercises.clear();
            exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.CHEST, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.SHOULDERS, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.TRICEPS, trainingLocation);
            if((targetArea.equals(Constants.CHEST) || targetArea.equals(Constants.SHOULDERS)))
                exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
            routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day " + (2+(3*i)) + ": Push"));
            exercises.clear();
            exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.QUADS, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.HAM, trainingLocation);
            exercises=eBank.getExercise(exercises, Constants.CALVES, trainingLocation);
            if((targetArea.equals(Constants.QUADS) || targetArea.equals(Constants.HAM) || targetArea.equals(Constants.CALVES) || targetArea.equals(Constants.BUTT) || targetArea.equals(Constants.ABS)))
                exercises=eBank.getExercise(exercises, targetArea, trainingLocation);
            routine.add(new Workout((ArrayList<Exercise>) exercises.clone(), "Day " + (3+(3*i)) + ": Legs"));
            exercises.clear();
        }
        return routine;
    }


    private String getSetsAndReps(User user, Exercise e){
        String experience = user.getExperience();
        if(e.getLocationType().equals(Constants.GYM)){
            if(e.getType().equals(Constants.POWER)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x8";
                    case Constants.NOVICE:
                        return "3x5";
                    case Constants.INTER:
                        return "4x5";
                    case Constants.ADVAN:
                        return "5x5";
                    case Constants.ELITE:
                        return "5x5";
                }
            }
            else if(e.getType().equals(Constants.HYPER)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x10";
                    case Constants.NOVICE:
                        return "3x12";
                    case Constants.INTER:
                        return "4x12";
                    case Constants.ADVAN:
                        return "4x12";
                    case Constants.ELITE:
                        return "4x12";
                }
            }
            else if(e.getType().equals(Constants.ENDU)) {
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x15";
                    case Constants.NOVICE:
                        return "4x15";
                    case Constants.INTER:
                        return "4x20";
                    case Constants.ADVAN:
                        return "5x18";
                    case Constants.ELITE:
                        return "5x20";
                }
            }
        }
        else if(e.getLocationType().equals(Constants.BODY)){
            if(e.getType().equals(Constants.POW_HYPE)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x8";
                    case Constants.NOVICE:
                        return "3x5";
                    case Constants.INTER:
                        return "4x5";
                    case Constants.ADVAN:
                        return "5x5";
                    case Constants.ELITE:
                        return "5x5";
                }
            }
            else if(e.getType().equals(Constants.ENDU)) {
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x15";
                    case Constants.NOVICE:
                        return "4x15";
                    case Constants.INTER:
                        return "4x20";
                    case Constants.ADVAN:
                        return "5x18";
                    case Constants.ELITE:
                        return "5x20";
                }
            }
        }
        else if(e.getLocationType().equals(Constants.DUMB)){
            if(e.getType().equals(Constants.POWER)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x8";
                    case Constants.NOVICE:
                        return "3x5";
                    case Constants.INTER:
                        return "4x5";
                    case Constants.ADVAN:
                        return "5x5";
                    case Constants.ELITE:
                        return "5x5";
                }
            }
            else if(e.getType().equals(Constants.HYPER)){
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x10";
                    case Constants.NOVICE:
                        return "3x12";
                    case Constants.INTER:
                        return "4x12";
                    case Constants.ADVAN:
                        return "4x12";
                    case Constants.ELITE:
                        return "4x12";
                }
            }
            else if(e.getType().equals(Constants.ENDU)) {
                switch (experience) {
                    case Constants.BEGIN:
                        return "3x15";
                    case Constants.NOVICE:
                        return "4x15";
                    case Constants.INTER:
                        return "4x20";
                    case Constants.ADVAN:
                        return "5x18";
                    case Constants.ELITE:
                        return "5x20";
                }
            }
        }
        return "3x8";
    }
}
