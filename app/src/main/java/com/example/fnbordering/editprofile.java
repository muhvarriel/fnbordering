package com.example.fnbordering;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fnbordering.Common.Common;
import com.example.fnbordering.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class editprofile extends AppCompatActivity {
    Button btnBack, btnEdtProfile;
    EditText edtName, edtPassword, edtLocation;
    TextView txtUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
        String TAG = "Edit Profile";

        txtUsername = (TextView) findViewById(R.id.txtUsername);
        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtName = (EditText)findViewById(R.id.edtName);
        edtLocation = (EditText)findViewById(R.id.edtLocation);

        btnBack = (Button)findViewById(R.id.btnBack);
        btnEdtProfile = (Button)findViewById(R.id.btnEdtProfile);

        txtUsername.setText(Common.currentUse.username);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        //InitFirebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnEdtProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(editprofile.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        mDialog.dismiss();
                        mDialog.dismiss();
                        User user = new User(edtName.getText().toString(), edtPassword.getText().toString(), Common.currentUse.balance, edtLocation.getText().toString());
                        table_user.child(txtUsername.getText().toString()).setValue(user);
                        Toast.makeText(editprofile.this, "Save successfully !", Toast.LENGTH_SHORT).show();
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