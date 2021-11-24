package com.example.standbyus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
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
    private Button buttonFindImage1;
    private ImageButton showImage1;
    private Button buttonFindImage2;
    private ImageButton showImage2;
    private Button buttonFindImage3;
    private ImageButton showImage3;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    //private static int numOfContacts =0;
    //public static ArrayList<String> myContacts;

    //@SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_senior_set_up);


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
        /* get the images */
        buttonFindImage1 = findViewById(R.id.buttonFindImage1);
        buttonFindImage2 = findViewById(R.id.buttonFindImage2);
        buttonFindImage3 = findViewById(R.id.buttonFindImage3);
        showImage1 = findViewById(R.id.showImage1);
        showImage2 = findViewById(R.id.showImage2);
        showImage3 = findViewById(R.id.showImage3);
        buttonFindImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery1(); // Open images gallery
            }
        });
        /*
        buttonFindImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery2(); // Open images gallery
            }
        });
        buttonFindImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery3(); // Open images gallery
            }
        });*/
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

    private void openGallery1() {
        /* open the images gallery on the phone */
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }
    /*private void openGallery2() {
        // open the images gallery on the phone
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }*/
    /*private void openGallery3() {
        // open the images gallery on the phone
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Log.i(">>>>>>>>>>>>", String.valueOf(requestCode));
        System.out.println(">>>>>>>>>>>>>>>>>>." + requestCode);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            showImage1.setImageURI(imageUri);
        }
        /*if (resultCode == 0){
            showImage1.setImageURI(imageUri);
        } else if (requestCode == 1) {
            showImage2.setImageURI(imageUri);
        } else if (requestCode == 2) {
            showImage3.setImageURI(imageUri);
        }*/
    }

}