package com.example.standbyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MiddleSetUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle_set_up);

        Button startJuniorSetUp = findViewById(R.id.startMiddle);
        Intent intentJuniorSetUp = new Intent(this, Middle.class);
        startJuniorSetUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentJuniorSetUp);
            }
        });
    }
}