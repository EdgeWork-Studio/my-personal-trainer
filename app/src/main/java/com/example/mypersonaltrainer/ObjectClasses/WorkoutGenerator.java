package com.example.mypersonaltrainer.ObjectClasses;

import java.util.ArrayList;

public class WorkoutGenerator {
    private ExerciseBank eBank;
    private ArrayList<Workout> routine;
    private ArrayList<Exercise> exercises;
    public WorkoutGenerator(){
        eBank = new ExerciseBank();
        routine = new ArrayList<Workout>();
        exercises = new ArrayList<Exercise>();
    }


    public ArrayList get4DaySplit(String targetArea){

        exercises=eBank.getQuadExercises(3, exercises,targetArea);
        exercises=eBank.getCalfExercises(2, exercises,targetArea);
        exercises=eBank.getCompoundExercise("Hamstring",exercises);
        routine.add(new Workout(exercises, "Day 1: Leg Day"));

        //exercises.clear() when starting a new set of exercises for next day.
        return routine;
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
