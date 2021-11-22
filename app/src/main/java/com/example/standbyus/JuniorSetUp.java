package com.example.standbyus;

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

public class JuniorSetUp extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    public static String userName = "";
    private static int numOfApps = 0;
    public static ArrayList<String> myApp;

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
        //EditText editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        TextView juniorSetUpView = findViewById(R.id.juniorSetUpView);
        TextView showNamePerson = findViewById(R.id.showNamePersonJunior);

        //showNamePerson.setText(getString(R.string.welcome) + " " + MainActivity.name);
        Intent intentJunior = new Intent(this, Junior.class);

        // preferences
        sharedPreferences = getApplication().getSharedPreferences("preferences", MODE_PRIVATE);
        // set the username into textview
        String str = sharedPreferences.getString("username", "");
        //Log.i(">>>>>>>>>>>>>>" , str);
        showNamePerson.setText(str);
        //showNamePerson.setText(sharedPreferences.getString("username", ""));

        juniorStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = juniorSpinner.getSelectedItemPosition();
                //userName = editTextTextPersonName.getText().toString();
                userName = sharedPreferences.getString("username", "");
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

                /*if (numOfApps<=2){
                    toastInsertAnotherItem.show();
                } else if(userName.isEmpty()){
                    toastNoNameInserted.show();
                } else */{
                    MainActivity.start = true;
                    MainActivity.junior = true;
                    startActivity(intentJunior);
                }
            }
        });
    }
}