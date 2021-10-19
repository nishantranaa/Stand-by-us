package com.example.standbyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SetUp extends AppCompatActivity {

    private int textItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);

        // Page message
        Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
        toast.show();
        // Age message not selection
        Toast toastAge = Toast.makeText(this, "Insert your age", Toast.LENGTH_LONG);

        Spinner spinnerSetUpItem = findViewById(R.id.spinnerSetUp);
        Button setUpButton = findViewById(R.id.setUpButton);

        // INTENT
        Intent intentJunior = new Intent(this, JuniorSetUp.class);
        Intent intentMiddle = new Intent(this , MiddleSetUp.class);
        Intent intentSenior =  new Intent(this, SeniorSetUp.class);

        setUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = spinnerSetUpItem.getSelectedItemPosition();
                if(x == 0) {
                    toastAge.show();
                } else if (x == 1) {
                    startActivity(intentJunior);
                } else if (x == 2) {
                    startActivity(intentMiddle);
                } else {
                    System.out.println(x);
                    startActivity(intentSenior);
                }
            }
        });


    }


}
