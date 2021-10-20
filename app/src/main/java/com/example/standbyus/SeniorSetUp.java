package com.example.standbyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

public class SeniorSetUp extends AppCompatActivity {
    private static int numOfContacts =0;
    private static final String TAG = "Number Of Contacts";
    private static ArrayList<String> myContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myContacts = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_set_up);

        Toast toastNoItemSelected =  Toast.makeText(this, "Please select a contact", Toast.LENGTH_SHORT);
        Toast toastInsertAnotherItem =  Toast.makeText(this, "Please insert another contact", Toast.LENGTH_SHORT);

        Button startSenior = findViewById(R.id.startMiddle);
        Spinner seniorSetUpContactsSpinner = findViewById(R.id.spinnerSeniorSetUpContacts);
        TextView seniorSetUpView = findViewById(R.id.seniorSetUpView);

        Intent intentSenior = new Intent(this, Senior.class);

        // When you press START BUTTON on SENIOR ADVANCE SETTINGS
        startSenior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = seniorSetUpContactsSpinner.getSelectedItemPosition();

                if(x==0){
                    toastNoItemSelected.show();
                } else {
                    numOfContacts++;
                    switch (x) {
                        case 1:
                            myContacts.add(seniorSetUpContactsSpinner.getItemAtPosition(x).toString());
                            break;
                        case 2:
                            myContacts.add(seniorSetUpContactsSpinner.getItemAtPosition(x).toString());
                            break;
                        case 3:
                            myContacts.add(seniorSetUpContactsSpinner.getItemAtPosition(x).toString());
                            break;
                        case 4:
                            myContacts.add(seniorSetUpContactsSpinner.getItemAtPosition(x).toString());
                            break;
                        case 5:
                            myContacts.add(seniorSetUpContactsSpinner.getItemAtPosition(x).toString());
                            break;
                        case 6:
                            myContacts.add(seniorSetUpContactsSpinner.getItemAtPosition(x).toString());
                            break;
                    }
                    seniorSetUpView.setText(myContacts.toString());
                }
                //Log.i(TAG, "onClick: " + numOfContacts);
                Log.i(TAG,"onClick: " + myContacts);
                if(numOfContacts<=2){
                    toastInsertAnotherItem.show();
                } else {
                    MainActivity.start = true;
                    MainActivity.senior= true;
                    startActivity(intentSenior);
                }

            }
        });
    }
}