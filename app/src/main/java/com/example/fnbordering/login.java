package com.example.fnbordering;

        import android.app.ProgressDialog;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
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

public class login extends AppCompatActivity {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    TextView btnNoAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtPassword = (EditText)findViewById(R.id.edtPassword);
        edtUsername = (EditText)findViewById(R.id.edtUsername);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        btnNoAccount = (TextView)findViewById(R.id.btnNoAccount);

        btnNoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(login.this, register.class);
                startActivity(register);
            }
        });

        //InitFirebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog mDialog = new ProgressDialog(login.this);
                mDialog.setMessage("Please waiting...");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        //Check if user not exist in database
                        if (snapshot.child(edtUsername.getText().toString()).exists()) {
                            //Get User Information
                            mDialog.dismiss();
                            User user = snapshot.child(edtUsername.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                Intent success= new Intent(login.this,homepage.class);
                                Common.currentUse=user;
                                startActivity(success);
                                finish();
                            } else {
                                Toast.makeText(login.this, "Sign in failed !!!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            mDialog.dismiss();
                            Toast.makeText(login.this, "User not exist", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
    }
}
