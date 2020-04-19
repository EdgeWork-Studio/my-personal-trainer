package com.example.mypersonaltrainer.ObjectClasses;

import android.content.Context;

import com.example.mypersonaltrainer.R;
import com.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
public class ExerciseBank
{
    private ArrayList<Exercise> abs, back, biceps, butt, calves, chest, hamstrings, quads, shoulders, triceps, unknown;
    private Random random;
    private Context context;
    public ExerciseBank(Context context)
    {
        this.context = context;
        random = new Random();
        initExercises();
    }

    private void initExercises(){
        abs = new ArrayList<>();
        back = new ArrayList<>();
        biceps = new ArrayList<>();
        butt = new ArrayList<>();
        calves = new ArrayList<>();
        chest = new ArrayList<>();
        hamstrings = new ArrayList<>();
        quads = new ArrayList<>();
        shoulders = new ArrayList<>();
        triceps = new ArrayList<>();
        unknown = new ArrayList<>();
        try {
            InputStream inputStream = context.getResources().openRawResource(R.raw.exercises);
            CSVReader reader = new CSVReader(new InputStreamReader(inputStream));
            String[] nextLine = reader.readNext();
            String name, type, locationType, primary, secondary;
            if(nextLine != null && nextLine[0].equals("name")){
                while ((nextLine = reader.readNext()) != null) {
                    // nextLine[] is an array of values from the line
                    name = nextLine[0];
                    type = nextLine[1];
                    locationType = nextLine[2];
                    primary = nextLine[3];
                    secondary = nextLine[4];
                    ArrayList<Exercise> temp;
                    switch (primary){
                        case Constants.ABS: temp = abs; break;
                        case Constants.BACK: temp = back; break;
                        case Constants.BICEPS: temp = biceps; break;
                        case Constants.BUTT: temp = butt; break;
                        case Constants.CALVES: temp = calves; break;
                        case Constants.CHEST: temp = chest; break;
                        case Constants.HAM: temp = hamstrings; break;
                        case Constants.QUADS: temp = quads; break;
                        case Constants.SHOULDERS: temp = shoulders; break;
                        case Constants.TRICEPS: temp = triceps; break;
                        default: temp = unknown; break;
                    }
                    Exercise e = new Exercise(name, type, locationType, primary, secondary);
                    temp.add(e);
                }

            }
        } catch (Exception e) {
            System.out.println("FAILLLLLL   " + e);
        }
    }


    public ArrayList<Exercise> getExercise(ArrayList<Exercise> exercises, String target, String locationType){
        switch(target){
            case Constants.ABS: return getXExercise(exercises, abs, locationType);
            case Constants.BACK: return getXExercise(exercises, back, locationType);
            case Constants.BICEPS: return getXExercise(exercises, biceps, locationType);
            case Constants.BUTT: return getXExercise(exercises, butt, locationType);
            case Constants.CALVES: return getXExercise(exercises, calves, locationType);
            case Constants.CHEST: return getXExercise(exercises, chest, locationType);
            case Constants.HAM: return getXExercise(exercises, hamstrings, locationType);
            case Constants.QUADS: return getXExercise(exercises, quads, locationType);
            case Constants.SHOULDERS: return getXExercise(exercises, shoulders, locationType);
            case Constants.TRICEPS: return getXExercise(exercises, triceps, locationType);
            default: return null;
        }
    }


    public ArrayList<Exercise> getXExercise(ArrayList<Exercise> exercises, ArrayList<Exercise> exerciseBank, String locationType){
        ArrayList<Exercise> exercises2 = (ArrayList) exerciseBank.clone();
        System.out.println(exercises2.get(0));
        if(locationType.equals(Constants.GYM)){
            for(Exercise e: exercises){
                if(exercises2.contains(e)) exercises2.remove(e);
            }
        }
        else if(locationType.equals(Constants.DUMB)){
            for(Exercise e: exercises){
                if(e.getLocationType().equals(Constants.GYM)) exercises2.remove(e);
                else if(exercises2.contains(e)) exercises2.remove(e);
            }
        }
        else if(locationType.equals(Constants.BODY)){
            for(Exercise e: exercises){
                if(e.getLocationType().equals(Constants.GYM) || e.getLocationType().equals(Constants.DUMB)) exercises2.remove(e);
                else if(exercises2.contains(e)) exercises2.remove(e);
            }
        }
        Exercise e =null;
        while(e == null){
            e = exercises2.get(random.nextInt(exercises2.size()));
            if(exercises2.size()<=1) break;
            int targetCount = 0, typeCount = 0;
            for(Exercise e2:exercises){
                if(e.getPrimaryMuscleGroup().equals(e2.getPrimaryMuscleGroup()))
                    targetCount++;
                if(e.getType().equals(e2.getType()))
                    typeCount++;
            }
            if(typeCount>=targetCount/2){
                exercises2.remove(e);
                e = null;
            }
        }
        exercises.add(e);
        return exercises;
    }
}
