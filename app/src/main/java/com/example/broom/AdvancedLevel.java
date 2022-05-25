package com.example.broom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Random;

public class AdvancedLevel extends AppCompatActivity {

    EditText guessEditCar1; //edit text to input the answer 1 according to image1
    EditText guessEditCar2; //edit text to input the answer 1 according to image2
    EditText guessEditCar3; //edit text to input the answer 1 according to image3
    ImageView carImage1AD;  //image view according to random number1
    ImageView carImage2AD;  //image view according to random number2
    ImageView carImage3AD;  //image view according to random number3
    TextView guessRealText1; //Text view to display if answer 1 is wrong
    TextView guessRealText2; //Text view to display if answer 1 is wrong
    TextView guessRealText3; //Text view to display if answer 1 is wrong
    TextView scoreText; //text view to display score
    TextView correctionText4; //text view to show wrong or correct
    Button submitBtn4; //submit button
    Random random4;
    TypedArray Imgs4; //array to get the recourses from image string array
    String valueCarImage1AD; //value according to the random generate image 1
    String valueCarImage2AD; //value according to the random generate image 2
    String valueCarImage3AD;//value according to the random generate image 3
    String inputValueEdit1; //the answer 1 that user has input
    String inputValueEdit2; //the answer 2 that user has input
    String inputValueEdit3; //the answer 2 that user has input
    int countAd = 0; // to count how many times that user has press submit button
    int scorePoints = 0; // to count that user has scored

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_level);

        guessEditCar1 = (EditText) findViewById(R.id.image1EditText);
        guessEditCar2 = (EditText) findViewById(R.id.image2EditText);
        guessEditCar3 = (EditText) findViewById(R.id.image3EditText);
        carImage1AD = (ImageView) findViewById(R.id.imageAdvanced1);
        carImage2AD = (ImageView) findViewById(R.id.imageAdvanced2);
        carImage3AD = (ImageView) findViewById(R.id.imageAdvanced3);
        guessRealText1 = (TextView) findViewById(R.id.image1RealText);
        guessRealText2 = (TextView) findViewById(R.id.image2RealText);
        guessRealText3 = (TextView) findViewById(R.id.image3RealText);
        scoreText = (TextView) findViewById(R.id.ScoreAdvanced);
        correctionText4 = (TextView) findViewById(R.id.correctionAdvanced);
        submitBtn4 = findViewById(R.id.submitAdvanced);
        Imgs4 = getResources().obtainTypedArray(R.array.Imgs);
        random4 = new Random();

        int randNum1 = random4.nextInt(10 - 1) + 1; //random number generator to generate number between 1 and 10
        carImage1AD.setBackgroundResource(Imgs4.getResourceId(randNum1, 1));

        int randNum2 = random4.nextInt(20 - 11) + 11; //random number generator to generate number between 11 and 20
        carImage2AD.setBackgroundResource(Imgs4.getResourceId(randNum2, 11));

        int randNum3 = random4.nextInt(30 - 21) + 21; //random number generator to generate number between 21 and 30
        carImage3AD.setBackgroundResource(Imgs4.getResourceId(randNum3, 21));

        //hashmap to compare answers
        HashMap<String, String> map2 = new HashMap<String, String>();

        map2.put(String.valueOf(R.drawable.bmw1), "BMW");
        map2.put(String.valueOf(R.drawable.bmw2), "BMW");
        map2.put(String.valueOf(R.drawable.bmw3), "BMW");
        map2.put(String.valueOf(R.drawable.bmw4), "BMW");
        map2.put(String.valueOf(R.drawable.bmw5), "BMW");
        map2.put(String.valueOf(R.drawable.bmw6), "BMW");
        map2.put(String.valueOf(R.drawable.bmw7), "BMW");
        map2.put(String.valueOf(R.drawable.bmw8), "BMW");
        map2.put(String.valueOf(R.drawable.bmw9), "BMW");
        map2.put(String.valueOf(R.drawable.bmw10), "BMW");
        map2.put(String.valueOf(R.drawable.ferrari1), "FERRARI");
        map2.put(String.valueOf(R.drawable.ferrari2), "FERRARI");
        map2.put(String.valueOf(R.drawable.ferrari3), "FERRARI");
        map2.put(String.valueOf(R.drawable.ferrari4), "FERRARI");
        map2.put(String.valueOf(R.drawable.ferrari5), "FERRARI");
        map2.put(String.valueOf(R.drawable.ford1), "FORD");
        map2.put(String.valueOf(R.drawable.ford2), "FORD");
        map2.put(String.valueOf(R.drawable.ford3), "FORD");
        map2.put(String.valueOf(R.drawable.ford4), "FORD");
        map2.put(String.valueOf(R.drawable.ford5), "FORD");
        map2.put(String.valueOf(R.drawable.porsche1), "PORSCHE");
        map2.put(String.valueOf(R.drawable.porsche2), "PORSCHE");
        map2.put(String.valueOf(R.drawable.porsche3), "PORSCHE");
        map2.put(String.valueOf(R.drawable.porsche4), "PORSCHE");
        map2.put(String.valueOf(R.drawable.porsche5), "PORSCHE");
        map2.put(String.valueOf(R.drawable.toyota1), "TOYOTA");
        map2.put(String.valueOf(R.drawable.toyota2), "TOYOTA");
        map2.put(String.valueOf(R.drawable.toyota3), "TOYOTA");
        map2.put(String.valueOf(R.drawable.toyota4), "TOYOTA");
        map2.put(String.valueOf(R.drawable.toyota5), "TOYOTA");

        valueCarImage1AD = map2.get(String.valueOf(Imgs4.getResourceId(randNum1, 1)));
        valueCarImage2AD = map2.get(String.valueOf(Imgs4.getResourceId(randNum2, 11)));
        valueCarImage3AD = map2.get(String.valueOf(Imgs4.getResourceId(randNum3, 21)));

        submitBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countAd++;
                inputValueEdit1 = guessEditCar1.getText().toString().toUpperCase();
                inputValueEdit2 = guessEditCar2.getText().toString().toUpperCase();
                inputValueEdit3 = guessEditCar3.getText().toString().toUpperCase();

                if(inputValueEdit1.isEmpty() || inputValueEdit2.isEmpty() || inputValueEdit3.isEmpty()){
                    countAd--;
                    Toast.makeText(getApplicationContext(),"Fill all fields",Toast.LENGTH_SHORT).show();
                }

                else {
                    //if submit button has pressed 3 times
                    if (countAd == 3) {

                        if (valueCarImage1AD.equals(inputValueEdit1) && valueCarImage2AD.equals(inputValueEdit2) && valueCarImage3AD.equals(inputValueEdit3)) {
                            scorePoints = 3;
                            correctionText4.setText("CORRECT!");
                            correctionText4.setBackgroundColor(getResources().getColor(R.color.green));
                            scoreText.setText("SCORE " + scorePoints);
                            refresh();
                        } else if (valueCarImage1AD.equals(inputValueEdit1) && valueCarImage2AD.equals(inputValueEdit2)) {
                            scorePoints = 2;
                            correctionText4.setText("WRONG!");
                            correctionText4.setBackgroundColor(getResources().getColor(R.color.red));
                            scoreText.setText("SCORE " + scorePoints);
                            guessRealText3.setText(valueCarImage3AD);
                            guessRealText3.setBackgroundColor(getResources().getColor(R.color.yellow));
                            refresh();
                        } else if (valueCarImage1AD.equals(inputValueEdit1) && valueCarImage3AD.equals(inputValueEdit3)) {
                            scorePoints = 2;
                            correctionText4.setText("WRONG!");
                            correctionText4.setBackgroundColor(getResources().getColor(R.color.red));
                            scoreText.setText("SCORE " + scorePoints);
                            guessRealText2.setText(valueCarImage2AD);
                            guessRealText2.setBackgroundColor(getResources().getColor(R.color.yellow));
                            refresh();
                        } else if (valueCarImage2AD.equals(inputValueEdit2) && valueCarImage3AD.equals(inputValueEdit3)) {
                            scorePoints = 2;
                            correctionText4.setText("WRONG!");
                            correctionText4.setBackgroundColor(getResources().getColor(R.color.red));
                            scoreText.setText("SCORE " + scorePoints);
                            guessRealText1.setText(valueCarImage1AD);
                            guessRealText1.setBackgroundColor(getResources().getColor(R.color.yellow));
                            refresh();
                        } else if (valueCarImage1AD.equals(inputValueEdit1)) {
                            scorePoints = 1;
                            correctionText4.setText("WRONG!");
                            correctionText4.setBackgroundColor(getResources().getColor(R.color.red));
                            scoreText.setText("SCORE " + scorePoints);
                            guessRealText2.setText(valueCarImage2AD);
                            guessRealText2.setBackgroundColor(getResources().getColor(R.color.yellow));
                            guessRealText3.setText(valueCarImage3AD);
                            guessRealText3.setBackgroundColor(getResources().getColor(R.color.yellow));
                            refresh();
                        } else if (valueCarImage2AD.equals(inputValueEdit2)) {
                            scorePoints = 1;
                            correctionText4.setText("WRONG!");
                            correctionText4.setBackgroundColor(getResources().getColor(R.color.red));
                            scoreText.setText("SCORE " + scorePoints);
                            guessRealText1.setText(valueCarImage1AD);
                            guessRealText1.setBackgroundColor(getResources().getColor(R.color.yellow));
                            guessRealText3.setText(valueCarImage3AD);
                            guessRealText3.setBackgroundColor(getResources().getColor(R.color.yellow));
                            refresh();
                        } else if (valueCarImage3AD.equals(inputValueEdit3)) {
                            scorePoints = 1;
                            correctionText4.setText("WRONG!");
                            correctionText4.setBackgroundColor(getResources().getColor(R.color.red));
                            scoreText.setText("SCORE " + scorePoints);
                            guessRealText1.setText(valueCarImage1AD);
                            guessRealText1.setBackgroundColor(getResources().getColor(R.color.yellow));
                            guessRealText2.setText(valueCarImage2AD);
                            guessRealText2.setBackgroundColor(getResources().getColor(R.color.yellow));
                            refresh();
                        } else {
                            scorePoints = 0;
                            correctionText4.setText("WRONG!");
                            correctionText4.setBackgroundColor(getResources().getColor(R.color.red));
                            scoreText.setText("SCORE " + scorePoints);
                            guessRealText1.setText(valueCarImage1AD);
                            guessRealText1.setBackgroundColor(getResources().getColor(R.color.yellow));
                            guessRealText2.setText(valueCarImage2AD);
                            guessRealText2.setBackgroundColor(getResources().getColor(R.color.yellow));
                            guessRealText3.setText(valueCarImage3AD);
                            guessRealText3.setBackgroundColor(getResources().getColor(R.color.yellow));
                            refresh();
                        }
                    } else {

                        //if all answers are correct
                        if (valueCarImage1AD.equals(inputValueEdit1) && valueCarImage2AD.equals(inputValueEdit2) && valueCarImage3AD.equals(inputValueEdit3)) {
                            scorePoints = 3;
                            guessEditCar1.setEnabled(false);
                            guessEditCar1.setBackgroundColor(getResources().getColor(R.color.green));
                            guessEditCar2.setEnabled(false);
                            guessEditCar2.setBackgroundColor(getResources().getColor(R.color.green));
                            guessEditCar3.setEnabled(false);
                            guessEditCar3.setBackgroundColor(getResources().getColor(R.color.green));
                            correctionText4.setText("CORRECT!");
                            correctionText4.setBackgroundColor(getResources().getColor(R.color.green));
                            scoreText.setText("SCORE " + scorePoints);
                            refresh();
                        } else if (valueCarImage1AD.equals(inputValueEdit1) && valueCarImage2AD.equals(inputValueEdit2)) {
                            //if answer 1 and 2 correct
                            guessEditCar1.setEnabled(false);
                            guessEditCar1.setBackgroundColor(getResources().getColor(R.color.green));
                            guessEditCar2.setEnabled(false);
                            guessEditCar2.setBackgroundColor(getResources().getColor(R.color.green));
                            guessEditCar3.setBackgroundColor(getResources().getColor(R.color.red));
                        } else if (valueCarImage1AD.equals(inputValueEdit1) && valueCarImage3AD.equals(inputValueEdit3)) {
                            //if answer 1 and 3 correct
                            guessEditCar1.setEnabled(false);
                            guessEditCar1.setBackgroundColor(getResources().getColor(R.color.green));
                            guessEditCar2.setBackgroundColor(getResources().getColor(R.color.red));
                            guessEditCar3.setEnabled(false);
                            guessEditCar3.setBackgroundColor(getResources().getColor(R.color.green));
                        } else if (valueCarImage2AD.equals(inputValueEdit2) && valueCarImage3AD.equals(inputValueEdit3)) {
                            //if answer 2 and 3 correct
                            guessEditCar1.setBackgroundColor(getResources().getColor(R.color.red));
                            guessEditCar2.setEnabled(false);
                            guessEditCar2.setBackgroundColor(getResources().getColor(R.color.green));
                            guessEditCar3.setEnabled(false);
                            guessEditCar3.setBackgroundColor(getResources().getColor(R.color.green));
                        } else if (valueCarImage1AD.equals(inputValueEdit1)) {
                            //if answer 1 correct
                            guessEditCar1.setEnabled(false);
                            guessEditCar1.setBackgroundColor(getResources().getColor(R.color.green));
                            guessEditCar2.setBackgroundColor(getResources().getColor(R.color.red));
                            guessEditCar3.setBackgroundColor(getResources().getColor(R.color.red));
                        } else if (valueCarImage2AD.equals(inputValueEdit2)) {
                            //if answer 2 correct
                            guessEditCar1.setBackgroundColor(getResources().getColor(R.color.red));
                            guessEditCar2.setEnabled(false);
                            guessEditCar2.setBackgroundColor(getResources().getColor(R.color.green));
                            guessEditCar3.setBackgroundColor(getResources().getColor(R.color.red));
                        } else if (valueCarImage3AD.equals(inputValueEdit3)) {
                            //if answer 3 correct
                            guessEditCar1.setBackgroundColor(getResources().getColor(R.color.red));
                            guessEditCar2.setBackgroundColor(getResources().getColor(R.color.red));
                            guessEditCar3.setEnabled(false);
                            guessEditCar3.setBackgroundColor(getResources().getColor(R.color.green));
                        } else {
                            guessEditCar1.setBackgroundColor(getResources().getColor(R.color.red));
                            guessEditCar2.setBackgroundColor(getResources().getColor(R.color.red));
                            guessEditCar3.setBackgroundColor(getResources().getColor(R.color.red));
                        }
                    }
                }

            }
        });
    }

    void refresh() {
        submitBtn4.setText("Next");
        submitBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }


}