package com.example.fnbordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class checkout extends AppCompatActivity {
    Button btnBack, btnTopup, btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnTopup = (Button)findViewById(R.id.btnTopup);
        btnOrder = (Button)findViewById(R.id.btnOrder);
        btnTopup = (Button) findViewById(R.id.btnTopup);

        btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(checkout.this, topup.class);
                startActivity(back);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(checkout.this, topup.class);
                startActivity(back);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(checkout.this, success.class);
                startActivity(back);
            }
        });
    }
}