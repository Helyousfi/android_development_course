package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button btn;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Message","onCreate");

        // CHANGE TEXT VALUE when the same text is clicked
        text = findViewById(R.id.txt);
        text.setText("Welcome to your app");
        text.setTextColor(Color.BLUE);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {if(i%2 == 0) {text.setText("You clicked me !");}
                else {text.setText("You unclicked me!");}
                i = i + 1;
                System.out.println(i);
            }
        });

        // Change text value using button
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i % 2 == 0) {text.setText("Button 1 Clicked!");}
                else {text.setText("Button 1 uncklicked");}
                i = i + 1;
            }});

        // Get the button "Go to second activity"
        Button goToActivity2;
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
    protected void onStart() {
        super.onStart();
        Log.d("Info Message", "On start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Message :", "On resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Message :", "On destroy");
    }



}