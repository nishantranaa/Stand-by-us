package com.example.standbyus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Middle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);

        TextView middleView = findViewById(R.id.juniorView);
        middleView.setText(MiddleSetUp.myApp.toString().toUpperCase());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.settings) {
            Intent intentSetting = new Intent(this, SetUp.class);
            startActivity(intentSetting);
            return true;
        } else {
            MainActivity.start = false;
            MainActivity.junior = false;
            MainActivity.middle = false;
            MainActivity.senior = false;
        }
        return super.onOptionsItemSelected(item);
    }
}