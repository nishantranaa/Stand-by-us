package com.example.standbyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SeniorSetUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_set_up);

        Button startSenior = findViewById(R.id.startMiddle);
        Intent intentSenior = new Intent(this, Senior.class);
        startSenior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentSenior);
            }
        });
    }
}