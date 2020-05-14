package com.example.mypersonaltrainer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mypersonaltrainer.ObjectClasses.Constants;
import com.example.mypersonaltrainer.ObjectClasses.User;
import com.google.gson.Gson;

public class WorkoutPrefCollection extends AppCompatActivity {
    private User user;
    private SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_pref_collection);
        final Spinner trainingLocation = findViewById(R.id.spn_trainloc);
        final Spinner workoutType = findViewById(R.id.spn_worktype);
        mPrefs = getSharedPreferences("user_data", Context.MODE_PRIVATE);

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

    public void collectWorkoutPrefs(View view){
        String trainingLocation, workoutType, temp;
        Integer days;
        trainingLocation = ((Spinner) findViewById(R.id.spn_trainloc)).getSelectedItem().toString();
        workoutType = ((Spinner) findViewById(R.id.spn_worktype)).getSelectedItem().toString();
        temp = ((Spinner) findViewById(R.id.spn_workday)).getSelectedItem().toString();
        days = Integer.valueOf(temp);
        Gson gson = new Gson();
        String json = mPrefs.getString("user", "User not found");
        user = gson.fromJson(json, User.class);
        user.setTrainingLocation(trainingLocation);
        user.setWorkoutType(workoutType);
        user.setDays(days);
        user.setTdee(user.calculateTDEE());
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        json = gson.toJson(user); // myObject - instance of MyObject
        prefsEditor.putString("user", json);
        prefsEditor.commit();
        Intent i = new Intent(this, MuscleFocus.class);
        startActivity(i);
    }

    public void returnToBioCollec(View view){
        finish();
    }

}
