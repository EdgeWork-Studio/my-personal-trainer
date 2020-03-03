package com.example.mypersonaltrainer;

import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        if(isSignedIn()){
            goToSetup1(getCurrentFocus());
        }
        else goToBioCollec();
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
        Intent i = new Intent(this, Setup1.class);
        startActivity(i);
    }

    private boolean isSignedIn(){
        return GoogleSignIn.getLastSignedInAccount(getApplicationContext()) != null;
    }

}
