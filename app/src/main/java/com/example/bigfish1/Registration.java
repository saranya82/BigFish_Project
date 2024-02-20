package com.example.bigfish1;


import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bigfish1.login.MainActivity;

public class Registration extends AppCompatActivity implements RegistrationCallBack {

    private RegisterCall registercall;

    String firstname,lastname,email,telephone,password,type,referal_code,key;

    EditText fname,lname,email1,mnumber,
            pswd,type1,referalcode;

    Button register;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        email1 = findViewById(R.id.email1);
        mnumber = findViewById(R.id.mnumber);
        pswd = findViewById(R.id.pswd);
        type1 = findViewById(R.id.type1);
        referalcode = findViewById(R.id.referalcode);

        register = findViewById(R.id.register);

        registercall = new RegistrationController(getApplicationContext(),this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname = fname.getText().toString();
                lastname = lname.getText().toString();
                email = email1.getText().toString();
                telephone = mnumber.getText().toString();
                password = pswd.getText().toString();
                type = type1.getText().toString();
                referal_code = referalcode.getText().toString();


                registercall.getRegisterdata(firstname,lastname,email,telephone,
                        password,type,referal_code,key);
                Log.d(TAG,"onClick: "+firstname+lastname+email+telephone+
                        password+type+referal_code);

            }
        });

    }

    @Override
    public void getResponse(String message, String status) {

        if (status.equals("success")){
            Toast.makeText(getApplicationContext(), message + status , Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), MainActivity.class);

            startActivity(i);
        }
        else {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }
}