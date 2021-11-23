package com.example.standbyus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Senior extends AppCompatActivity {
    private Button contact1;
    private Button contact2;
    private Button contact3;
    private SharedPreferences mainPreferences;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior);

        contact1 = findViewById(R.id.contact1);
        contact2 = findViewById(R.id.contact2);
        contact3 = findViewById(R.id.contact3);
        /* Toast messages */
        //Toast toast = Toast.makeText(this, "Welcome User", Toast.LENGTH_LONG);
        //toast.show();
        /* Grub all preferences */
        mainPreferences = getApplicationContext().getSharedPreferences("preferences", MODE_PRIVATE);
        sharedPreferences = getApplicationContext().getSharedPreferences("seniorPreferences", MODE_PRIVATE);
        /* Set contact names */
        contact1.setText(sharedPreferences.getString("contact1", ""));
        contact2.setText(sharedPreferences.getString("contact2", ""));
        contact3.setText(sharedPreferences.getString("contact3", ""));
        Intent intent = new Intent(this, SetUp.class);
        /* Make a phone call */
        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = sharedPreferences.getString("number1", "");
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                startActivity(callIntent);
            }
        });
        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = sharedPreferences.getString("number2", "");
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                startActivity(callIntent);
            }
        });
        contact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = sharedPreferences.getString("number3", "");
                Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                startActivity(callIntent);
            }
        });
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