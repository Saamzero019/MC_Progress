package com.example.listviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
     ArrayList<String> namesList;
    ArrayAdapter<String> arrayAdapter;
    ListView listView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.namesListView);
        editText=findViewById(R.id.fieldNameText);
        namesList=new ArrayList<String>();
        namesList.add("Bravo");
        namesList.add("Charlie");
        namesList.add("Khan");
        namesList.add("test");
        arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,namesList);
        listView.setAdapter(arrayAdapter);

    }

    public void addNameFunc(View view) {
        String name=editText.getText().toString();
        name=name.trim();
        if(!name.isEmpty())
        {
            namesList.add(name);
            Collections.sort(namesList);
            arrayAdapter.notifyDataSetChanged();
            editText.setText("");
        }
    }
}