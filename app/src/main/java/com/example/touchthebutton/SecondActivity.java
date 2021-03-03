package com.example.touchthebutton;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView listView = (ListView) findViewById(R.id.lvMain);

        Bundle arguments = getIntent().getExtras();
        if(arguments!=null) {
            ArrayList<String> list1 = (ArrayList<String>) arguments.get("key");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list1);
            listView.setAdapter(adapter);
        }
    }
}