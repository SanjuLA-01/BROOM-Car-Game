package com.example.broom;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class carIdentifyImage extends AppCompatActivity {

    TextView carBrandText; //to display the random selected brand
    TextView correctionText; //to show correct or wrong
    ImageView carImage1; //image view to show tha random select image1
    ImageView carImage2; //image view to show tha random select image2
    ImageView carImage3; //image view to show tha random select image3
    Random random;
    TypedArray Imgs3;//getting recources array to array from imgs
    Button nextBtn; //button to refresh
    String valueCarImage1; //value of that taken from the hashmap according to the random image1
    String valueCarImage2; //value of that taken from the hashmap according to the random image2
    String valueCarImage3; //value of that taken from the hashmap according to the random image3
    ArrayList<String> Brand; //brands input array according to the random selected images
    String selectedBrand; //randomly select brand from the brand array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_identify_image);

        carBrandText = (TextView) findViewById(R.id.carBrandImageText);
        correctionText = (TextView) findViewById(R.id.correctionImageText);
        carImage1 = (ImageView) findViewById(R.id.randImage1);
        carImage2 = (ImageView) findViewById(R.id.randImage2);
        carImage3 = (ImageView) findViewById(R.id.randImage3);
        nextBtn = findViewById(R.id.nextImageBtn);
        Imgs3 = getResources().obtainTypedArray(R.array.Imgs);
        random = new Random();
        Brand = new ArrayList<String>();


        int randNum1 = random.nextInt(10 - 1 ) + 1; //random number generator to generate number between 1 and 10
        carImage1.setBackgroundResource(Imgs3.getResourceId(randNum1, 1));

        int randNum2 = random.nextInt(20 - 11) + 11; //random number generator to generate number between 11 and 20
        carImage2.setBackgroundResource(Imgs3.getResourceId(randNum2, 11));

        int randNum3 = random.nextInt(30 - 21) + 21; //random number generator to generate number between 21 and 30
        carImage3.setBackgroundResource(Imgs3.getResourceId(randNum3, 21));

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

        valueCarImage1 = map2.get(String.valueOf(Imgs3.getResourceId(randNum1, 1)));
        valueCarImage2 = map2.get(String.valueOf(Imgs3.getResourceId(randNum2, 11)));
        valueCarImage3 = map2.get(String.valueOf(Imgs3.getResourceId(randNum3, 21)));

        //input randomly selected values  to the Brand array
        Brand.add(valueCarImage1);
        Brand.add(valueCarImage2);
        Brand.add(valueCarImage3);

        selectedBrand = Brand.get(random.nextInt(3 ));
        carBrandText.setText(selectedBrand);
        carBrandText.setBackgroundColor(getResources().getColor(R.color.yellow));


        carImage1.setOnClickListener(new View.OnClickListener() {
            //event handlers to clickable images
            @Override
            public void onClick(View v) {
                if(valueCarImage1.equals(selectedBrand)){
                    correct();
                }
                else{
                    wrong();
                }
            }
        });

        carImage2.setOnClickListener(new View.OnClickListener() {
            //event handlers to clickable images
            @Override
            public void onClick(View v) {
                if(valueCarImage2.equals(selectedBrand)){
                    correct();
                }
                else{
                    wrong();
                }
            }
        });

        carImage3.setOnClickListener(new View.OnClickListener() {
            //event handlers to clickable images
            @Override
            public void onClick(View v) {
                if(valueCarImage3.equals(selectedBrand)){
                    correct();
                }
                else{
                    wrong();
                }
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
            }
        });

    }

    void correct() //process if user's answer is correct
    {
        correctionText.setText("CORRECT!");
        correctionText.setTextColor(getResources().getColor(R.color.green));
    }

    void wrong(){ //process if user's is wrong
        correctionText.setText("WRONG!");
        correctionText.setTextColor(getResources().getColor(R.color.red));
    }

    void next() { //process according to the next button
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}