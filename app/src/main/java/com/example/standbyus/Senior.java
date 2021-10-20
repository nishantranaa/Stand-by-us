package com.example.standbyus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class Senior extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior);

        Toast toast = Toast.makeText(this, "Welcome User", Toast.LENGTH_LONG);
        toast.show();

        Button contact1 = findViewById(R.id.contact1);
        contact1.setText(SeniorSetUp.myContacts.get(0).toString());
        Button contact2 = findViewById(R.id.contact2);
        contact2.setText(SeniorSetUp.myContacts.get(1).toString());
        Button contact3 = findViewById(R.id.contact3);
        contact3.setText(SeniorSetUp.myContacts.get(2).toString());


        Intent intent = new Intent(this, SetUp.class);
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