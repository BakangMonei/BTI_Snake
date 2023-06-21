package com.neizathedev.breakingtheice.SocialMedia;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.neizathedev.breakingtheice.R;

/* loaded from: classes10.dex */
public class Facebook extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        MaterialButton fbLogin = (MaterialButton) findViewById(R.id.fbLogin);
        EditText editText = (EditText) findViewById(R.id.fbPassword);
        EditText editText2 = (EditText) findViewById(R.id.fbUsername);
        Button button = (Button) findViewById(R.id.forgotFBPassBtn);
        Button button2 = (Button) findViewById(R.id.newFBAccountBtn);
        fbLogin.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.SocialMedia.Facebook.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }
}