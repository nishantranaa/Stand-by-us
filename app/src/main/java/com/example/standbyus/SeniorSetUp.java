package com.example.standbyus;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SeniorSetUp extends AppCompatActivity {
    private SharedPreferences mainPreferences;
    private SharedPreferences sharedPreferences;
    private static int numOfContacts =0;
    public static ArrayList<String> myContacts;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myContacts = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_set_up);

        Toast toastNoItemSelected =  Toast.makeText(this, "Please select a contact", Toast.LENGTH_SHORT);
        Toast toastInsertAnotherItem =  Toast.makeText(this, "Please insert another contact", Toast.LENGTH_SHORT);

        Button startSenior = findViewById(R.id.startJunior);
        Spinner seniorSetUpContactsSpinner = findViewById(R.id.spinnerSeniorSetUpContacts);
        TextView seniorSetUpView = findViewById(R.id.juniorSetUpView);
        TextView showNamePerson = findViewById(R.id.showNamePersonSenior);
        //showNamePerson.setText(getString(R.string.welcome) + " " + MainActivity.name);

        Intent intentSenior = new Intent(this, Senior.class);

        // preferences
        mainPreferences = getApplicationContext().getSharedPreferences("preferences", MODE_PRIVATE);
        showNamePerson.setText(mainPreferences.getString("username", "").toUpperCase());
        sharedPreferences = getApplicationContext().getSharedPreferences("seniorPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("contact1", "");
        editor.putString("contact2", "");
        editor.putString("contact3", "");
        editor.putString("number1", "");
        editor.putString("number2", "");
        editor.putString("number3", "");
        editor.apply();

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