package com.example.bigfish1.login;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bigfish1.Dashboard.Dashboard;
import com.example.bigfish1.PasswordUpdation.ForgotPassword;
import com.example.bigfish1.R;
import com.example.bigfish1.Registration;
import com.google.android.material.imageview.ShapeableImageView;
public class MainActivity extends AppCompatActivity implements LoginCallBack {
        private LoginCall loginCall;
        private EditText editTextUsername, editTextPassword,key;
        private Button loginButton;
        private TextView forgotPassword, signUp, newUserText, guestLogin, orText;
        private ShapeableImageView facebookButton, gplusButton, visibleButton;
        private ImageView rememberMe;
        String email,password;

        private LoginCallBack loginCallBack;

        @SuppressLint("MissingInflatedId")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                // Initialize UI components
                editTextUsername = findViewById(R.id.editTextuname);
                editTextPassword = findViewById(R.id.editTextPassword);
                loginButton = findViewById(R.id.login1);
                forgotPassword = findViewById(R.id.textview2);
                signUp = findViewById(R.id.textView4);



                loginCall = new LoginController(getApplicationContext(), this);
                loginButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                email = editTextUsername.getText().toString();
                                password = editTextPassword.getText().toString();
                                loginCall.getLoginData(email, password);
                                Log.d(TAG, "onClick: " + email +
                                        password + key);
                        }
                });
                signUp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Intent i = new Intent(getApplicationContext(), Registration.class);

                                startActivity(i);
                        }
                });
forgotPassword.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ForgotPassword.class);

                startActivity(i);
        }
});
        }


        @Override
        public void getResponse(String message, String status) {
                if (status.equals("success")){
                        Toast.makeText(getApplicationContext(), message + status , Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), Dashboard.class);
                        startActivity(i);
                }
                else {
                        Toast.makeText(this, "wrong password", Toast.LENGTH_SHORT).show();
                }

        }
}