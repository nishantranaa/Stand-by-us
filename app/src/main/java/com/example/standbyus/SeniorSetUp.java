package com.example.standbyus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SeniorSetUp extends AppCompatActivity {
    private Button startSenior;
    private TextView seniorSetUpView;
    private TextView showNamePerson;
    private SharedPreferences mainPreferences;
    private SharedPreferences sharedPreferences;
    private EditText firstContactName;
    private EditText secondContactName;
    private EditText thirdContactName;
    private EditText firstContactPhoneNumber;
    private EditText secondContactPhoneNumber;
    private EditText thirdContactPhoneNumber;

    //private static int numOfContacts =0;
    //public static ArrayList<String> myContacts;

    //@SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_set_up);

        //myContacts = new ArrayList<>();
        startSenior = findViewById(R.id.startJunior);
        seniorSetUpView = findViewById(R.id.juniorSetUpView);
        showNamePerson = findViewById(R.id.showNamePersonSenior);
        firstContactName = findViewById(R.id.firstContactName);
        secondContactName = findViewById(R.id.secondContactName);
        thirdContactName = findViewById(R.id.thirdContactName);
        firstContactPhoneNumber = findViewById(R.id.firstContactPhoneNumber);
        secondContactPhoneNumber = findViewById(R.id.secondContactPhoneNumber);
        thirdContactPhoneNumber = findViewById(R.id.thirdContactPhoneNumber);
        /* Toast messages */
        Toast toastNoItemSelected =  Toast.makeText(this, "Please select a contact", Toast.LENGTH_SHORT);
        Toast toastInsertAnotherItem =  Toast.makeText(this, "Please insert another contact", Toast.LENGTH_SHORT);
        /* Grub username from preferences */
        mainPreferences = getApplicationContext().getSharedPreferences("preferences", MODE_PRIVATE);
        showNamePerson.setText(mainPreferences.getString("name", "").toUpperCase());
        /* Senior preferences */
        sharedPreferences = getApplicationContext().getSharedPreferences("seniorPreferences", MODE_PRIVATE);
        /* When you press START BUTTON on SENIOR ADVANCE SETTINGS */
        startSenior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Set contacts and phone numbers */
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("contact1", firstContactName.getEditableText().toString());
                editor.putString("contact2", secondContactName.getEditableText().toString());
                editor.putString("contact3", thirdContactName.getEditableText().toString());
                editor.putString("number1", firstContactPhoneNumber.getEditableText().toString());
                editor.putString("number2", secondContactPhoneNumber.getEditableText().toString());
                editor.putString("number3", thirdContactPhoneNumber.getEditableText().toString());
                editor.apply();
                Intent intentSenior = new Intent(getApplicationContext(), Senior.class);
                startActivity(intentSenior);
            }
        });
    }
}