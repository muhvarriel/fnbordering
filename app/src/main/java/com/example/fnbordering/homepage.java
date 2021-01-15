package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnbordering.Adapter.shopAdapter;
import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Model.Shop;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class homepage extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference shop;
    RecyclerView listShop;
    ArrayList<Shop> list;
    shopAdapter adapter;

    TextView txtFullName, txtBalance;

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

        //init
        listShop = (RecyclerView) findViewById(R.id.listShop);
        listShop.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        shop = database.getReference("Shop");

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtBalance = (TextView) findViewById(R.id.txtBalance);

        txtFullName.setText(Common.currentUse.name);

        int i = Integer.parseInt(Common.currentUse.balance.trim());
        txtBalance.setText("IDR " + i);

        shop.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    Shop p = dataSnapshot.getValue(Shop.class);
                    list.add(p);
                }

                adapter = new shopAdapter(homepage.this,list);
                listShop.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(homepage.this,"Something wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}