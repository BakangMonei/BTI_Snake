package com.neizathedev.breakingtheice.FirebaseActivities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.neizathedev.breakingtheice.Administrators.AdministratorsActivity;
import com.neizathedev.breakingtheice.MainMenu;
import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.SocialMedia.Facebook;
import com.neizathedev.breakingtheice.SocialMedia.Google;
import com.neizathedev.breakingtheice.SocialMedia.Instagram;
import com.neizathedev.breakingtheice.SocialMedia.Twitter;

/* loaded from: classes9.dex */
public class LoginActivity extends AppCompatActivity {
    private TextInputEditText email;
    private Button login;
    private FirebaseAuth mAuth;
    private TextInputEditText password;
    private TextView registerUser;
    String mainAdmin = "Oratile Charity Wadikonyana";
    String ITAdmin = "Monei Bakang Motshegwe";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageButton instasignup = (ImageButton) findViewById(R.id.instasignup);
        ImageButton twittersignup = (ImageButton) findViewById(R.id.twittersignup);
        ImageButton fbsignup = (ImageButton) findViewById(R.id.fbsignup);
        ImageButton googlesignup = (ImageButton) findViewById(R.id.googlesignup);
        instasignup.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Please LogIn with your Instagram Credentials", Toast.LENGTH_SHORT).show();
                Intent intentInstagram = new Intent(LoginActivity.this, Instagram.class);
                startActivity(intentInstagram);
            }
        });
        fbsignup.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Please LogIn with your Facebook Credentials", Toast.LENGTH_SHORT).show();
                Intent intentFacebook = new Intent(LoginActivity.this, Facebook.class);
                LoginActivity.this.startActivity(intentFacebook);
            }
        });
        twittersignup.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Please LogIn with your Twitter Credentials", Toast.LENGTH_SHORT).show();
                Intent intentTwitter = new Intent(LoginActivity.this, Twitter.class);
                LoginActivity.this.startActivity(intentTwitter);
            }
        });
        googlesignup.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Please LogIn with your Google Credentials", Toast.LENGTH_SHORT).show();
                Intent intentGoogle = new Intent(LoginActivity.this, Google.class);
                LoginActivity.this.startActivity(intentGoogle);
            }
        });
        Button forgotPasswordBtn = (Button) findViewById(R.id.forgotPasswordBtn);
        forgotPasswordBtn.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Change Password", Toast.LENGTH_SHORT).show();
                Intent intentForgotPassword = new Intent(LoginActivity.this, ForgotPassword.class);
                LoginActivity.this.startActivity(intentForgotPassword);
            }
        });
        this.mAuth = FirebaseAuth.getInstance();
        this.email = (TextInputEditText) findViewById(R.id.email);
        this.password = (TextInputEditText) findViewById(R.id.password);
        this.login = (Button) findViewById(R.id.login);
        TextView textView = (TextView) findViewById(R.id.registerUser);
        this.registerUser = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
        this.login.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String txtEmail = LoginActivity.this.email.getText().toString().trim();
                String txtPassword = LoginActivity.this.password.getText().toString();
                if (!TextUtils.isEmpty(txtEmail) && !TextUtils.isEmpty(txtPassword)) {
                    if (!LoginActivity.this.email.getText().toString().equals("mainAdmin@btiadmin.bti.org.bw") || !LoginActivity.this.password.getText().toString().equals("charity@BTI")) {
                        if (!LoginActivity.this.email.getText().toString().equals("ITAdmin@btiadmin.bti.org.bw") || !LoginActivity.this.password.getText().toString().equals("Neiza@BTI")) {
                            LoginActivity.this.loginUser(txtEmail, txtPassword);
                            return;
                        }
                        Toast.makeText(LoginActivity.this, "Welcome " + LoginActivity.this.ITAdmin, Toast.LENGTH_SHORT).show();
                        Intent intentLogIn = new Intent(LoginActivity.this, AdministratorsActivity.class);
                        LoginActivity.this.startActivity(intentLogIn);
                        return;
                    }
                    Toast.makeText(LoginActivity.this, "Welcome " + LoginActivity.this.mainAdmin, Toast.LENGTH_SHORT).show();
                    Intent intentLogIn2 = new Intent(LoginActivity.this, AdministratorsActivity.class);
                    LoginActivity.this.startActivity(intentLogIn2);
                    return;
                }
                Toast.makeText(LoginActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginUser(String email, String password) {
        this.mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity.9
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainMenu.class);
                    // intent.addFlags(67141632);
                    LoginActivity.this.startActivity(intent);
                    LoginActivity.this.finish();
                }
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.LoginActivity.8
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception e) {
                Toast.makeText(LoginActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void SignOuting() {
        FirebaseAuth.getInstance().signOut();
    }
}