package com.example.mypersonaltrainer.ObjectClasses;

import java.util.ArrayList;
import java.util.Random;
public class ExerciseBank
{
    private ArrayList<Exercise> pectorals;
    private ArrayList<Exercise> back;
    private ArrayList<Exercise> quadriceps;
    private ArrayList<Exercise> calves;
    private ArrayList<Exercise> biceps;
    private ArrayList<Exercise> triceps;
    private ArrayList<Exercise> shoulders;
    private ArrayList<Exercise> bodyweight;
    private ArrayList<Exercise> compound;
    private ArrayList<Exercise> abs;
    private ArrayList<Exercise> cardio;
    private ArrayList<Integer> usedIndices;
    private Random random;
    public ExerciseBank()
    {
        initPectorals();
        initBack();
        initCalves();
        initBiceps();
        initQuadriceps();
        initShoulders();
        initCompound();
        usedIndices = new ArrayList<Integer>();
        random = new Random();
    }

    private void initPectorals()
    {
        pectorals = new ArrayList<Exercise>();
        pectorals.add(new Exercise("Decline Dumbbell press", "Strength", "Pectorals", "Triceps",9));
        pectorals.add(new Exercise("Incline Dumbbell press",  "Strength", "Pectorals", "Triceps",9));
        pectorals.add(new Exercise("Dumbbell Flye",  "Hypertrophy", "Pectorals", "Deltoids",9));
        pectorals.add(new Exercise("Landmine Press", "Strength", "Pectorals", "Triceps",9));
        pectorals.add(new Exercise("Barbell Press", "Strength", "Pectorals", "Triceps",9));
        pectorals.add(new Exercise("Cable fly", "Hypertrophy", "Pectorals", "Triceps",9));
    }

    private void initBack(){
        back = new ArrayList<Exercise>();
        back.add(new Exercise("Lat Pull Down", "Strength", "Back", "Biceps",9));
        back.add(new Exercise("Bent Over Row", "Strength", "Back", "Biceps",9));
        back.add(new Exercise("Renegade Row", "Strength", "Back", "Biceps",9));
        back.add(new Exercise("Seated Cable Row", "Strength", "Back", "Biceps",9));
        back.add(new Exercise("Chest-Supported Dumbbell Row", "Strength", "Back", "Biceps",9));
        back.add(new Exercise("Single Arm Dumbbell Row", "Strength", "Back", "Shoulder",9));
    }

    private void initQuadriceps(){
        quadriceps = new ArrayList<Exercise>();
        quadriceps.add(new Exercise("Front Squat", "Strength", "Quadriceps", "Glutes",8));
        quadriceps.add(new Exercise("Bulgarian Split Squat", "Strength", "Quadriceps", "Glutes",10));
        quadriceps.add(new Exercise("Romanian Deadlift", "Strength", "Glutes", "Quadriceps",10));
        quadriceps.add(new Exercise("Dumbbell Stepup", "Strength","Quadriceps", "Glutes",10));
        quadriceps.add(new Exercise("Leg Press", "Strength", "Quadriceps", "Glutes",10));
        quadriceps.add(new Exercise("Barbell Front Squat", "Hypertrophy", "Quadriceps", "Glutes",10));
        quadriceps.add(new Exercise("Barbell Box Squat", "Strength", "Quadriceps", "Glutes",10));
        quadriceps.add(new Exercise("Leg Extension", "Strength", "Quadriceps", "Glutes",10));
    }
    private void initBiceps()
    {
        biceps = new ArrayList<Exercise>();
        biceps.add(new Exercise("Hammer Curl", "Strength", "Quadriceps", "Glutes",8));
        biceps.add(new Exercise("Decline Dumbbell Curl", "Strength", "Quadriceps", "Glutes",10));
        biceps.add(new Exercise("Incline Dumbbell Curl", "Strength", "Glutes", "Quadriceps",10));
        biceps.add(new Exercise("EZ-Bar Preacher Curl", "Strength","Quadriceps", "Glutes",10));
        biceps.add(new Exercise("Leg Press", "Strength", "Quadriceps", "Glutes",10));
        biceps.add(new Exercise("Standing Barbell Curl", "Quadriceps", "Glutes", "N/A",10));
        biceps.add(new Exercise("Concentration Curl", "Strength", "Quadriceps", "Glutes",10));
        biceps.add(new Exercise("Kneeling Single Arm Curl", "Strength", "Quadriceps", "Glutes",10));
    }
    private void initTriceps()
    {
        triceps = new ArrayList<Exercise>();
        triceps.add(new Exercise("Close Grip Bench Press", "Strength", "Triceps", "Pectorals",8));
        triceps.add(new Exercise("Rope Tricep Push Down", "Strength", "Triceps", "Shoulders",10));
        triceps.add(new Exercise("Tricep Dips", "Strength", "Triceps", "Shoulders",10));
        triceps.add(new Exercise("Overhead Tricep Extension", "Strength","Triceps", "Null",10));
        triceps.add(new Exercise("Bench Dip", "Strength", "Triceps", "Null",10));
        triceps.add(new Exercise("Cable Overhead Tricep Extension", "Triceps", "Shoulders", "N/A",10));
        triceps.add(new Exercise("Dumbell Floor Press", "Strength", "Triceps", "Pectorals",10));
    }
    private void initCalves()
    {
        calves = new ArrayList<Exercise>();
        calves.add(new Exercise("Seated Calf Raise(Toes Neutral)", "Strength", "Calves", "Null",8));
        calves.add(new Exercise("Seated Calf Raise(Toes In)", "Strength", "Calves", "Shoulders",10));
        calves.add(new Exercise("Single Leg Calf Raise(", "Strength", "Calves", "Shoulders",10));
        calves.add(new Exercise("Calve Dummy", "Strength","Calves", "Null",10));
        calves.add(new Exercise("Lateral Lunge Curtsy", "Strength", "Calves", "Null",10));
    }

