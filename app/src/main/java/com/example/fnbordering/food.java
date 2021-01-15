package com.example.fnbordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;

public class food extends AppCompatActivity {
    Button btnBack, btnAddcart;
    ElegantNumberButton numberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnAddcart = (Button)findViewById(R.id.btnAddcart);
        numberButton =(ElegantNumberButton)findViewById(R.id.numberButton);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(food.this, shop.class);
                startActivity(back);
            }
        });

        btnAddcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(food.this, cart.class);
                startActivity(back);
            }
        });

        numberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                String count = numberButton.getNumber();
                Log.e("NUM", count);
            }
        });
    }
}