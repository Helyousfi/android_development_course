package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SyncStatusObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Define some variables
    TextView text;
    Button btnText, btnColor;
    Button goToActivity2;

    int i=0, k=0;
    SharedPreferences sharedPreferences;
    String txt_retrieved;
    String txt_saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show a message when the onCreate method is called
        Log.d("Message","onCreate");

        /*************** CHANGE TEXT VALUE when the same text is clicked **************/
        text = findViewById(R.id.txt);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i%2 == 0) {
                    text.setText("You clicked me !");
                }
                else {
                    text.setText("You unclicked me!");
                }
                i = i + 1;
                System.out.println(i);
            }
        });

        /*************** CHANGE TEXT VALUE when the Button is clicked **************/
        btnText = findViewById(R.id.buttonChangeText);
        btnText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i % 2 == 0) {
                    text.setText("Button 1 Clicked!");
                }
                else
                {
                    text.setText("Button 1 uncklicked");
                }
                i = i + 1;
            }});

        btnColor = findViewById(R.id.buttonChangeColor);
        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (k == 0)
                {
                    text.setTextColor(Color.RED);
                }
                else
                {
                    text.setTextColor(Color.BLUE);
                }
                k = (k + 1) % 2;
            }
        });
        /*************** Go to the second activity **************/
        goToActivity2 = findViewById(R.id.goToActivity2);
        goToActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), scndActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onPause() {
        save_data();
        super.onPause();
    }

    public void save_data(){
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        txt_saved = text.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key_name", txt_saved);
        editor.commit();
    }

    @Override
    public void onResume() {
        retrieveData();
        super.onResume();
    }

    public void retrieveData(){
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        txt_retrieved = sharedPreferences.getString("key_name", null);
        text.setText(txt_retrieved);
    }



}