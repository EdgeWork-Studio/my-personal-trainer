package com.example.mypersonaltrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mypersonaltrainer.ObjectClasses.User;
import com.example.mypersonaltrainer.ObjectClasses.Workout;
import com.google.gson.Gson;

public class WorkoutScreen extends AppCompatActivity {

    private SharedPreferences mPrefs;
    private User user;

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
            ArrayAdapter<Workout> arrayAdapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, user.getRoutine());
            lv.setAdapter(arrayAdapter);
        }
    }

    private void goToBioCollec(){
        Intent i = new Intent(this, BiometricCollection.class);
        startActivity(i);
    }
}
