package com.example.fnbordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class shop extends AppCompatActivity {
    Button btnBack;
    LinearLayout btnFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnFood = (LinearLayout) findViewById(R.id.btnFood);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(shop.this, homepage.class);
                startActivity(back);
            }
        });

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(shop.this, food.class);
                startActivity(back);
            }
        });
    }
}