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
    private EditText surname;
    private EditText name;
    private Spinner spinnerSetUpItem;

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

        spinnerSetUpItem = findViewById(R.id.spinnerSetUp);
        surname = findViewById(R.id.surname);
        name = findViewById(R.id.name);

        Button setUpButton = findViewById(R.id.setUpButton);

        sharedPreferences = getApplicationContext().getSharedPreferences("preferences", MODE_PRIVATE);


        // INTENT
        Intent intentJunior = new Intent(this, JuniorSetUp.class);
        Intent intentMiddle = new Intent(this , MiddleSetUp.class);
        Intent intentSenior =  new Intent(this, SeniorSetUp.class);

        setUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", surname.getEditableText().toString());
                editor.putString("name", name.getEditableText().toString());
                editor.putInt("age", spinnerSetUpItem.getSelectedItemPosition());
                editor.apply();


                int x = spinnerSetUpItem.getSelectedItemPosition();
                //MainActivity.name = editPersonName.getText().toString().toUpperCase();
                if (MainActivity.name.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Insert your name", Toast.LENGTH_SHORT).show();
                } else if(x == 0) {
                    toastAge.show();
                } else if (x == 1) {
                    intentJunior.putExtra("name", MainActivity.name);
                    startActivity(intentJunior);
                } else if (x == 2) {
                    intentMiddle.putExtra("name", MainActivity.name);
                    startActivity(intentMiddle);
                } else if (x == 3){
                    intentSenior.putExtra("name", MainActivity.name);
                    startActivity(intentSenior);
                }
            }
        });


    }


}
