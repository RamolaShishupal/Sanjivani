package com.example.sanjivani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import androidx.appcompat.app.AppCompatActivity;


public class SignupActivity extends AppCompatActivity {


    Button btndonor,btnadmin;


    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_signup);

        btnadmin = (Button) findViewById(R.id.btnadmin);
        btndonor = (Button) findViewById(R.id.btndonor);

        btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(SignupActivity.this, HadminsupActivity.class);
                startActivity(i);
            }
        });

        btndonor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignupActivity.this, DonorsupActivity.class);
                startActivity(i);
            }
        });

    }}
