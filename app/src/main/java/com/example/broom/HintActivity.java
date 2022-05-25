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
import java.util.HashMap;
import java.util.Random;

public class HintActivity extends AppCompatActivity {

    char[] wordRandomSelected; //char array to store to selected random car brand according to image
    TextView wordToGuess; //to show the underscope and guess letters
    Button submitBtn; //button to submit the guess letter
    EditText editText; //edit text to input the letter
    String value2; //value of that taken from the hashmap according to the random image
    String guessWordDisplay;  //to input the string value of random selected word
    String inputValue; //to store the input letter
    TextView correctionHint;//showing correct or wrong
    TextView carBrand; //if answer is wrong showing the correct brand
    int count = 0; //to count how many times that user press the submit button with incorrect letters

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint);

        wordToGuess = (TextView) findViewById(R.id.textGuessHint);
        submitBtn = findViewById(R.id.SubmitButtonHint);
        editText = (EditText) findViewById(R.id.answerInputHint);
        correctionHint = (TextView) findViewById(R.id.hintCorrectionText);
        carBrand=(TextView) findViewById(R.id.carBrandTextHint);

        TypedArray Imgs2 = getResources().obtainTypedArray(R.array.Imgs); //getting recources array to array from imgs
        ImageView carImage2 = (ImageView) findViewById(R.id.hintRandomImage);//image view to show the random image

        Random random2 = new Random(); //random number generator to generate number between 1 and 30
        int randNum2 = random2.nextInt(30) + 1;
        carImage2.setBackgroundResource(Imgs2.getResourceId(randNum2, 1));//according to that number taking image from the array and set it to background

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

        value2 = map2.get(String.valueOf(Imgs2.getResourceId(randNum2, 1)));

        showScope();
    }

    void showScope() {
        wordRandomSelected = value2.toCharArray();

        //displaying underscope according to the letters that in random selected word
        for (int i = 0; i < wordRandomSelected.length; i++) {
            wordRandomSelected[i] = '_';
        }

        display();

        guessWordDisplay = String.valueOf(wordRandomSelected);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                inputValue = editText.getText().toString().toUpperCase();

                if (value2.indexOf(inputValue) >= 0) {
                    //if value 2 contains the inputValue

                    if (guessWordDisplay.indexOf(inputValue) < 0) {
                        //if not guessWordDisplay contains inputValue

                        revealLetter(inputValue);
                        display();
                        editText.setText("");

                        if(guessWordDisplay.equals(value2)){
                            //if all guess corrects
                            correctionHint.setText("CORRECT!");
                            correctionHint.setTextColor(getResources().getColor(R.color.green));
                            refresh();
                        }
                    }
                }

                if (!(value2.contains(inputValue))) {
                    count++;

                    editText.setText("");

                    if (count == 3) {
                        correctionHint.setText("WRONG!"); //display wrong if 3 guessings are correct
                        correctionHint.setTextColor(getResources().getColor(R.color.red));
                        carBrand.setText(value2);
                        carBrand.setTextColor(getResources().getColor(R.color.yellow));
                        refresh();
                    }
                }
            }
        });
    }

    void refresh(){
        //refresh the intent
        submitBtn.setText("NEXT");
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
    }


    void display() {
        //display word with space
        String displayString = "";
        for (char letters : wordRandomSelected) {
            displayString += letters + " ";
        }
        wordToGuess.setText(displayString);
    }

    void revealLetter(String letter) {
        //if answer input letter in the correct word, this will catch the all letters relevant to that letter and put them

        int indexOfLetter = value2.indexOf(letter);

        while (indexOfLetter >= 0) {
            wordRandomSelected[indexOfLetter] = value2.charAt(indexOfLetter);
            indexOfLetter = value2.indexOf(letter, indexOfLetter + 1);
        }

        guessWordDisplay = String.valueOf(wordRandomSelected);
    }

    //https://www.youtube.com/watch?v=HgH1DfH14uk&list=PLgTkNlNsy9gVCkeaoudJJWr4P3Gc-AV7f

}