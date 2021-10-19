package com.example.standbyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JuniorSetUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_set_up);

        Button middleStart = findViewById(R.id.startMiddle);
        Intent intentJunior = new Intent(this, Junior.class);

        middleStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.start = true;
                MainActivity.junior= true;
                startActivity(intentJunior);
            }
        });
    }
}