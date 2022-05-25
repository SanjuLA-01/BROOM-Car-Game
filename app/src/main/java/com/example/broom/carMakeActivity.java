package com.example.broom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Random;


public class carMakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_make);

        TextView correction = findViewById(R.id.answerText); //showing wrong or correct
        TextView correctionAnswer = findViewById(R.id.CorrectAnswerText); //if answer is wrong this shows the correct answer

        TypedArray Imgs = getResources().obtainTypedArray(R.array.Imgs); //getting rage array to array esources from im
        ImageView carImage = (ImageView) findViewById(R.id.carImages); //image view to show the random image

        Random random = new Random(); //random number generator to generate number between 1 and 30
        int randNum = random.nextInt(30) + 1;
        carImage.setBackgroundResource(Imgs.getResourceId(randNum, 1)); //according to that number taking image from the array and set it to background


        Spinner spinner = findViewById(R.id.spinnerSelect); //spinner to select car brand
        //get resources brand from string array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(carMakeActivity.this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.Brands));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //hashmap to compare answers
        HashMap<String, String> map = new HashMap<String, String>();

        map.put(String.valueOf(R.drawable.bmw1), "BMW");
        map.put(String.valueOf(R.drawable.bmw2), "BMW");
        map.put(String.valueOf(R.drawable.bmw3), "BMW");
        map.put(String.valueOf(R.drawable.bmw4), "BMW");
        map.put(String.valueOf(R.drawable.bmw5), "BMW");
        map.put(String.valueOf(R.drawable.bmw6), "BMW");
        map.put(String.valueOf(R.drawable.bmw7), "BMW");
        map.put(String.valueOf(R.drawable.bmw8), "BMW");
        map.put(String.valueOf(R.drawable.bmw9), "BMW");
        map.put(String.valueOf(R.drawable.bmw10), "BMW");
        map.put(String.valueOf(R.drawable.ferrari1), "FERRARI");
        map.put(String.valueOf(R.drawable.ferrari2), "FERRARI");
        map.put(String.valueOf(R.drawable.ferrari3), "FERRARI");
        map.put(String.valueOf(R.drawable.ferrari4), "FERRARI");
        map.put(String.valueOf(R.drawable.ferrari5), "FERRARI");
        map.put(String.valueOf(R.drawable.ford1), "FORD");
        map.put(String.valueOf(R.drawable.ford2), "FORD");
        map.put(String.valueOf(R.drawable.ford3), "FORD");
        map.put(String.valueOf(R.drawable.ford4), "FORD");
        map.put(String.valueOf(R.drawable.ford5), "FORD");
        map.put(String.valueOf(R.drawable.porsche1), "PORSCHE");
        map.put(String.valueOf(R.drawable.porsche2), "PORSCHE");
        map.put(String.valueOf(R.drawable.porsche3), "PORSCHE");
        map.put(String.valueOf(R.drawable.porsche4), "PORSCHE");
        map.put(String.valueOf(R.drawable.porsche5), "PORSCHE");
        map.put(String.valueOf(R.drawable.toyota1), "TOYOTA");
        map.put(String.valueOf(R.drawable.toyota2), "TOYOTA");
        map.put(String.valueOf(R.drawable.toyota3), "TOYOTA");
        map.put(String.valueOf(R.drawable.toyota4), "TOYOTA");
        map.put(String.valueOf(R.drawable.toyota5), "TOYOTA");

        Button identifyBtn = findViewById(R.id.buttonIdentify); //button to identify the correct answer and for the next process
        identifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = map.get(String.valueOf(Imgs.getResourceId(randNum, 1))); //value of that taken from the hashmap according to the random image
                String carBrandSpinner = spinner.getSelectedItem().toString();

                if (value.equals(carBrandSpinner)) {

                    correction.setText("CORRECT!"); //if answer is correct
                    correction.setTextColor(getResources().getColor(R.color.green));


                    identifyBtn.setText("Next"); //for the next process refresh the intent
                    identifyBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });

                } else {

                    correction.setText("WRONG!"); //if answer is wrong
                    correction.setTextColor(getResources().getColor(R.color.red));

                    correctionAnswer.setText(value); //showing the correct answer
                    correctionAnswer.setTextColor(getResources().getColor(R.color.yellow));

                    identifyBtn.setText("Next"); //for the next process refresh the intent
                    identifyBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    });

                }

            }
        });
    }

    //https://www.youtube.com/watch?v=on_OrrX7Nw4
    //https://www.youtube.com/watch?v=Pfee0wFD5M0&t=365s

}