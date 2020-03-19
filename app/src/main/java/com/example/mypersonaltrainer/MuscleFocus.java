package com.example.mypersonaltrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.example.mypersonaltrainer.ObjectClasses.Constants;
import com.example.mypersonaltrainer.ObjectClasses.User;
import com.google.gson.Gson;

public class MuscleFocus extends AppCompatActivity {
    private User user;
    private SharedPreferences mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle_focus);
        mPrefs = getSharedPreferences("user_data", Context.MODE_PRIVATE);
    }

    public void muscleFocusCollection(View view){
        Gson gson = new Gson();
        String json = mPrefs.getString("user", "User not found");
        user = gson.fromJson(json, User.class);
        int radioButtonId = ((RadioGroup) findViewById(R.id.radio_group_muscle_focus)).getCheckedRadioButtonId();
        String muscleFocus;
        switch (radioButtonId){
            case R.id.radio_shoulders: muscleFocus = Constants.SHOULDERS; break;
            case R.id.radio_chest: muscleFocus = Constants.CHEST; break;
            case R.id.radio_arms: muscleFocus = Constants.ARMS; break;
            case R.id.radio_back: muscleFocus = Constants.BACK; break;
            case R.id.radio_abs: muscleFocus = Constants.ABS; break;
            case R.id.radio_butt: muscleFocus = Constants.BUTT; break;
            case R.id.radio_legs: muscleFocus = Constants.LEGS; break;
            default: muscleFocus = Constants.NONE;
        }
        user.setMuscleFocus(muscleFocus);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        json = gson.toJson(user);
        prefsEditor.putString("user", json);
        prefsEditor.commit();
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }
}
