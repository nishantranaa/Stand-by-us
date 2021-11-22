package com.example.standbyus;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //private static int TOAST_DURATION;
    public static boolean start = false;
    public static boolean junior = false;
    public static boolean middle = false;
    public static boolean senior = false;
    public static String name = "USER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TOAST_DURATION = 1000;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Main message */
        Toast toast = Toast.makeText(this, "Welcome mate", Toast.LENGTH_SHORT);
        //toast.setDuration(TOAST_DURATION/10);
        toast.show();
        /* Settings message */
        Toast toastStart = Toast.makeText
                (this, "Please do settings first", Toast.LENGTH_SHORT);

        Button startMain = findViewById(R.id.mainButton);
        Intent intentJunior = new Intent(this, Junior.class);
        Intent intentMiddle = new Intent(this, Middle.class);
        Intent intentSenior = new Intent(this, Senior.class);

        startMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (start == false) {
                    toastStart.show();
                } else {
                    if (junior == true) {
                        startActivity(intentJunior);
                    } else if (middle == true) {
                        startActivity(intentMiddle);
                    } else {
                        startActivity(intentSenior);
                    }
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.settings) {
            Intent intentSetting = new Intent(this, SetUp.class);
            startActivity(intentSetting);
            return true;
        } else {
            MainActivity.start = false;
            MainActivity.junior = false;
            MainActivity.middle = false;
            MainActivity.senior = false;
            MainActivity.name = "USER";
        }
        return super.onOptionsItemSelected(item);
    }

}