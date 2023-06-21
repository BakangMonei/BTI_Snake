package com.neizathedev.breakingtheice.SocialMedia;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.neizathedev.breakingtheice.R;

/* loaded from: classes10.dex */
public class Google extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google);
        Button button = (Button) findViewById(R.id.googleSignIn);
        EditText editText = (EditText) findViewById(R.id.googleUsername);
        EditText editText2 = (EditText) findViewById(R.id.googlePassword);
    }
}