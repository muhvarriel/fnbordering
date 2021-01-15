package com.example.fnbordering;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Database.Database;
import com.example.fnbordering.Model.Order;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class checkout extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference request;
    RecyclerView listCart;
    List<Order> cart = new ArrayList<>();
    cartAdapter adapter;

    Button btnBack, btnTopup, btnOrder;
    TextView txtTotal, txtBalance;
    EditText edtLocation;

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

        //init
        database = FirebaseDatabase.getInstance();
        request = database.getReference("Requests");

        edtLocation = (EditText) findViewById(R.id.edtLocation);
        txtBalance = (TextView) findViewById(R.id.txtBalance);

        edtLocation.setText(Common.currentUse.location);

        int i = Integer.parseInt(Common.currentUse.balance.trim());
        txtBalance.setText("IDR " + i);

        cart = new Database(this).getCarts();
        int total = 0;
        for (Order order: cart) {
            total += (Integer.parseInt(order.getPrice())) * (Integer.parseInt(order.getQuantity()));
        }

        txtTotal.setText("IDR " + total);
    }
}