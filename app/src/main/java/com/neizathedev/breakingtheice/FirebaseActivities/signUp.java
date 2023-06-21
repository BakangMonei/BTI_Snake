package com.neizathedev.breakingtheice.FirebaseActivities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.neizathedev.breakingtheice.R;

import java.util.HashMap;

/* loaded from: classes9.dex */
public class signUp extends AppCompatActivity {
    private FirebaseDatabase database;
    private FirebaseAuth mAuth;
    private DatabaseReference mRootRef;

    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        this.mRootRef = FirebaseDatabase.getInstance().getReference();
        this.mAuth = FirebaseAuth.getInstance();
        TextView textView = (TextView) findViewById(R.id.RegistrationName);
        TextView textView2 = (TextView) findViewById(R.id.firstNameView);
        TextView textView3 = (TextView) findViewById(R.id.lastNameView);
        TextView textView4 = (TextView) findViewById(R.id.emailView);
        TextView textView5 = (TextView) findViewById(R.id.passwordView);
        TextView textView6 = (TextView) findViewById(R.id.repassView);
        TextView textView7 = (TextView) findViewById(R.id.DOBView);
        TextView textView8 = (TextView) findViewById(R.id.genderView);
        TextView textView9 = (TextView) findViewById(R.id.phoneNumberView);
        TextView textView10 = (TextView) findViewById(R.id.postalAddressView);
        TextView textView11 = (TextView) findViewById(R.id.countryView);
        TextView textView12 = (TextView) findViewById(R.id.IDPassportView);
        final EditText registerFirstName = (EditText) findViewById(R.id.registerFirstName);
        final EditText registerLastName = (EditText) findViewById(R.id.registerLastName);
        final EditText registerEmail = (EditText) findViewById(R.id.registerEmail);
        final EditText registerPassword = (EditText) findViewById(R.id.registerPassword);
        final EditText registerRePass = (EditText) findViewById(R.id.registerRePass);
        final EditText registerDOB = (EditText) findViewById(R.id.registerDOB);
        final EditText registerGender = (EditText) findViewById(R.id.registerGender);
        final EditText registerPhoneNumber = (EditText) findViewById(R.id.registerPhoneNumber);
        final EditText registerPostalAddress = (EditText) findViewById(R.id.registerPostalAddress);
        final EditText registerCountry = (EditText) findViewById(R.id.registerCountry);
        final EditText registerIDPass = (EditText) findViewById(R.id.registerIDPass);
        final EditText registerURL = (EditText) findViewById(R.id.registerURL);
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.signUp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String email = registerEmail.getText().toString().trim();
                String firstName = registerFirstName.getText().toString();
                String lastName = registerLastName.getText().toString();
                String Password = registerPassword.getText().toString();
                String rePassword = registerRePass.getText().toString();
                String DOB = registerDOB.getText().toString();
                String Gender = registerGender.getText().toString();
                String phoneNumber = registerPhoneNumber.getText().toString();
                String Address = registerPostalAddress.getText().toString();
                String Country = registerCountry.getText().toString();
                String IDPassport = registerIDPass.getText().toString();
                String url = registerURL.getText().toString();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(firstName) && !TextUtils.isEmpty(lastName) && !TextUtils.isEmpty(Password) && !TextUtils.isEmpty(rePassword) && !TextUtils.isEmpty(DOB) && !TextUtils.isEmpty(Gender) && !TextUtils.isEmpty(phoneNumber) && !TextUtils.isEmpty(Address) && !TextUtils.isEmpty(Country) && !TextUtils.isEmpty(IDPassport)) {
                    if (!TextUtils.isEmpty(url)) {
                        if (Password.length() >= 6 && rePassword.length() >= 6) {
                            if (Password == rePassword && rePassword == Password) {
                                Toast.makeText(signUp.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                                return;
                            } else {
                                signUp.this.registerUser(email, firstName, lastName, Password, rePassword, DOB, Gender, phoneNumber, Address, Country, IDPassport, url);
                                return;
                            }
                        }
                        Toast.makeText(signUp.this, "Password Too Short !", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                Toast.makeText(signUp.this, "Please Enter All Details", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void registerUser(final String registerEmail, final String registerFirstName, final String registerLastName, final String registerPassword, final String registerRePass, final String registerDOB, final String registerGender, final String registerPhoneNumber, final String registerPostalAddress, final String registerCountry, final String registerIDPass, final String registerURL) {
        this.mAuth.createUserWithEmailAndPassword(registerEmail, registerPassword).addOnSuccessListener(new OnSuccessListener<AuthResult>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.signUp.3
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(AuthResult authResult) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("email", registerEmail);
                map.put("firstName", registerFirstName);
                map.put("lastName", registerLastName);
                map.put("Password", registerPassword);
                map.put("RePassword", registerRePass);
                map.put("DOB", registerDOB);
                map.put("Gender", registerGender);
                map.put("phoneNumber", registerPhoneNumber);
                map.put("address", registerPostalAddress);
                map.put("Country", registerCountry);
                map.put("IDPassport", registerIDPass);
                map.put("URL", registerURL);
                signUp.this.mRootRef.child("Users").child(signUp.this.mAuth.getCurrentUser().getUid()).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.signUp.3.1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(signUp.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signUp.this, LoginActivity.class);
                            signUp.this.startActivity(intent);
                            signUp.this.finish();
                        }
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.signUp.2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception e) {
                Toast.makeText(signUp.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void strongPassword(int length) {
        String combinedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$1234567890";
        char[] password = new char[length];
        if (password.toString() != combinedChars) {
            Toast.makeText(this, "Password does not meet the requirements", Toast.LENGTH_SHORT).show();
        }
    }
}