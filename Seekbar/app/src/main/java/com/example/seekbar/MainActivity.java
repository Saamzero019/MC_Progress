package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar=findViewById(R.id.seekBar);
        seekBar.setMax(40);
        ListView listView=findViewById(R.id.listView);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int index, boolean fromUser) {
                int tableNumber=index;
                ArrayList<String> list=new ArrayList<String>();
                for(int x=1;x<11;x++){
                    list.add(Integer.toString(x*index));
                }
                ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,list);
                listView.setAdapter(arrayAdapter);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    }
