package com.example.standbyus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SetUp extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private EditText name;
    private EditText surname;
    private Spinner spinnerSetUpItem;
    private Button setUpButton;

    private int textItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        spinnerSetUpItem = findViewById(R.id.spinnerSetUp);
        setUpButton = findViewById(R.id.setUpButton);
        // Page message
        Toast toast = Toast.makeText(this, "Settings", Toast.LENGTH_SHORT);
        toast.show();
        // Age message not selection
        Toast toastAge = Toast.makeText(this, "Insert your age", Toast.LENGTH_LONG);

        sharedPreferences = getApplicationContext().getSharedPreferences("preferences", MODE_PRIVATE);

        // INTENT
        Intent intentJunior = new Intent(this, JuniorSetUp.class);
        Intent intentMiddle = new Intent(this , MiddleSetUp.class);
        Intent intentSenior =  new Intent(this, SeniorSetUp.class);

        setUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", name.getEditableText().toString());
                editor.putString("surname", surname.getEditableText().toString());
                editor.putInt("age", spinnerSetUpItem.getSelectedItemPosition());
                editor.apply();

                int x = spinnerSetUpItem.getSelectedItemPosition();

                if (MainActivity.name.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Insert your name", Toast.LENGTH_SHORT).show();
                } else if(x == 0) {
                    toastAge.show();
                } else if (x == 1) {
                    startActivity(intentJunior);
                } else if (x == 2) {
                    startActivity(intentMiddle);
                } else if (x == 3){
                    startActivity(intentSenior);
                }
            }
        });


    }


}
