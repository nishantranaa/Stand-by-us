package com.example.standbyus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //private static int TOAST_DURATION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TOAST_DURATION = 1000;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(this, "Welcome mate", Toast.LENGTH_SHORT);
        //toast.setDuration(TOAST_DURATION/10);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Spinner spinnerSetUp = findViewById(R.id.spinnerSetUp);

        if(item.getItemId() == R.id.settings) {
            Intent intentSetting = new Intent(this, SetUp.class);
            startActivity(intentSetting);
            return true;

        }
        return super.onOptionsItemSelected(item);

    }
}