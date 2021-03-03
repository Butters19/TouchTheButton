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
    ClickModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = new ClickModel();
        setContentView(R.layout.activity_main);

        findViewById(R.id.info_Button).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putStringArrayListExtra("key", model.list);
            startActivity(intent);
        });

        findViewById(R.id.result_Button).setOnClickListener(v -> {
            model.list.add(getCurrentDate());
            setValueToFiled(findViewById(R.id.counterTitle),"Count of click:");
            setValueToFiled(findViewById(R.id.counterTextView),String.valueOf(model.list.size()));
            setValueToFiled(findViewById(R.id.lastDateTitle),"Last click date:");
            setValueToFiled(findViewById(R.id.lastDateValue),String.valueOf(model.list.get(model.list.size() - 1)));
        });
    }

    public void setValueToFiled(TextView view, String value){
        view.setVisibility(View.VISIBLE);
        view.setText(value);
    }

    public String getCurrentDate(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S").format( new Date().getTime());
    }
}