package com.example.mypersonaltrainer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Setup1 extends AppCompatActivity {

    private final String GYM = "Gym";
    private final String BODY = "Body Weight";
    private final String FREE = "Free Weights";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup1);
        final Spinner trainingLocation = (Spinner)findViewById(R.id.spn_trainloc);
        final Spinner workoutType = findViewById(R.id.spn_worktype);
        final Spinner workoutDays = findViewById(R.id.spn_workday);

        trainingLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String sel1 = trainingLocation.getSelectedItem().toString();
                String[] types = null;
                switch (sel1){
                    case GYM:
                        types = getResources().getStringArray(R.array.gym_options);
                        break;
                    case BODY:
                        types = getResources().getStringArray(R.array.body_options);
                        break;
                    case FREE:
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
                String sel1 = trainingLocation.getSelectedItem().toString();
                String[] days = null;
                switch (sel1){
                    case GYM:
                        days = getResources().getStringArray(R.array.gym_options);
                        break;
                    case BODY:
                        days = getResources().getStringArray(R.array.body_options);
                        break;
                    case FREE:
                        days = getResources().getStringArray(R.array.free_options);
                        break;
                }
                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, days); //selected item will look like a spinner set from XML
                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                workoutType.setAdapter(spinnerArrayAdapter);

            }
            public void onNothingSelected(AdapterView<?> adapterView) { return; }
        });
    }

}
