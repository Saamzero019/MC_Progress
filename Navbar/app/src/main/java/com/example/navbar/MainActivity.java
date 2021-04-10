package com.example.navbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navView);
        drawerLayout = findViewById(R.id.drawerLayout);
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.recent:
                        Intent intent=new Intent(MainActivity.this, Recent.class);
                        startActivity(intent);
                        break;
                    case R.id.shared:
                        Toast.makeText(getApplicationContext(),"Shared", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.starred:
                        Toast.makeText(getApplicationContext(),"Starred", Toast.LENGTH_SHORT).show();
                        break;

                }
                return true;
            }
        });
    }
    @Override
    public  void onBackPressed(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer((GravityCompat.START));
            Toast.makeText(getApplicationContext(),"Start", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),"Close", Toast.LENGTH_SHORT).show();
            super.onBackPressed();
        }
    }

}