package com.example.mypersonaltrainer.ObjectClasses;

import com.example.mypersonaltrainer.ObjectClasses.Aerobic;
import com.example.mypersonaltrainer.ObjectClasses.Arms;
import com.example.mypersonaltrainer.ObjectClasses.Back;
import com.example.mypersonaltrainer.ObjectClasses.Chest;
import com.example.mypersonaltrainer.ObjectClasses.Legs;

import java.util.ArrayList;

public class WorkoutGenerator {

    private ArrayList<Workout> routine;
    private ArrayList<Chest> chestBank;
    private ArrayList<Legs> legBank;
    private ArrayList<Back> backBank;
    private ArrayList<Arms> armBank;
    private ArrayList<Aerobic> aeroBank;
    // private static int numExercises = 8;

    public WorkoutGenerator() {
        routine = new ArrayList<Workout>();
        chestBank = new ArrayList<Chest>();
        legBank = new ArrayList<Legs>();
        backBank = new ArrayList<Back>();
        armBank = new ArrayList<Arms>();
        aeroBank = new ArrayList<Aerobic>();
    }

    private Workout getChestTri(String... goal) {
        int numChestEx = 4;
        int numTricepsEx = 4;
        int chestCount = 0, tricepsCount = 0;
        Workout w = new Workout();

        if (goal[0].equals("com.example.mypersonaltrainer.ObjectClasses.Chest")) {
            numTricepsEx--;
            numChestEx++;
        }
        if (goal[0].equals("Triceps")) {
            numTricepsEx++;
            numChestEx--;
        }
        for (Exercise e : chestBank) {
            if (chestCount == numChestEx)
                break;
            if (e.getPrimaryMuscleGroup().equals("Pectorals")) {
                w.addExcercise(e);
                chestCount++;
            }
        }

        for (Exercise e : armBank) {
            if (tricepsCount == numTricepsEx)
                break;
            if (e.getPrimaryMuscleGroup().equals("Triceps")) {
                w.addExcercise(e);
                tricepsCount++;
            }
        }
        w.shuffleList();
        return w;
    }

    private Workout getLegs(String... goal) {
        int numQuad = 3, quadCount = 0;
        int numHam = 3, hamCount = 0;
        int numCalf = 2, calfCount = 0;

        Workout w = new Workout();

        for(Exercise e: legBank){

            if (e.getPrimaryMuscleGroup().equals("Quadriceps") && numQuad != quadCount){
                w.addExcercise(e);
                quadCount++;
            }
            if (e.getPrimaryMuscleGroup().equals("Hamstring") && numHam != hamCount){
                w.addExcercise(e);
                hamCount++;
            }
            if (e.getPrimaryMuscleGroup().equals("Calf") && numCalf != calfCount){
                w.addExcercise(e);
                calfCount++;
            }

            if(numQuad == quadCount && numHam == hamCount && numCalf == calfCount)
                break;
        }
        w.shuffleList();
        return w;
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
