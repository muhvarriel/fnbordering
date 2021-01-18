package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnbordering.Adapter.foodAdapter;
import com.example.fnbordering.Model.Food;
import com.example.fnbordering.Model.Shop;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class shop extends AppCompatActivity {
    public static String EXTRA_SHOP = "extra_shop";

    FirebaseDatabase database;
    DatabaseReference food;
    RecyclerView listFood;
    ArrayList<Food> list;
    foodAdapter adapter;

    ImageView photoFood;

    Button btnBack;
    TextView txtFullName, txtLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        btnBack = (Button)findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //init
        listFood = (RecyclerView) findViewById(R.id.listFood);
        listFood.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        food = database.getReference("Food");

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtLocation = (TextView) findViewById(R.id.txtLocation);

        Shop shop = getIntent().getParcelableExtra(EXTRA_SHOP);

        txtFullName.setText(shop.getName());
        txtLocation.setText(shop.getLocation());

        food.orderByChild("id").equalTo(shop.getKeyId()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    Food p = dataSnapshot.getValue(Food.class);
                    list.add(p);
                }

                adapter = new foodAdapter(shop.this,list);
                listFood.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(shop.this,"Something wrong",Toast.LENGTH_SHORT).show();
            }
        });
    }
}