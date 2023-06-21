package com.neizathedev.breakingtheice.FirebaseActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.neizathedev.breakingtheice.R;

/* loaded from: classes9.dex */
public class LauncherActivity extends AppCompatActivity {
    private Button btnLogin;
    private Button btnRegister;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        this.btnLogin = (Button) findViewById(R.id.btn_login);
        Button button = (Button) findViewById(R.id.btn_register);
        this.btnRegister = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LauncherActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LauncherActivity.this.startActivity(new Intent(LauncherActivity.this, RegisterActivity.class));
            }
        });
        this.btnLogin.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LauncherActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LauncherActivity.this.startActivity(new Intent(LauncherActivity.this, LoginActivity.class));
            }
        });
    }
}