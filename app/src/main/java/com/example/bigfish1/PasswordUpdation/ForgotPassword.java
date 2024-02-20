package com.example.bigfish1.PasswordUpdation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bigfish1.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewTitle, textViewSubtitle, text8;
    private EditText editTextEmail;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        imageView = findViewById(R.id.imageView3);
        textViewTitle = findViewById(R.id.textView8);
        textViewSubtitle = findViewById(R.id.textView9);
        text8 = findViewById(R.id.text8);
        editTextEmail = findViewById(R.id.editTextText6);
        buttonNext = findViewById(R.id.button2);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailAddress = editTextEmail.getText().toString();
                Intent intent = new Intent(ForgotPassword.this, SecurityCode.class);
                startActivity(intent);
            }
        });
    }
}
