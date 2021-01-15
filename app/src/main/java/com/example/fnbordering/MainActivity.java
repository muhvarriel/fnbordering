package com.example.fnbordering;

        import android.content.Intent;
        import android.os.Handler;
        import android.os.Bundle;
        import android.os.Looper;

        import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent login = new Intent(MainActivity.this, login.class);
                startActivity(login);
                finish();
            }
        }, 2000);
    }
}