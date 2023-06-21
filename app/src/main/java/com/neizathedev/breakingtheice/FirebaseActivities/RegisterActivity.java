package com.neizathedev.breakingtheice.FirebaseActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.SQLiteDatabase.DatabaseHelper;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class RegisterActivity extends AppCompatActivity {
    private TextInputEditText email;
    private TextInputEditText fullName;
    private TextView loginUser;
    private FirebaseAuth mAuth;
    private DatabaseReference mRootRef;
    private TextInputEditText mobileNumber;
    private TextInputEditText password;
    ProgressDialog pd;
    private Button register;
    private TextInputEditText username;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.mRootRef = FirebaseDatabase.getInstance().getReference();
        this.mAuth = FirebaseAuth.getInstance();
        this.pd = new ProgressDialog(this);
        this.username = (TextInputEditText) findViewById(R.id.user_name);
        this.fullName = (TextInputEditText) findViewById(R.id.full_name);
        this.mobileNumber = (TextInputEditText) findViewById(R.id.mobile_number);
        this.email = (TextInputEditText) findViewById(R.id.email);
        this.password = (TextInputEditText) findViewById(R.id.password);
        this.register = (Button) findViewById(R.id.register_user);
        TextView textView = (TextView) findViewById(R.id.login_user);
        this.loginUser = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.RegisterActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RegisterActivity.this.startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        this.register.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.RegisterActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String txtUsername = RegisterActivity.this.username.getText().toString();
                String txtFullName = RegisterActivity.this.fullName.getText().toString();
                String txtMobile = RegisterActivity.this.mobileNumber.getText().toString();
                String txtEmail = RegisterActivity.this.email.getText().toString().trim();
                String txtPassword = RegisterActivity.this.password.getText().toString();
                if (TextUtils.isEmpty(txtUsername) || TextUtils.isEmpty(txtFullName) || TextUtils.isEmpty(txtMobile) || TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)) {
                    Toast.makeText(RegisterActivity.this, "Please Enter All Details", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.length() >= 6) {
                    RegisterActivity.this.registerUser(txtUsername, txtFullName, txtMobile, txtEmail, txtPassword);
                } else {
                    Toast.makeText(RegisterActivity.this, "Password Too Short !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerUser(final String username, final String fullName, final String mobileNumber, final String email, String password) {
        this.pd.setMessage("Please Wait!");
        this.pd.show();
        this.mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.RegisterActivity.4
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(AuthResult authResult) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("names", fullName);
                map.put("email", email);
                map.put("mobile", mobileNumber);
                map.put("username", username);
                map.put(DatabaseHelper.COLUMN_ID, RegisterActivity.this.mAuth.getCurrentUser().getUid());
                map.put("profileimageurl", "default");
                RegisterActivity.this.mRootRef.child("Users").child(RegisterActivity.this.mAuth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.RegisterActivity.4.1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful()) {
                            RegisterActivity.this.pd.dismiss();
                            Toast.makeText(RegisterActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            // intent.addFlags(67141632);
                            RegisterActivity.this.startActivity(intent);
                            RegisterActivity.this.finish();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.RegisterActivity.3
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception e) {
                RegisterActivity.this.pd.dismiss();
                Toast.makeText(RegisterActivity.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}