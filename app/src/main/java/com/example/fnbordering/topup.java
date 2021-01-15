package com.example.fnbordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class topup extends AppCompatActivity {
    Button btnBack, btnTopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnTopup = (Button)findViewById(R.id.btnTopup);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(topup.this, success.class);
                startActivity(back);
            }
        });
    }
}