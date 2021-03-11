package com.example.lecture_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Call(View view)
    {
        Uri uri = Uri.parse("tel:+923084306366");
        Intent intent = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    public void ShowWeb(View view)
    {
        Uri uri = Uri.parse("http://www.pucit.edu.pk");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
    public void goToActivity2(View view)
    {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

    }
}