package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnbordering.Adapter.cartAdapter;
import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Model.Cart;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {
    Button btnBack, btnHome, btnCheckout;

    FirebaseDatabase database;
    DatabaseReference cart;
    RecyclerView listCart;
    ArrayList<Cart> list;
    cartAdapter adapter;

    TextView txtTotal;
    ImageView btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnHome = (Button)findViewById(R.id.btnHome);
        btnCheckout = (Button)findViewById(R.id.btnCheckout);

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
        listCart = (RecyclerView) findViewById(R.id.listCart);
        listCart.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        cart = database.getReference("Cart");

        cart.orderByChild("user").equalTo(Common.currentUse.username).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int total = 0;

                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    Cart p = dataSnapshot.getValue(Cart.class);
                    String key = dataSnapshot.getKey();
                    list.add(p);
                    total += (Integer.parseInt(p.getPrice())) * (Integer.parseInt(p.getQuantity()));

                    btnRemove = (ImageView) findViewById(R.id.btnRemove);

                    btnRemove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(v.getRootView().getContext());

                            builder.setTitle("Delete");
                            builder.setMessage("Do you want to delete " + p.getProductName());
                            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    DatabaseReference cartDel = FirebaseDatabase.getInstance().getReference("Cart").child(key);

                                    cartDel.removeValue();
                                    Toast.makeText(cart.this, "Delete Item Successfully !", Toast.LENGTH_SHORT).show();
                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            builder.show();
                        }
                    });
                }

                adapter = new cartAdapter(cart.this,list);
                listCart.setAdapter(adapter);

                txtTotal = (TextView) findViewById(R.id.txtTotal);

                txtTotal.setText("IDR " + total);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(cart.this,"Something wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }

}