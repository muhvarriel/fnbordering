package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Model.Cart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class checkout extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference cart;

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

        //init
        database = FirebaseDatabase.getInstance();
        cart = database.getReference("Cart");

        txtBalance = (TextView) findViewById(R.id.txtBalance);
        edtLocation = (EditText) findViewById(R.id.edtLocation);

        edtLocation.setText(Common.currentUse.location, TextView.BufferType.EDITABLE);

        int i = Integer.parseInt(Common.currentUse.balance.trim());
        txtBalance.setText("IDR " + i);

        cart.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int total = 0;

                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    Cart p = dataSnapshot.getValue(Cart.class);
                    total += (Integer.parseInt(p.getPrice())) * (Integer.parseInt(p.getQuantity()));
                }

                txtTotal = (TextView) findViewById(R.id.txtTotal);

                txtTotal.setText("IDR " + total);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(checkout.this,"Something wrong",Toast.LENGTH_SHORT).show();
            }
        });

        //InitFirebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference history = database.getReference("History");

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
}