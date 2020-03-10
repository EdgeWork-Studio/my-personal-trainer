package com.example.mypersonaltrainer.ObjectClasses;

public class Exercise
{
    private String name;
    private int avgDuration; //min
    private String type; //AEROBIC,FLEXIBILITY,POWER,BALANCE ...enum class??
    private String locationType; //GYM, BODY WEIGHT, ETC.
    private String primaryMuscleGroup; //...enum class?
    private String secondaryMuscleGroup; //...enum class?
    private long difficulty; //...enum class?




    public Exercise(String name, int avgDuration, String type, String primaryMuscleGroup, String secondaryMuscleGroup, long difficulty)
    {
        this.name = name;
        this.avgDuration = avgDuration;
        this.type = type;
        this.primaryMuscleGroup = primaryMuscleGroup;
        this.secondaryMuscleGroup = secondaryMuscleGroup;
        this.difficulty = difficulty;
    }


    public String getName(){
        return this.name;
    }

    public int getAvgDuration(){
        return this.avgDuration;
    }

    public String getType(){
        return this.type;
    }

    public String getPrimaryMuscleGroup(){
        return this.primaryMuscleGroup;
    }

    public String getSecondaryMuscleGroup(){
        return this.secondaryMuscleGroup;
    }

    public long getDifficulty(){
        return this.difficulty;
    }

    public String getLocationType(){
        return this.locationType;
    }

    public String toString(){
        return ("com.example.mypersonaltrainer.ObjectClasses.Exercise: " + this.name + "Duration: " + this.avgDuration);
    }






}
