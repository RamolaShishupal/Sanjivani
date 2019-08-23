package com.example.sanjivani;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HadminsupActivity extends AppCompatActivity {
    TextView tvhname ,tvaname,tvhuname ,tvhpass,tvhpno,tvhadd,tvhmail,tvtitle;
    EditText ethname,etaname,ethuname ,ethpass,ethpno,ethadd,ethmail;
    Button btnsub;



    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.activity_hadminsup);

        tvhname = (TextView) findViewById(R.id.tvhname);
        tvtitle = (TextView) findViewById(R.id.tvtitle);
        tvaname = (TextView) findViewById(R.id.tvaname);
        tvhpass = (TextView) findViewById(R.id.tvhpass);
        tvhuname = (TextView) findViewById(R.id.tvhuname);
        tvhpno = (TextView) findViewById(R.id.tvhpno);
        tvhadd = (TextView) findViewById(R.id.tvhadd);
        tvhmail = (TextView) findViewById(R.id.tvhmail);

        ethname = (EditText) findViewById(R.id.ethname);
        etaname = (EditText) findViewById(R.id.etaname);
        ethpass = (EditText) findViewById(R.id.ethpass);
        ethuname = (EditText) findViewById(R.id.ethuname);
        ethpno = (EditText) findViewById(R.id.ethpno);
        ethadd = (EditText) findViewById(R.id.ethadd);
        ethmail = (EditText) findViewById(R.id.ethmail);


        btnsub = (Button) findViewById(R.id.btnsub);

        final MyDbHelper db = new MyDbHelper(this);
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String hname = ethname.getText().toString();
                String huname = ethuname.getText().toString();
                String hpass = ethpass.getText().toString();
                String haname = etaname.getText().toString();
                String hpno = ethpno.getText().toString();
                String hadd = ethadd.getText().toString();
                String hmail = ethmail.getText().toString();

                if (hname.length() == 0) {
                    ethname.setError("hospital name is empty");
                    ethname.requestFocus();
                    return;
                }


                if (huname.length() == 0) {
                    ethuname.setError("usename is empty");
                    ethuname.requestFocus();
                    return;
                }
                if (hpass.length() == 0) {
                    ethpass.setError("password is empty");
                    ethpass.requestFocus();
                    return;
                }

                if (haname.length() == 0) {
                    etaname.setError("admin name is empty");
                    etaname.requestFocus();
                    return;
                }
                if (hmail.length() == 0) {
                    ethmail.setError("mail is empty");
                    ethmail.requestFocus();
                    return;
                }

                if (hpno.length() == 0) {
                    ethpno.setError("phone no is empty");
                    ethpno.requestFocus();
                    return;
                }
                if (hadd.length() == 0) {
                    ethadd.setError("password is empty");
                    ethadd.requestFocus();
                    return;
                }

                db.addHospital(hname ,hpass,huname,haname,hadd );
                ethname.setText("");
                ethpass.setText("");
                ethuname.setText("");
                etaname.setText("");
                ethadd.setText("");
                ethmail.setText("");
                ethpno.setText("");


                Intent i=new Intent(HadminsupActivity.this,HomeActivity.class);
                startActivity(i);
                //finish();

            }
        });
    }}