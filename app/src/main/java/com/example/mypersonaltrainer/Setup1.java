package com.example.mypersonaltrainer;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class Setup1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup1);

        final Spinner spnLocale = (Spinner)findViewById(R.id.spinner);

        spnLocale.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Spinner spinner = findViewById(R.id.spinner2);
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }

}
