package com.example.fnbordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fnbordering.Common.Common;
import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {
    Button btnBack, btnSignout, btnHistory, btnEdit;
    TextView txtFullName, txtBalance, txtUsername;

    ImageView btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtBalance = (TextView) findViewById(R.id.txtBalance);
        txtUsername = (TextView) findViewById(R.id.txtUsername);

        txtFullName.setText(Common.currentUse.name);
        txtBalance.setText("IDR " + Common.currentUse.balance);
        txtUsername.setText(Common.currentUse.username);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnEdit = (Button)findViewById(R.id.btnEdit);
        btnHistory = (Button)findViewById(R.id.btnHistory);
        btnSignout = (Button)findViewById(R.id.btnSignout);
        btnUpload = (ImageView)findViewById(R.id.btnUpload);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(profile.this, editprofile.class);
                startActivity(back);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(profile.this, history.class);
                startActivity(back);
            }
        });

        btnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent back = new Intent(profile.this, login.class);
                startActivity(back);
            }
        });
    }
}