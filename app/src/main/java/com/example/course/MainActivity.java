package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SyncStatusObserver;
import android.graphics.Color;
import android.os.Bundle;
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

        // CHANGE TEXT VALUE
        text = findViewById(R.id.txt);
        text.setText("Welcome to your app");
        text.setTextColor(Color.BLUE);

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

        // Change text value using button
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i % 2 == 0)
                {
                text.setText("Button 1 Clicked!");
                }
                else
                {
                    text.setText("Button 1 uncklicked");
                }
                i = i + 1;

            }
        });






    }
}