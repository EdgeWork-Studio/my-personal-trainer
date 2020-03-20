package com.example.mypersonaltrainer.ObjectClasses;

public class Exercise
{
    // instance variables - replace the example below with your own
    private String name;
    private String type; //AEROBIC,FLEXIBILITY,POWER,BALANCE ...enum class??
    private String locationType; //GYM, BODY WEIGHT, ETC.
    private String primaryMuscleGroup; //...enum class?
    private String secondaryMuscleGroup; //...enum class?
    private long difficulty; //...enum class?




    public Exercise(String name, String type, String primaryMuscleGroup, String secondaryMuscleGroup, long difficulty)
    {
        this.name = name;
        this.type = type;
        this.primaryMuscleGroup = primaryMuscleGroup;
        this.secondaryMuscleGroup = secondaryMuscleGroup;
        this.difficulty = difficulty;
    }


    public String getName(){
        return this.name;
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
        return ("com.example.mypersonaltrainer.ObjectClasses.Exercise: " + this.name +"\n");
    }






}