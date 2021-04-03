package com.example.assignmentone_countingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ZeroActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zero);
    }
    public void Next(View view)
    {
        Intent intent = new Intent(this, OneActivity.class);
        startActivity(intent);
    }
    public void Previous(View view)
    {
        Intent intent = new Intent(this, NineActivity.class);
        startActivity(intent);
    }

    public void PlayAudio(View view) {
        ImageView img = findViewById(R.id.imageView);
        img.animate().translationYBy(-100).setDuration(1000);
        img.animate().translationYBy(100).setDuration(1000);
        mp = MediaPlayer.create(this,R.raw.zero);
        mp.start();
    }
}