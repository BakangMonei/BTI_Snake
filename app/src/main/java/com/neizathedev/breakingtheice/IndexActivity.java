package com.neizathedev.breakingtheice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

/* loaded from: classes5.dex */
public class IndexActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
    }

    private void startActivity(int x, int requestCode) {
    }

    public void logOut(View view) {
        FirebaseAuth.getInstance().signOut();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == -1) {
            String result = data.getStringExtra("result");
            Toast.makeText(this, "Result: " + result, Toast.LENGTH_SHORT).show();
        }
    }
}