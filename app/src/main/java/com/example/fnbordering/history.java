package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.fnbordering.Adapter.historyAdapter;
import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Model.History;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class history extends AppCompatActivity {
    Button btnBack;

    FirebaseDatabase database;
    DatabaseReference history, userHistory;
    RecyclerView listHistory;
    ArrayList<History> list;
    historyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        btnBack = (Button)findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //init
        listHistory = (RecyclerView) findViewById(R.id.listHistory);
        listHistory.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
        history = database.getReference("History");
        userHistory = history.child(Common.currentUse.username);

        userHistory.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot: snapshot.getChildren()) {
                    History p = dataSnapshot.getValue(History.class);
                    list.add(p);
                }

                adapter = new historyAdapter(history.this,list);
                listHistory.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(history.this,"Something wrong",Toast.LENGTH_SHORT).show();
            }
        });

    }
}