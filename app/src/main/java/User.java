import com.google.firebase.auth.FirebaseUser;

public class User {
    private String userID, email, displayName, activityLevel;
    private Boolean man;
    private Double weight, height, bodyFat = 0.0;
    private Long age, tdee;

    public User(){}
    public User(FirebaseUser account, String activityLevel, Boolean man, Double weight, Double height, Long age){
        this.userID = account.getUid();
        this.email = account.getEmail();
        this.displayName = account.getEmail();
        this.activityLevel = activityLevel;
        this.man = man;
        this.weight = weight; //in kg
        this.height = height; //in cm
        this.age = age;
        this.tdee = calculateTDEE();
    }
    public User(FirebaseUser account, String activityLevel, Boolean man, Double weight, Double height, Double bodyFat, Long age){
        this.userID = account.getUid();
        this.email = account.getEmail();
        this.displayName = account.getEmail();
        this.activityLevel = activityLevel;
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
}
