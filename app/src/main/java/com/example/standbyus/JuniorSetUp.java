package com.example.standbyus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class JuniorSetUp extends AppCompatActivity {
    public static String userName = "";
    private static int numOfApps = 0;
    public static ArrayList<String> myApp;
    public static String TAG = "XXXXXXXXXXXXXXXXXXX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myApp = new ArrayList<>();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_junior_set_up);
        /* My messages */
        Toast toastNoItemSelected =  Toast.makeText(this, "Please select an APP", Toast.LENGTH_SHORT);
        Toast toastNoNameInserted =  Toast.makeText(this, "Please insert your name", Toast.LENGTH_SHORT);
        Toast toastInsertAnotherItem =  Toast.makeText(this, "Please insert another APP", Toast.LENGTH_SHORT);

        Button juniorStart = findViewById(R.id.startJunior);
        Spinner juniorSpinner = findViewById(R.id.spinnerJuniorSetUpApps);
        EditText editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        TextView juniorSetUpView = findViewById(R.id.juniorSetUpView);

        Intent intentJunior = new Intent(this, Junior.class);

        juniorStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = juniorSpinner.getSelectedItemPosition();
                userName = editTextTextPersonName.getText().toString();

                if (userName.isEmpty()) {
                    toastNoNameInserted.show();
                }
                if(x==0){
                    toastNoItemSelected.show();
                } else {
                    numOfApps++;
                    switch (x) {
                        case 1:
                            myApp.add(juniorSpinner.getItemAtPosition(x).toString());
                            break;
                        case 2:
                            myApp.add(juniorSpinner.getItemAtPosition(x).toString());
                            break;
                        case 3:
                            myApp.add(juniorSpinner.getItemAtPosition(x).toString());
                            break;
                        case 4:
                            myApp.add(juniorSpinner.getItemAtPosition(x).toString());
                            break;
                        case 5:
                            myApp.add(juniorSpinner.getItemAtPosition(x).toString());
                            break;
                        case 6:
                            myApp.add(juniorSpinner.getItemAtPosition(x).toString());
                            break;
                    }
                    juniorSetUpView.setText(myApp.toString());
                }

                if (numOfApps<=2){
                    toastInsertAnotherItem.show();
                } else if(userName.isEmpty()){
                    toastNoNameInserted.show();
                } else {
                    MainActivity.start = true;
                    MainActivity.junior = true;
                    startActivity(intentJunior);
                }
            }
        });
    }
}