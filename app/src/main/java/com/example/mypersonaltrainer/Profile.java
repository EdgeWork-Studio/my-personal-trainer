package com.example.mypersonaltrainer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mypersonaltrainer.ObjectClasses.Constants;
import com.example.mypersonaltrainer.ObjectClasses.User;
import com.example.mypersonaltrainer.ObjectClasses.Workout;
import com.example.mypersonaltrainer.ObjectClasses.WorkoutGenerator;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.gson.Gson;

import org.apache.commons.lang3.math.NumberUtils;
import org.w3c.dom.Text;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {
    private SharedPreferences mPrefs;
    private GoogleSignInClient gsc;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
        mPrefs = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        final Spinner trainingLocation = findViewById(R.id.spn_trainloc);
        final Spinner workoutType = findViewById(R.id.spn_worktype);
        Gson gson = new Gson();
        String json = mPrefs.getString("user", "user not found");
        if(json.equals("user not found")) returnToHome();
        else
            user = gson.fromJson(json, User.class);
        RadioButton rb;
        TextView tv;
        Spinner spinner;
        String[] temp = null;
        if(user.getMan())  rb = findViewById(R.id.radio_male);
        else  rb = findViewById(R.id.radio_female);
        rb.setChecked(true);
        tv = findViewById(R.id.input_age);
        tv.setText(user.getAge()+"");
        tv = findViewById(R.id.input_weight);
        tv.setText(user.getWeight()+"");
        tv = findViewById(R.id.input_height);
        tv.setText(user.getHeight()+"");
        spinner = findViewById(R.id.spn_weight_goal);
        switch (user.getWeightGoal()){
            case Constants.LOSE: spinner.setSelection(1); break;
            case Constants.GAIN: spinner.setSelection(2); break;
            default: spinner.setSelection(0); break;
        }
        spinner = findViewById(R.id.spn_activity);
        switch (user.getActivityLevel()){
            case Constants.LIGHTLY: spinner.setSelection(1); break;
            case Constants.MODERATELY: spinner.setSelection(2); break;
            case Constants.VERY: spinner.setSelection(3); break;
            default: spinner.setSelection(0); break;
        }
        tv = findViewById(R.id.input_body_fat);
        tv.setText(user.getBodyFat()+"");
        spinner = findViewById(R.id.spn_experience);
        switch (user.getExperience()){
            case Constants.NOVICE: spinner.setSelection(1); break;
            case Constants.INTER: spinner.setSelection(2); break;
            case Constants.ADVAN: spinner.setSelection(3); break;
            case Constants.ELITE: spinner.setSelection(4); break;
            default: spinner.setSelection(0); break;
        }
        switch (user.getTrainingLocation()){
            case Constants.DUMB:
                trainingLocation.setSelection(1);
                temp = getResources().getStringArray(R.array.free_options);
                break;
            case Constants.BODY:
                trainingLocation.setSelection(2);
                temp = getResources().getStringArray(R.array.body_options);
                break;
            default:
                trainingLocation.setSelection(0);
                temp = getResources().getStringArray(R.array.gym_options);
                break;
        }
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, temp); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        workoutType.setAdapter(spinnerArrayAdapter);
        switch (user.getWorkoutType()){
            case Constants.HYPER: workoutType.setSelection(2); break;
            case Constants.ENDU: workoutType.setSelection(1); break;
            default: workoutType.setSelection(0); break;
        }
        spinner = findViewById(R.id.spn_workday);
        switch (user.getDays()){
            case 3: spinner.setSelection(1); break;
            case 4: spinner.setSelection(2); break;
            case 5: spinner.setSelection(3); break;
            case 6: spinner.setSelection(4); break;
            default: spinner.setSelection(0); break;
        }
        spinner = findViewById(R.id.spn_muscleFocus);
        switch (user.getMuscleFocus()){
            case Constants.SHOULDERS: spinner.setSelection(0); break;
            case Constants.CHEST: spinner.setSelection(1); break;
            case Constants.BICEPS: spinner.setSelection(2); break;
            case Constants.TRICEPS: spinner.setSelection(3); break;
            case Constants.BACK: spinner.setSelection(4); break;
            case Constants.ABS: spinner.setSelection(5); break;
            case Constants.BUTT: spinner.setSelection(6); break;
            case Constants.QUADS: spinner.setSelection(7); break;
            case Constants.HAM: spinner.setSelection(8); break;
            case Constants.CALVES: spinner.setSelection(9); break;
            default: spinner.setSelection(10); break;
        }

        trainingLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sel1 = trainingLocation.getSelectedItem().toString();
                String[] types = null;
                switch (sel1){
                    case Constants.GYM:
                        types = getResources().getStringArray(R.array.gym_options);
                        break;
                    case Constants.BODY:
                        types = getResources().getStringArray(R.array.body_options);
                        break;
                    case Constants.DUMB:
                        types = getResources().getStringArray(R.array.free_options);
                        break;
                }
                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, types); //selected item will look like a spinner set from XML
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                workoutType.setAdapter(spinnerArrayAdapter);

            }
            public void onNothingSelected(AdapterView<?> adapterView) { return; }
        });

        workoutType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) workoutType.getChildAt(0 );
                if(textView!=null)
                    textView.setTextColor(Color.rgb(249, 249, 249));
            }
            public void onNothingSelected(AdapterView<?> adapterView) { return; }
        });

    }


    public void signOut(View view) {
        gsc.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        returnToHome();
                    }
                });
    }

    private void returnToHome(){
        finish();
    }

    public void saveChanges(View view){
        String muscleFocus, activityLevel, experience, temp, goal, trainingLocation, workoutType;
        Integer age=0, days;
        Double weight=0.0, height=0.0, bodyfat;
        Boolean man, valid=true;
        man = ((RadioButton) findViewById(R.id.radio_male)).isChecked();
        activityLevel = ((Spinner) findViewById(R.id.spn_activity)).getSelectedItem().toString();
        experience = ((Spinner) findViewById(R.id.spn_experience)).getSelectedItem().toString();
        temp = ((TextView) findViewById(R.id.input_age)).getText().toString();
        if(!NumberUtils.isParsable(temp)) valid = false;
        else age = Integer.valueOf(temp);
        if(age<5) valid=false;
        temp = ((TextView) findViewById(R.id.input_weight)).getText().toString();
        if(!NumberUtils.isParsable(temp)) valid = false;
        else {
            weight = Math.round(Double.valueOf(temp) * 100.0) / 100.0;
            if(weight<50 || weight>400) valid=false;
            if (((RadioButton) findViewById(R.id.radio_pounds)).isChecked())
                weight = Math.round(weight * 45.359239) / 100.0;
        }
        temp = ((TextView) findViewById(R.id.input_height)).getText().toString();
        if(!NumberUtils.isParsable(temp)) valid = false;
        else {
            height = Math.round(Double.valueOf(temp) * 100.0) / 100.0;
            if(height<50 || height>400) valid=false;
            if (((RadioButton) findViewById(R.id.radio_inches)).isChecked())
                height = Math.round(height * 254.0) / 100.0;
        }
        temp = ((TextView) findViewById(R.id.input_body_fat)).getText().toString();
        if(NumberUtils.isParsable(temp))
            bodyfat = Double.valueOf(temp);
        else bodyfat = 0.0;
        if(bodyfat<0) valid=false;
        goal = ((Spinner) findViewById(R.id.spn_weight_goal)).getSelectedItem().toString();
        trainingLocation = ((Spinner) findViewById(R.id.spn_trainloc)).getSelectedItem().toString();
        workoutType = ((Spinner) findViewById(R.id.spn_worktype)).getSelectedItem().toString();
        temp = ((Spinner) findViewById(R.id.spn_workday)).getSelectedItem().toString();
        days = Integer.valueOf(temp);
        muscleFocus = ((Spinner) findViewById(R.id.spn_muscleFocus)).getSelectedItem().toString();

        if(valid) {
            user.setMan(man);
            user.setAge(age);
            user.setWeight(weight);
            user.setHeight(height);
            user.setWeightGoal(goal);
            user.setActivityLevel(activityLevel);
            user.setBodyFat(bodyfat);
            user.setTdee(user.calculateTDEE());
            if (!(user.getExperience().equals(experience) && user.getTrainingLocation().equals(trainingLocation) && user.getWorkoutType().equals(workoutType) && user.getDays() == days && user.getMuscleFocus().equals(muscleFocus))) {
                user.setExperience(experience);
                user.setTrainingLocation(trainingLocation);
                user.setWorkoutType(workoutType);
                user.setDays(days);
                user.setMuscleFocus(muscleFocus);
                WorkoutGenerator wg = new WorkoutGenerator(getApplicationContext());
                ArrayList<Workout> routine;
                routine = wg.getRoutine(user.getDays(), user.getTrainingLocation(), user.getMuscleFocus());
                user.setRoutine(routine);
            }
            SharedPreferences.Editor prefsEditor = mPrefs.edit();
            Gson gson = new Gson();
            String json = gson.toJson(user);
            prefsEditor.putString("user", json);
            prefsEditor.commit();
            returnToHome();
        }
        else{
            TextView tv = findViewById(R.id.txt_profile);
            tv.setText("Please ensure all data entered is valid");
            tv.setTextColor(ContextCompat.getColor(this, R.color.error));
        }
    }
    public void btnReturnToHome(View view){
        returnToHome();
    }
}
