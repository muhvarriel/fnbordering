package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class topup extends AppCompatActivity {
    Button btnBack, btn10, btn20, btn50, btn100, btn200, btn500;
    TextView txtFullName, txtBalance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
        String TAG = "Top Up";

        txtFullName = (TextView) findViewById(R.id.txtFullName);
        txtBalance = (TextView) findViewById(R.id.txtBalance);

        txtFullName.setText(Common.currentUse.name);
        txtBalance.setText("IDR " + Common.currentUse.balance);

        int i = Integer.parseInt(Common.currentUse.balance.trim());

        btnBack = (Button)findViewById(R.id.btnBack);

        btn10 = (Button)findViewById(R.id.btn10);
        btn20 = (Button)findViewById(R.id.btn20);
        btn50 = (Button)findViewById(R.id.btn50);
        btn100 = (Button)findViewById(R.id.btn100);
        btn200 = (Button)findViewById(R.id.btn200);
        btn500 = (Button)findViewById(R.id.btn500);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //InitFirebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(topup.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int top = i + 10000;

                        mDialog.dismiss();
                        mDialog.dismiss();
                        User user = new User(Common.currentUse.name, Common.currentUse.password, Integer.toString(top), Common.currentUse.location);
                        table_user.child(Common.currentUse.username).setValue(user);
                        Toast.makeText(topup.this, "Top Up Successfully !", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        mDialog.dismiss();
                        Log.d(TAG,database.toString());
                    }
                });
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(topup.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int top = i + 20000;

                        mDialog.dismiss();
                        mDialog.dismiss();
                        User user = new User(Common.currentUse.name, Common.currentUse.password, Integer.toString(top), Common.currentUse.location);
                        table_user.child(Common.currentUse.username).setValue(user);
                        Toast.makeText(topup.this, "Top Up Successfully !", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        mDialog.dismiss();
                        Log.d(TAG,database.toString());
                    }
                });
            }
        });

        btn50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(topup.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int top = i + 50000;

                        mDialog.dismiss();
                        mDialog.dismiss();
                        User user = new User(Common.currentUse.name, Common.currentUse.password, Integer.toString(top), Common.currentUse.location);
                        table_user.child(Common.currentUse.username).setValue(user);
                        Toast.makeText(topup.this, "Top Up Successfully !", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        mDialog.dismiss();
                        Log.d(TAG,database.toString());
                    }
                });
            }
        });

        btn100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(topup.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int top = i + 100000;

                        mDialog.dismiss();
                        mDialog.dismiss();
                        User user = new User(Common.currentUse.name, Common.currentUse.password, Integer.toString(top), Common.currentUse.location);
                        table_user.child(Common.currentUse.username).setValue(user);
                        Toast.makeText(topup.this, "Top Up Successfully !", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        mDialog.dismiss();
                        Log.d(TAG,database.toString());
                    }
                });
            }
        });

        btn200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(topup.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int top = i + 200000;

                        mDialog.dismiss();
                        mDialog.dismiss();
                        User user = new User(Common.currentUse.name, Common.currentUse.password, Integer.toString(top), Common.currentUse.location);
                        table_user.child(Common.currentUse.username).setValue(user);
                        Toast.makeText(topup.this, "Top Up Successfully !", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        mDialog.dismiss();
                        Log.d(TAG,database.toString());
                    }
                });
            }
        });

        btn500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(topup.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int top = i + 500000;

                        mDialog.dismiss();
                        mDialog.dismiss();
                        User user = new User(Common.currentUse.name, Common.currentUse.password, Integer.toString(top), Common.currentUse.location);
                        table_user.child(Common.currentUse.username).setValue(user);
                        Toast.makeText(topup.this, "Top Up Successfully !", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        mDialog.dismiss();
                        Log.d(TAG,database.toString());
                    }
                });
            }
        });
    }
}