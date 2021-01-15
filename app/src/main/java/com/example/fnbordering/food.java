package com.example.fnbordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.fnbordering.Database.Database;
import com.example.fnbordering.Model.Category;
import com.example.fnbordering.Model.Food;
import com.example.fnbordering.Model.Order;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class food extends AppCompatActivity {
    public static final String EXTRA_FOOD = "extra_food";

    FirebaseDatabase database;
    DatabaseReference foods;

    TextView txtFoodName, txtFoodPrice, txtId, txtDesc;

    Button btnBack, btnAddcart;
    ElegantNumberButton numberButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        Food currentFood = getIntent().getParcelableExtra(EXTRA_FOOD);

        database = FirebaseDatabase.getInstance().getInstance();
        foods=database.getReference("Food");

        btnBack = (Button)findViewById(R.id.btnBack);
        btnAddcart = (Button)findViewById(R.id.btnAddcart);
        numberButton =(ElegantNumberButton)findViewById(R.id.numberButton);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        numberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                String count = numberButton.getNumber();
                Log.e("NUM", count);
            }
        });

        //init
        txtFoodName = (TextView) findViewById(R.id.txtFoodName);
        txtFoodPrice = (TextView) findViewById(R.id.txtFoodPrice);
        txtId = (TextView) findViewById(R.id.txtId);
        txtDesc = (TextView) findViewById(R.id.txtDesc);

        txtFoodName.setText(currentFood.getName());
        txtFoodPrice.setText(currentFood.getPrice());
        txtId.setText(currentFood.getId());
        txtDesc.setText(currentFood.getDesc());

        btnAddcart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Database(getBaseContext()).addToCart(new Order(
                        EXTRA_FOOD,
                        currentFood.getName(),
                        numberButton.getNumber(),
                        currentFood.getPrice()
                ));

                Toast.makeText(food.this,"Add cart",Toast.LENGTH_SHORT).show();

                Intent back = new Intent(food.this, cart.class);
                startActivity(back);
            }
        });
    }
}