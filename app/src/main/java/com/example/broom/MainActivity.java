package com.example.broom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button carMakeBtn = findViewById(R.id.button_Make); //button to go to Identify The Car Make activity
        carMakeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carMake();
            }
        });

        Button hintBtn = findViewById(R.id.button_Hint); //button to go to Hints activity
        hintBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hint();
            }
        });

        Button carImageIdentifyBtn = findViewById(R.id.button_Image); //button to go to Identify the Car Image activity
        carImageIdentifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carImageIdentify();
            }
        });

        Button advancedLevelBtn= findViewById(R.id.button_Advanced); //button to go to Advanced Level activity
        advancedLevelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                advancedLevel();
            }
        });

    }

    private void carMake() {
        Intent intent = new Intent(this, carMakeActivity.class); //making new intent and go to identify the car make activity
        startActivity(intent);
    }

    private void hint() {
        Intent intent = new Intent(this, HintActivity.class); //making new intent and go to hint activity
        startActivity(intent);
    }

    private void carImageIdentify() {
        Intent intent = new Intent(this, carIdentifyImage.class); //making new intent and go to identify the car image activity
        startActivity(intent);
    }

    private void advancedLevel(){
        Intent intent = new Intent(this, AdvancedLevel.class); //making new intent and go to advanced level activity
        startActivity(intent);
    }
}