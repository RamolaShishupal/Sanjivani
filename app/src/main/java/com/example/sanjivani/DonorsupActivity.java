package com.example.sanjivani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DonorsupActivity extends AppCompatActivity {

    EditText etdname,etduname,etdpass,etdage,etdbg,etdpno ,etdadd,etdmail;
    TextView tvdname,tvduname,tvdpass,tvdage,tvdbg,tvdpno,tvdadd,tvdmail,tvtitle;
    Button btnsub;
    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_donorsup);

        etdname = (EditText) findViewById(R.id.etdname);
        etduname = (EditText) findViewById(R.id.etduname);
        etdpass = (EditText) findViewById(R.id.etdpass);
        etdage = (EditText) findViewById(R.id.etdage);
        etdbg = (EditText) findViewById(R.id.etdbg);
        etdpno = (EditText) findViewById(R.id.etdpno);
        etdadd = (EditText) findViewById(R.id.etdadd);
        etdmail = (EditText) findViewById(R.id.etdmail);

        tvdname = (TextView) findViewById(R.id.tvdname);
        tvtitle = (TextView) findViewById(R.id.tvtitle);
        tvduname = (TextView) findViewById(R.id.tvduname);
        tvdpass = (TextView) findViewById(R.id.tvdpass);
        tvdage = (TextView) findViewById(R.id.tvdage);
        tvdbg = (TextView) findViewById(R.id.tvdbg);
        tvdpno = (TextView) findViewById(R.id.tvdpno);
        tvdadd = (TextView) findViewById(R.id.tvdadd);
        tvdmail = (TextView) findViewById(R.id.tvdmail);

        btnsub = (Button) findViewById(R.id.btnsub);

        final MyDbHelper db = new MyDbHelper(this);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dname = etdname.getText().toString();
                String duname = etduname.getText().toString();
                String dpass = etdpass.getText().toString();
                String dage = etdage.getText().toString();
                String dbg = etdbg.getText().toString();
                String dpno = etdpno.getText().toString();
                String dadd = etdadd.getText().toString();
                String dmail = etdmail.getText().toString();

                if (dname.length() == 0) {
                    etdname.setError("name is empty");
                    etdname.requestFocus();
                    return;
                }


                if (duname.length() == 0) {
                    etduname.setError("usename is empty");
                    etduname.requestFocus();
                    return;
                }
                if (dpass.length() == 0) {
                    etdpass.setError("password is empty");
                    etdpass.requestFocus();
                    return;
                }

                if (dage.length() == 0) {
                    etdage.setError("age is empty");
                    etdage.requestFocus();
                    return;
                }
                if (dmail.length() == 0) {
                    etdmail.setError("mail is empty");
                    etdmail.requestFocus();
                    return;
                }
                if (dbg.length() == 0) {
                    etdbg.setError("blood group is empty");
                    etdbg.requestFocus();
                    return;
                }
                if (dpno.length() == 0) {
                    etdpno.setError("phone no is empty");
                    etdpno.requestFocus();
                    return;
                }
                if (dadd.length() == 0) {
                    etdadd.setError("password is empty");
                    etdadd.requestFocus();
                    return;
                }


                db.addDonor(dname, dpass, duname, dbg, dadd, Integer.parseInt(dage));
                etdname.setText("");
                etdpass.setText("");
                etduname.setText("");
                etdbg.setText("");
                etdadd.setText("");
                etdage.setText("");
                etdmail.setText("");
                etdpno.setText("");

                Intent i=new Intent(DonorsupActivity.this,HomeActivity.class);
                startActivity(i);
                //finish();


            }
        });
    }}
