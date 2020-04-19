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

import com.google.firebase.auth.FirebaseAuth;

import com.example.mypersonaltrainer.ObjectClasses.User;
import com.google.gson.Gson;

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
        Integer age;
        Double weight, height, bodyfat;
        Boolean man;
        man = ((RadioButton) findViewById(R.id.radio_male)).isChecked();
        activityLevel = ((Spinner) findViewById(R.id.spn_activity)).getSelectedItem().toString();
        experience = ((Spinner) findViewById(R.id.spn_experience)).getSelectedItem().toString();
        temp = ((TextView) findViewById(R.id.input_age)).getText().toString();
        age = Integer.valueOf(temp);
        temp = ((TextView) findViewById(R.id.input_weight)).getText().toString();
        weight = Double.valueOf(temp);
        if(((RadioButton) findViewById(R.id.radio_pounds)).isChecked()) weight = weight * 0.45359239;
        temp = ((TextView) findViewById(R.id.input_height)).getText().toString();
        height = Double.valueOf(temp);
        if(((RadioButton) findViewById(R.id.radio_inches)).isChecked()) height = height * 2.54;
        temp = ((TextView) findViewById(R.id.input_body_fat)).getText().toString();
        if(!temp.equals(""))
            bodyfat = Double.valueOf(temp);
        else bodyfat = -1.0;
        goal = ((Spinner) findViewById(R.id.spn_weight_goal)).getSelectedItem().toString();
        User user = new User(mAuth.getCurrentUser(), activityLevel, experience, man, weight, height, bodyfat, age, goal);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        prefsEditor.putString("user", json);
        prefsEditor.commit();
        Intent i = new Intent(this, WorkoutPrefCollection.class);
        startActivity(i);
    }
}
