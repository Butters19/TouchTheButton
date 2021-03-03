package com.example.touchthebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {
    Button button1, btnActTwo;
    ClickModel model;
    TextView counterTitleTextView, counterTextView, lastDateTitleTextView, lastDateValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ClickModel();
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.result_Button);
        btnActTwo = findViewById(R.id.info_Button);
        counterTitleTextView = findViewById(R.id.counterTitle);
        counterTextView = findViewById(R.id.counterTextView);
        lastDateTitleTextView = findViewById(R.id.lastDateTitle);
        lastDateValueTextView = findViewById(R.id.lastDateValue);


        btnActTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putStringArrayListExtra("key", model.list);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.list.add(getCurrentDate());
                counterTitleTextView.setVisibility(View.VISIBLE);
                counterTextView.setVisibility(View.VISIBLE);
                lastDateTitleTextView.setVisibility(View.VISIBLE);
                lastDateValueTextView.setVisibility(View.VISIBLE);
                counterTitleTextView.setText("Count of click:");
                lastDateTitleTextView.setText("Last click date:");
                counterTextView.setText(String.valueOf(model.list.size()));
                lastDateValueTextView.setText(String.valueOf(model.list.get(model.list.size() - 1)));

            }
        });
    }

    public String getCurrentDate(){
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        Date date = new Date();
        date.getTime();
        return formater.format(date);
    }


    public void clickButton(View v) {

    }
}