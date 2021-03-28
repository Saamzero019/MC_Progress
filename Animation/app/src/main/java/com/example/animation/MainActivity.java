package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void animate(View view) {
        ImageView imageView=findViewById(R.id.imageView);
        //imageView.animate().translationXBy(-500).setDuration(1000);
        //imageView.animate().translationXBy(500).setDuration(1000);
        //imageView.animate().rotation(360).alpha(0).setDuration(1000);
        //imageView.animate().scaleX(2f);
        //imageView.animate().scaleY(2f);
        imageView.animate().scaleX(1.5f).scaleY(1.5f).rotation(360).setDuration(2000);
    }
}