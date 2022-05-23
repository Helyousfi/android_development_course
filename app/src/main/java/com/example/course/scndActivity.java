package com.example.course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scndActivity extends AppCompatActivity {

    // Name the variables for the widgets
    Button goToActivity1;
    Button increaseCounter;
    TextView textCounter;

    int count = 0;

    // Saving & loading the data
    String counterValue;
    String counterValueRetrieved;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scnd);

        goToActivity1 = findViewById(R.id.goToActivity1);
        goToActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        increaseCounter = findViewById(R.id.btnCounter);
        increaseCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textCounter = findViewById(R.id.nbrCountTxt);
                textCounter.setText("" + count);
                count += 1;
            }
        });
    }

    @Override
    protected void onPause() {
        saveData();
        super.onPause();
    }

    public void saveData(){
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        counterValue = textCounter.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("counterValue", counterValue);
        editor.commit();
    }

    @Override
    public void onResume() {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        counterValueRetrieved = sharedPreferences.getString("counterValue", null);
        textCounter.setText(counterValueRetrieved);

        super.onResume();
    }

}