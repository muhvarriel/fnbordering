package com.example.fnbordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class homepage extends AppCompatActivity {
    LinearLayout btnProfile, btnShop;
    FloatingActionButton btnCart;
    Button btnTopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        btnTopup = (Button) findViewById(R.id.btnTopup);
        btnCart = (FloatingActionButton) findViewById(R.id.btnCart);
        btnProfile = (LinearLayout) findViewById(R.id.btnProfile);
        btnShop = (LinearLayout) findViewById(R.id.btnShop);

        btnTopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(homepage.this, topup.class);
                startActivity(back);
            }
        });

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(homepage.this, cart.class);
                startActivity(back);
            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(homepage.this, profile.class);
                startActivity(back);
            }
        });

        btnShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(homepage.this, shop.class);
                startActivity(back);
            }
        });
    }
}