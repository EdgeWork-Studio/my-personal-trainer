package com.example.mypersonaltrainer.ObjectClasses;

import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class User {
    private String userID, email, displayName, activityLevel, experience, workoutType, trainingLocation, muscleFocus, weightGoal; //BEGINNER, NOVICE, INTERMEDIATE, ADVANCED, ELITE
    private Boolean man;
    private Double weight, height, bodyFat = 0.0; //weight in kg, height in cm
    private Integer age, tdee, days;
    private ArrayList<Workout> routine;



    public User(){}
    public User(FirebaseUser account){
        this.userID = account.getUid();
        this.email = account.getEmail();
        this.displayName = account.getDisplayName();
    }
    public User(FirebaseUser account, String activityLevel, String experience, Boolean man, Double weight, Double height, Integer age, String goal){
        this.userID = account.getUid();
        this.email = account.getEmail();
        this.displayName = account.getDisplayName();
        this.activityLevel = activityLevel;
        this.experience = experience;
        this.man = man;
        this.weight = weight; //in kg
        this.height = height; //in cm
        this.age = age;
        this.weightGoal = goal;
        this.tdee = calculateTDEE();
    }
    public User(FirebaseUser account, String activityLevel, String experience, Boolean man, Double weight, Double height, Double bodyFat, Integer age, String goal){
        this.userID = account.getUid();
        this.email = account.getEmail();
        this.displayName = account.getDisplayName();
        this.activityLevel = activityLevel;
        this.experience = experience;
        this.man = man;
        this.weight = weight; //in kg
        this.height = height; //in cm
        this.bodyFat = bodyFat;
        this.age = age;
        this.weightGoal = goal;
        this.tdee = calculateTDEE();
    }

    public Integer calculateTDEE(){ //weight in kg, height in cm
        double bmr = 0, adjustedWeight;
        Integer returnValue = 0;

        System.out.println("height: " + height + " weight: " + weight);

        if(bodyFat >= 1) adjustedWeight = weight * ((100.0 - bodyFat) / 100);
        else if(man) adjustedWeight = weight * 0.80;
        else adjustedWeight = weight * 0.75;

        if(man) bmr = 66 + (13.7 * adjustedWeight) + (5 * height) - (6.8 * age);
        else bmr = 655 + (9.6 * adjustedWeight) + (1.8 * height) - (4.7 * age);

        System.out.println("bmr: " + bmr);

        switch (activityLevel){
            case Constants.SEDENTARY: bmr = bmr * 1.2; break;
            case Constants.LIGHTLY: bmr = bmr * 1.375; break;
            case Constants.MODERATELY: bmr = bmr * 1.55; break;
            case Constants.VERY: bmr = bmr * 1.725; break;
            case Constants.EXTREMELY: bmr = bmr * 1.9; break;
        }
        System.out.println("bmr2: " + bmr);
        returnValue = Integer.valueOf(((Long) (Math.round(bmr))).toString());
        if(weightGoal.equals(Constants.LOSE)) returnValue = returnValue - 500;
        else if(weightGoal.equals(Constants.GAIN)) returnValue = returnValue + 500;
        return returnValue;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public void setMan(Boolean man) {
        this.man = man;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public void setHeight(Double height) {
        this.height = height;
    }
    public void setBodyFat(Double bodyFat) {
        this.bodyFat = bodyFat;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setTdee(Integer tdee) {
        this.tdee = tdee;
    }
    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
    public void setDays(Integer days) {
        this.days = days;
    }
    public void setExperience(String experience){
        this.experience = experience;
    }
    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }
    public void setTrainingLocation(String trainingLocation) {
        this.trainingLocation = trainingLocation;
    }
    public String getMuscleFocus() {
        return muscleFocus;
    }
    public void setMuscleFocus(String muscleFocus) {
        this.muscleFocus = muscleFocus;
    }

    public ArrayList<Workout> getRoutine() {
        return routine;
    }

    public void setRoutine(ArrayList<Workout> routine) {
        this.routine = routine;
    }

    public String getWorkoutType() {
        return workoutType;
    }
    public String getTrainingLocation() {
        return trainingLocation;
    }
    public String getUserID() {
        return userID;
    }
    public String getEmail() {
        return email;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getActivityLevel() {
        return activityLevel;
    }
    public Boolean getMan() {
        return man;
    }
    public Double getWeight() {
        return weight;
    }
    public Double getHeight() {
        return height;
    }
    public Double getBodyFat() {
        return bodyFat;
    }
    public Integer getAge() {
        return age;
    }
    public Integer getTdee() {
        return tdee;
    }
    public Integer getDays() {
        return days;
    }
    public String getExperience() {
        return experience;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", activityLevel='" + activityLevel + '\'' +
                ", experience='" + experience + '\'' +
                ", workoutType='" + workoutType + '\'' +
                ", trainingLocation='" + trainingLocation + '\'' +
                ", muscleFocus='" + muscleFocus + '\'' +
                ", man=" + man +
                ", weight=" + weight +
                ", height=" + height +
                ", bodyFat=" + bodyFat +
                ", age=" + age +
                ", tdee=" + tdee +
                ", days=" + days +
                '}';
    }
}
