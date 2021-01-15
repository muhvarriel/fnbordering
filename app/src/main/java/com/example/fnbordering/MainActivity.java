package com.example.fnbordering;

        import android.content.Intent;
        import android.os.Handler;
        import android.os.Bundle;
        import android.os.Looper;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(MainActivity.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(MainActivity.this, homepage.class);
                            startActivity(i);
                            finish();
                        }
                    }, 3000);
                } else {
                    Toast.makeText(MainActivity.this,"Please Login",Toast.LENGTH_SHORT).show();
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent login = new Intent(MainActivity.this, login.class);
                            startActivity(login);
                            finish();
                        }
                    }, 3000);
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();

        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
}