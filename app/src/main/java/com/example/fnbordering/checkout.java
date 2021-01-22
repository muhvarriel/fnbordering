package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnbordering.Adapter.cartAdapter;
import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Model.Cart;
import com.example.fnbordering.Model.History;
import com.example.fnbordering.Model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class checkout extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference cart;
    RecyclerView listCart;
    ArrayList<Cart> list;
    cartAdapter adapter;

    Button btnBack, btnTopup, btnOrder;
    TextView txtTotal, txtBalance;
    EditText edtLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        String TAG = "Checkout";

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

        //init
        listCart = (RecyclerView) findViewById(R.id.listCart);
        listCart.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        txtBalance = (TextView) findViewById(R.id.txtBalance);
        edtLocation = (EditText) findViewById(R.id.edtLocation);

        edtLocation.setText(Common.currentUse.location, TextView.BufferType.EDITABLE);

        int i = Integer.parseInt(Common.currentUse.balance.trim());
        txtBalance.setText("IDR " + i);

        //InitFirebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        cart.orderByChild("user").equalTo(Common.currentUse.username).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int total = 0;

                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    Cart p = dataSnapshot.getValue(Cart.class);
                    list.add(p);
                    total += (Integer.parseInt(p.getPrice())) * (Integer.parseInt(p.getQuantity()));
                }

                adapter = new cartAdapter(checkout.this,list);
                listCart.setAdapter(adapter);

                txtTotal = (TextView) findViewById(R.id.txtTotal);
                txtTotal.setText("IDR " + total);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(checkout.this,"Something wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}