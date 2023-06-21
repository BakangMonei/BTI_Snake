package com.neizathedev.breakingtheice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity;

/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 3:29 PM
 */
/* loaded from: classes5.dex */
public class MainActivity extends AppCompatActivity {
    Handler handler;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = (ImageView) findViewById(R.id.logo_id);
        Toast.makeText(this, "Hello There", Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        this.handler = handler;
        handler.postDelayed(new Runnable() { // from class: com.neizathedev.breakingtheice.MainActivity.1
            @Override // java.lang.Runnable
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        }, 2000L);
    }
}