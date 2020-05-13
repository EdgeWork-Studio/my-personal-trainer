package com.example.mypersonaltrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

    String[] mobileArray = {"Android","IPhone","WindowsMobile","Blackberry",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_screen);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        /*//Toolbar logo
        toolbar.setLogo(R.id.logo);

        //Back Button
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mActionBar.setNavigationIcon(R.id.backarrow);
        mActionBar.setNavigationOnClickListener(onSupportNavigateUp()) {
        @Override
        public boolean onSupportNavigateUp() {
            onBackPressed();
            return true;
        }

            ArrayAdapter adapter = new ArrayAdapter<String>(this,
                    R.layout.activity_listview, mobileArray);

            ListView listView = (ListView) findViewById(R.id.mobile_list);
            listView.setAdapter(adapter);

        mPrefs = getSharedPreferences("user_data", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("user", "user not found");
        if(json.equals("user not found")) goToBioCollec();
        else{
            user = gson.fromJson(json, User.class);
            //ListView lv = findViewById(R.id.list_full_workout);
            //ArrayAdapter<Workout> arrayAdapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, user.getRoutine());
            //lv.setAdapter(arrayAdapter);
        }*/
    }

    private void goToBioCollec(){
        Intent i = new Intent(this, BiometricCollection.class);
        startActivity(i);
    }
}
