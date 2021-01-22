package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fnbordering.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class register extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtName, edtEmail;
    Button btnBack, btnSignup;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        String TAG = "Register";

        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtName = (EditText)findViewById(R.id.edtName);
        edtUsername = (EditText)findViewById(R.id.edtUsername);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        btnBack = (Button)findViewById(R.id.btnBack);
        btnSignup = (Button)findViewById(R.id.btnSignup);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //InitFirebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(register.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        //Check if already username
                        if (edtUsername.getText().toString().isEmpty()) {
                            mDialog.dismiss();
                            Toast.makeText(register.this, "Please fill Username", Toast.LENGTH_SHORT).show();
                        } else if (edtEmail.getText().toString().isEmpty()) {
                            mDialog.dismiss();
                            Toast.makeText(register.this, "Please fill Email", Toast.LENGTH_SHORT).show();
                        } else if (edtName.getText().toString().isEmpty()) {
                            mDialog.dismiss();
                            Toast.makeText(register.this, "Please fill Name", Toast.LENGTH_SHORT).show();
                        } else if (edtPassword.getText().toString().isEmpty()) {
                            mDialog.dismiss();
                            Toast.makeText(register.this, "Please fill Password", Toast.LENGTH_SHORT).show();
                        } else if (snapshot.child(edtUsername.getText().toString()).exists()) {
                            mDialog.dismiss();
                            Toast.makeText(register.this, "Username already register", Toast.LENGTH_SHORT).show();
                        } else if (edtPassword.getText().toString().length() <= 5) {
                            mDialog.dismiss();
                            Toast.makeText(register.this, "Minimum password 6 character", Toast.LENGTH_SHORT).show();
                        } else {
                            if (edtEmail.getText().toString().trim().matches(emailPattern)) {
                                mDialog.dismiss();
                                User user = new User(edtName.getText().toString(), edtPassword.getText().toString(), "0", "none", edtEmail.getText().toString());
                                table_user.child(edtUsername.getText().toString()).setValue(user);
                                Toast.makeText(register.this, "Register successfully !", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                mDialog.dismiss();
                                Toast.makeText(register.this, "Invalid email address", Toast.LENGTH_SHORT).show();
                            }
                        }
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