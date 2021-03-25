package com.example.demoekzerch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LaunchScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_screen);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(LaunchScreen.this, SignIn.class);
                startActivity(i);
            }
        };
        Handler h = new Handler();
        h.postDelayed(r,3000);
    }
}
