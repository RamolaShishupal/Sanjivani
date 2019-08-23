package com.example.sanjivani;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnlogin,btnsignup;
    EditText etuname,etpass;
    TextView tvuname,tvpass,tvtitle;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvtitle=(TextView)findViewById(R.id.tvtitle);
        tvuname =(TextView)findViewById(R.id.tvuname);
        tvpass =(TextView)findViewById(R.id.tvpass);
        etuname =(EditText)findViewById(R.id.etuname);
        etpass =(EditText)findViewById(R.id.etpass);
        btnlogin =(Button)findViewById(R.id.btnlogin);
        btnsignup=(Button)findViewById(R.id.btnsignup);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String u =etuname.getText().toString();
                String p=etpass.getText().toString();

                if(u.length()==0){
                    etuname.setError("Please Enter Username");
                    etuname.requestFocus();
                    return;
                }
                if (p.length()==0){
                    etpass.setError("Please Enter Password");
                    etuname.requestFocus();
                    return;
                }

                if (u.equals("uname")&& p.equals("pass")){
                    Intent i =new Intent(MainActivity.this,HomeActivity.class);
                    i.putExtra("u",u);
                    startActivity(i);
                    finish();
                }

                else{
                    Toast.makeText(MainActivity.this,"Login Denied",Toast.LENGTH_SHORT).show();
                    etuname.setText("");
                    etpass.setText("");

                }

               // Intent i=new Intent(MainActivity.this,HomeActivity.class);
                //startActivity(i);
                //finish();



            }



        });

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,SignupActivity.class);
                startActivity(i);
                //finish();

            }
        });








    }
}
