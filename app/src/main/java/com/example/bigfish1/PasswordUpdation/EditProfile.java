package com.example.bigfish1.PasswordUpdation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bigfish1.R;
import com.example.bigfish1.login.MainActivity;

public class EditProfile extends AppCompatActivity implements UpdationCallBack {
    private UpdationCall updateCall;

    String user_id,firstname,lastname,email,telephone,key;

    EditText editxtuserid,editxtfname,editxtlname,editxtemail,editxtmobile;

    Button update;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        editxtuserid = findViewById(R.id.editxtuserid);
        editxtfname = findViewById(R.id.editxtfname);
        editxtlname = findViewById(R.id.editxtlname);
        editxtemail = findViewById(R.id.editxtemail);
        editxtmobile = findViewById(R.id.editxtmobile);

        updateCall = new UpdateController(getApplicationContext(),this);

        update = findViewById(R.id.update);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user_id = editxtuserid.getText().toString();
                firstname = editxtfname.getText().toString();
                lastname = editxtlname.getText().toString();
                email = editxtemail.getText().toString();
                telephone = editxtmobile.getText().toString();
                if (updateCall != null) {
                    updateCall.getUpdatedata(user_id, firstname, lastname, email, telephone, key);
                } else {
                    Log.d("CategoryFishitem", "updateCall is null ");
                }

            }
        });
    }

    @Override
    public void getUpdateResponse(String status, String message) {

        if (status.equals("success")) {
            Toast.makeText(getApplicationContext(), message + status, Toast.LENGTH_SHORT ).show();
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Update failed: " + message, Toast.LENGTH_SHORT ).show();
        }

    }
}