    private void initShoulders()
    {
        shoulders = new ArrayList<Exercise>();
        shoulders.add(new Exercise("Seated Dumbbell Shoulder Press", "Strength", "Shoulders", "Null",8));
        shoulders.add(new Exercise("Arnold Press", "Strength", "Shoulders", "Null",10));
        shoulders.add(new Exercise("Two Arm Dumbbell Upright Row", "Strength", "Shoulders", "Shoulders",10));
        shoulders.add(new Exercise("Seated Bent Over Rear Delt Fly", "Strength","Shoulders", "Null",10));
        shoulders.add(new Exercise("Single Dumbbell Front Raise", "Strength", "Shoulders", "Null",10));
    }
    private void initCompound(){
        compound = new ArrayList<Exercise>();
        compound.add(new Exercise("Deadlift", "Strength", "Glutes", "Hamstring",8));
        compound.add(new Exercise("Pull Up", "Strength", "Biceps", "Back",8));
    }

    private int findOpenIndex(ArrayList<Exercise> e){
        int r = random.nextInt(e.size() - 1);
        while(usedIndices.contains(r))
            r = random.nextInt(e.size() - 1);

        usedIndices.add(r);
        return r;
    }

    public ArrayList getQuadExercises(int numEx, ArrayList<Exercise> e, String...targetArea){
        for(String t: targetArea){
            if(t.equals("Thighs"));
            numEx+=1;
        }
        for(int i=0; i<numEx; i++)
            e.add(quadriceps.get(findOpenIndex(quadriceps)));

        usedIndices.clear();
        return e;
    }

    public ArrayList getCalfExercises(int numEx, ArrayList<Exercise> e, String...targetArea){
        // System.out.println(numEx);
        for(String t: targetArea){
            if(t.equals("Calves"))
                numEx+=1;
        }

        for(int i=0; i<numEx; i++){
            e.add(calves.get(findOpenIndex(calves)));
        }

        usedIndices.clear();
        return e;
    }
    public ArrayList getBackExercises(int numEx, ArrayList<Exercise> e, String...targetArea){
        for(String t: targetArea){
            if(t.equals("Back"))
                numEx+=1;
        }
        for(int i=0; i<numEx; i++){
            e.add(back.get(findOpenIndex(back)));
        }
        usedIndices.clear();
        return e;
    }
    public ArrayList getPectoralExercises(int numEx, ArrayList<Exercise> e, String...targetArea){

        for(String t: targetArea){
            if(t.equals("Chest"))
                numEx+=1;
        }
        for(int i=0; i<numEx; i++){
            e.add(pectorals.get(findOpenIndex(pectorals)));
        }

        usedIndices.clear();
        return e;
    }
    public ArrayList getBicepExercises(int numEx, ArrayList<Exercise> e,String...targetArea){
        for(String t: targetArea){
            if(t.equals("Biceps"))
                numEx+=1;
        }
        for(int i=0; i<numEx; i++){
            e.add(biceps.get(findOpenIndex(biceps)));
        }

        usedIndices.clear();
        return e;
    }
    public ArrayList getCompoundExercise(String muscleGroup, ArrayList<Exercise> e,String...targetArea){
        for(Exercise c: compound){
            if(c.getPrimaryMuscleGroup().equals(muscleGroup) || c.getSecondaryMuscleGroup().equals(muscleGroup)){
                e.add(c);
                break;
            }

        }
        return e;
    }

}
