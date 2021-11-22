package com.example.standbyus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MiddleSetUp extends AppCompatActivity {
    public static String myApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle_set_up);

        /* Messages */
        Toast toastNoItemSelected = Toast.makeText(this, "Please select an APP", Toast.LENGTH_SHORT);

        Button startMiddle = findViewById(R.id.startJunior);
        Spinner spinnerSeniorSetUpApps = findViewById(R.id.spinnerJuniorSetUpApps);
        TextView showNamePerson = findViewById(R.id.showNamePersonMiddle);
        showNamePerson.setText(getString(R.string.welcome) + " " + MainActivity.name);
        Intent intentMiddle = new Intent(this, Middle.class);

        // When you press START BUTTON on MIDDLE ADVANCE SETTINGS
        startMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = spinnerSeniorSetUpApps.getSelectedItemPosition();

                if(x==0){
                    toastNoItemSelected.show();
                } else {
                    switch (x) {
                        case 1:
                            myApp = spinnerSeniorSetUpApps.getItemAtPosition(x).toString();
                            break;
                        case 2:
                            myApp = spinnerSeniorSetUpApps.getItemAtPosition(x).toString();
                            break;
                        case 3:
                            myApp = spinnerSeniorSetUpApps.getItemAtPosition(x).toString();
                            break;
                        case 4:
                            myApp = spinnerSeniorSetUpApps.getItemAtPosition(x).toString();
                            break;
                        case 5:
                            myApp = spinnerSeniorSetUpApps.getItemAtPosition(x).toString();
                            break;
                        case 6:
                            myApp = spinnerSeniorSetUpApps.getItemAtPosition(x).toString();
                            break;
                    }
                    if(x!=0) {
                        MainActivity.start = true;
                        MainActivity.middle = true;
                        startActivity(intentMiddle);
                    }
                }
            }
        });
    }
}