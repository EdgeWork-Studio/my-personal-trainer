package com.example.mypersonaltrainer.ObjectClasses;


public class Exercise
{
    private String name, primaryMuscleGroup, secondaryMuscleGroup, tutorial;
    private String type; //press, row, curl, squat, etc.
    private String locationType; //GYM, BODY WEIGHT, ETC.




    public Exercise(String name, String type, String locationType, String primaryMuscleGroup, String secondaryMuscleGroup)
    {
        this.name = name;
        this.type = type;
        this.locationType = locationType;
        this.primaryMuscleGroup = primaryMuscleGroup;
        this.secondaryMuscleGroup = secondaryMuscleGroup;
        this.tutorial = "link";
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

    public String getLocationType(){
        return this.locationType;
    }

    public String toString(){
        return ("Exercise: " + this.name +"\n");
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

    public String getSetsAndReps(String experience, String workoutType){
        if(locationType.equals(Constants.GYM)){
            if(workoutType.equals(Constants.POWER)){
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
            else if(workoutType.equals(Constants.HYPER)){
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
            else if(workoutType.equals(Constants.ENDU)) {
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
        else if(locationType.equals(Constants.BODY)){
            if(workoutType.equals(Constants.POW_HYPE)){
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
            else if(workoutType.equals(Constants.ENDU)) {
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
        else if(locationType.equals(Constants.DUMB)){
            if(workoutType.equals(Constants.POWER)){
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
            else if(workoutType.equals(Constants.HYPER)){
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
            else if(workoutType.equals(Constants.ENDU)) {
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