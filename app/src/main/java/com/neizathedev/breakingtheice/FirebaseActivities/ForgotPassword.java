package com.neizathedev.breakingtheice.FirebaseActivities;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.neizathedev.breakingtheice.R;

/* loaded from: classes9.dex */
public class ForgotPassword extends AppCompatActivity {
    private FirebaseAuth auth;
    private Button btnReset;
    private EditText inputEmail;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        this.inputEmail = (EditText) findViewById(R.id.inputEmail);
        this.btnReset = (Button) findViewById(R.id.btnReset);
        this.auth = FirebaseAuth.getInstance();
        this.btnReset.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.ForgotPassword.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String email = ForgotPassword.this.inputEmail.getText().toString().trim();
                if (!TextUtils.isEmpty(email)) {
                    ForgotPassword.this.auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.ForgotPassword.1.1
                        @Override // com.google.android.gms.tasks.OnCompleteListener
                        public void onComplete(Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(ForgotPassword.this, "We have sent you instructions to reset your password!", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(ForgotPassword.this, "Failed to send reset email!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(ForgotPassword.this.getApplication(), "Enter your registered email id", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}