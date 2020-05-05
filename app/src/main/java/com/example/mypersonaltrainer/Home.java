package com.example.mypersonaltrainer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    private SharedPreferences mPrefs;
    private User user;
    private GoogleSignInClient gsc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken(getString(R.string.default_web_client_id)).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);
        if(isSignedIn()){
            ImageButton ib = findViewById(R.id.btn_profile);
            ImageButton ib2 = findViewById(R.id.btn_full_workout);
            ib.setVisibility(View.VISIBLE);
            ib2.setVisibility(View.VISIBLE);
            mPrefs = getSharedPreferences("user_data", Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String json = mPrefs.getString("user", "user not found");
            if(json.equals("user not found")) goToBioCollec();
            else{
                user = gson.fromJson(json, User.class);
                if(user.getMuscleFocus() == null) goToBioCollec();
                else{
                    ArrayList<Workout> workout = user.getRoutine();
                    if(workout==null){
                        WorkoutGenerator wg = new WorkoutGenerator(getApplicationContext());
                        getResources().openRawResource(R.raw.exercises);
                        workout = wg.getRoutine(user.getDays(), user.getTrainingLocation(), user.getMuscleFocus());
                        user.setRoutine(workout);
                    }
                }
                TextView tv = findViewById(R.id.val_rci);
                String tdee = "~" + user.getTdee();
                tv.setText(tdee);
            }
        }
        else goToSignIn();
    }
    @Override
    public void onResume(){
        super.onResume();
        if(isSignedIn()) {
            String json = mPrefs.getString("user", "user not found");
            if(json.equals("user not found")) goToBioCollec();
            else {
                ListView lv = findViewById(R.id.list_curr_workout);
                ArrayAdapter<Workout> arrayAdapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, user.getRoutine());
                lv.setAdapter(arrayAdapter);
                TextView tv = findViewById(R.id.val_rci);
                String tdee = "~" + user.getTdee();
                tv.setText(tdee);
            }
        }
    }

    public void clearPrefs(View view){
        mPrefs.edit().remove("user").commit();
        goToBioCollec();
    }

    public void goToProfile(View view){
        Intent i = new Intent(this, Profile.class);
        startActivity(i);
    }

    private void goToSignIn(){
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }

    private void goToBioCollec(){
        Intent i = new Intent(this, BiometricCollection.class);
        startActivity(i);
    }

    private boolean isSignedIn(){
        return GoogleSignIn.getLastSignedInAccount(getApplicationContext()) != null;
    }

    public void goToWorkoutScreen(View view){
        Intent i = new Intent(this, WorkoutScreen.class);
        startActivity(i);
    }


}
