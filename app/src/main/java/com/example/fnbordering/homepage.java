package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Interface.ItemClickListener;
import com.example.fnbordering.Model.User;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

import com.example.fnbordering.Model.Category;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class homepage extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference category;
    RecyclerView listShop;
    ArrayList<Category> list;
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
        category = database.getReference("Category");

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtBalance = (TextView) findViewById(R.id.txtBalance);
        txtFullName.setText(Common.currentUse.name);
        txtBalance.setText("IDR " + Common.currentUse.balance);

        category.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    Category p = dataSnapshot.getValue(Category.class);
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