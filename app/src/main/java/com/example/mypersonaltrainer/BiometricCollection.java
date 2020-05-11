package com.example.mypersonaltrainer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;

import com.example.mypersonaltrainer.ObjectClasses.User;
import com.google.gson.Gson;

import org.apache.commons.lang3.math.NumberUtils;

public class BiometricCollection extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometric_collection);
        mAuth = FirebaseAuth.getInstance();
        mPrefs = getSharedPreferences("user_data", Context.MODE_PRIVATE);
    }

    public void collectBiometrics(View view){
        String activityLevel, experience, temp, goal;
        Integer age=0;
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
        if(valid) {
            User user = new User(mAuth.getCurrentUser(), activityLevel, experience, man, weight, height, bodyfat, age, goal);
            SharedPreferences.Editor prefsEditor = mPrefs.edit();
            Gson gson = new Gson();
            String json = gson.toJson(user);
            prefsEditor.putString("user", json);
            prefsEditor.commit();
            Intent i = new Intent(this, WorkoutPrefCollection.class);
            startActivity(i);
        }
        else{
            TextView tv = findViewById(R.id.txt_bio_greet);
            tv.setText("Please ensure all data entered is valid");
            tv.setTextColor(ContextCompat.getColor(this, R.color.error));
        }
    }
}
