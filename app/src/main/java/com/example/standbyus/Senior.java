package com.example.standbyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
}