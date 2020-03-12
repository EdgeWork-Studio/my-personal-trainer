package com.example.mypersonaltrainer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.mypersonaltrainer.ObjectClasses.User;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.gson.Gson;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home extends AppCompatActivity {
    private SharedPreferences mPrefs;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if(isSignedIn()){
            mPrefs = getSharedPreferences("user_data", Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String json = mPrefs.getString("user", "user not found");
            if(json.equals("user not found")) goToBioCollec();
            else{
                user = gson.fromJson(json, User.class);
                TextView tv = findViewById(R.id.textView2);
                tv.setText(user.toString());
            }
        }
        else goToSignIn(getCurrentFocus());
    }


    public void goToSignIn(View view){
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }

    private void goToBioCollec(){
        Intent i = new Intent(this, BiometricCollection.class);
        startActivity(i);
    }

    public void goToSetup1(View view){
        Intent i = new Intent(this, WorkoutPrefCollection.class);
        startActivity(i);
    }

    private boolean isSignedIn(){
        return GoogleSignIn.getLastSignedInAccount(getApplicationContext()) != null;
    }

}
