package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class cart extends AppCompatActivity {
    Button btnBack, btnHome, btnCheckout;

    FirebaseDatabase database;
    DatabaseReference request;
    RecyclerView listCart;
    List<Order> cart = new ArrayList<>();
    cartAdapter adapter;

    TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnHome = (Button)findViewById(R.id.btnHome);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(cart.this, homepage.class);
                startActivity(back);
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(cart.this, checkout.class);
                startActivity(back);
            }
        });

        //init
        database = FirebaseDatabase.getInstance();
        request = database.getReference("Requests");

        listCart = (RecyclerView) findViewById(R.id.listCart);
        listCart.setLayoutManager(new LinearLayoutManager(this));

        txtTotal = (TextView)findViewById(R.id.txtTotal);
        btnCheckout = (Button)findViewById(R.id.btnCheckout);

        request.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(cart.this,"Something wrong",Toast.LENGTH_SHORT).show();
            }
        });

        int total = 0;
        for (Order order: cart)
            total+=(Integer.parseInt(order.getPrice()))*(Integer.parseInt(order.getQuantity()));
        Locale locale = new Locale("en","US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);

        txtTotal.setText(fmt.format(total));
    }

}