package com.example.mypersonaltrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mypersonaltrainer.ObjectClasses.Exercise;
import com.example.mypersonaltrainer.ObjectClasses.User;
import com.example.mypersonaltrainer.ObjectClasses.Workout;
import com.google.gson.Gson;

import java.util.ArrayList;

public class WorkoutScreen extends AppCompatActivity {

    private SharedPreferences mPrefs;
    private User user;

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_screen);
        mPrefs = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("user", "user not found");
        if(json.equals("user not found")) goToBioCollec();
        else{
            user = gson.fromJson(json, User.class);
            ListView lv = findViewById(R.id.list_full_workout);
            ArrayList<String> exercises = new ArrayList<>();
            for(Workout w: user.getRoutine()) {
                exercises.add(w.getTitle());
                for (Exercise e : (ArrayList<Exercise>) w.getWorkout()) {
                    if (e == null) exercises.add("add more exercises lazy dev");
                    else
                        exercises.add(e.getSetsAndReps(user.getExperience(), user.getWorkoutType()) + "\t \t \t" + e.getName());
                }
                exercises.add("------------------------------------------------------------------------");
            }
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, exercises);
            lv.setAdapter(arrayAdapter);
        }
    }

    private void goToBioCollec(){
        Intent i = new Intent(this, BiometricCollection.class);
        startActivity(i);
    }

    public void returnToHome(View view){
        finish();
    }
}
