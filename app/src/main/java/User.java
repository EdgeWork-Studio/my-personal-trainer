import com.google.firebase.auth.FirebaseUser;

public class User {
    private String userID, email, displayName, activityLevel, experience; //BEGINNER, NOVICE, INTERMEDIATE, ADVANCED, ELITE
    private Boolean man;
    private Double weight, height, bodyFat = 0.0;
    private Long age, tdee, days, time;

    public User(){}
    public User(FirebaseUser account, String activityLevel, String experience, Boolean man, Double weight, Double height, Long age, Long days, Long time){
        this.userID = account.getUid();
        this.email = account.getEmail();
        this.displayName = account.getDisplayName();
        this.activityLevel = activityLevel;
        this.experience = experience;
        this.man = man;
        this.weight = weight; //in kg
        this.height = height; //in cm
        this.age = age;
        this.tdee = calculateTDEE();
    }
    public User(FirebaseUser account, String activityLevel, String experience, Boolean man, Double weight, Double height, Double bodyFat, Long age, Long days, Long time){
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
        this.tdee = calculateTDEE();
    }

    private Long calculateTDEE(){
        double bmr = 0, adjustedWeight;

        if(bodyFat >= 1) adjustedWeight = weight * ((100.0 - bodyFat) / 100);
        else if(man) adjustedWeight = weight * 0.80;
        else adjustedWeight = weight * 0.75;

        if(man) bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
        else if(!man) bmr = 655 + (9.6 * weight) + (1.8 * height) - (4.7 * age);

        switch (activityLevel){
            case "Sedentary": bmr = bmr * 1.2;
            case "Lightly Active": bmr = bmr * 1.375;
            case "Moderately Active": bmr = bmr * 1.55;
            case "Very Active": bmr = bmr * 1.725;
            case "Extremely Active": bmr = bmr * 1.9;
        }
        return Math.round(bmr);
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
    public void setAge(Long age) {
        this.age = age;
    }
    public void setTdee(Long tdee) {
        this.tdee = tdee;
    }
    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }
    public void setDays(Long days) {
        this.days = days;
    }
    public void setTime(Long time) {
        this.time = time;
    }
    public void setExperience(String experience){
        this.experience = experience;
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
    public Long getAge() {
        return age;
    }
    public Long getTdee() {
        return tdee;
    }
    public Long getDays() {
        return days;
    }
    public Long getTime() {
        return time;
    }
    public String getExperience() {
        return experience;
    }
}
