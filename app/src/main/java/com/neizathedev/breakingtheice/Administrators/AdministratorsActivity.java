package com.neizathedev.breakingtheice.Administrators;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage;
import com.neizathedev.breakingtheice.FirebaseActivities.ProfileActivity;
import com.neizathedev.breakingtheice.FirebaseActivities.signUp;
import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.Utilities.CallsActivity;
import com.neizathedev.breakingtheice.Utilities.EmailActivity;
import com.neizathedev.breakingtheice.Utilities.SMSActivity;

public class AdministratorsActivity extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrators);
        ImageView addNewImageView = (ImageView) findViewById(R.id.addNewImageView);
        ImageView updateUserImageView = (ImageView) findViewById(R.id.updateUserImageView);
        ImageView viewUserImageView = (ImageView) findViewById(R.id.viewUserImageView);
        ImageView imageView = (ImageView) findViewById(R.id.deleteUserImageView);
        ImageView sendSMSImageView = (ImageView) findViewById(R.id.sendSMSImageView);
        ImageView sendEmailImageView = (ImageView) findViewById(R.id.sendEmailImageView);
        ImageView makeCallImageView = (ImageView) findViewById(R.id.makeCallImageView);
        TextView textView = (TextView) findViewById(R.id.administratorTextView);
        TextView addNewTextView = (TextView) findViewById(R.id.addNewTextView);
        TextView updateUserTextView = (TextView) findViewById(R.id.updateUserTextView);
        TextView viewUserTextView = (TextView) findViewById(R.id.viewUserTextView);
        TextView textView2 = (TextView) findViewById(R.id.deleteUserTextView);
        TextView sendSMSTextView = (TextView) findViewById(R.id.sendSMSTextView);
        TextView sendEmailTextView = (TextView) findViewById(R.id.sendEmailTextView);
        TextView makeCallTextView = (TextView) findViewById(R.id.makeCallTextView);
        addNewImageView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, signUp.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        addNewTextView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, signUp.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        sendSMSImageView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, SMSActivity.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        sendSMSTextView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, SMSActivity.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        sendEmailImageView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, EmailActivity.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        sendEmailTextView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, EmailActivity.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        makeCallImageView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, CallsActivity.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        makeCallTextView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, CallsActivity.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        updateUserTextView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, EditProfilePage.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        updateUserImageView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent add = new Intent(AdministratorsActivity.this, EditProfilePage.class);
                AdministratorsActivity.this.startActivity(add);
            }
        });
        viewUserImageView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent v = new Intent(AdministratorsActivity.this, ProfileActivity.class);
                AdministratorsActivity.this.startActivity(v);
            }
        });
        viewUserTextView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Administrators.AdministratorsActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent v = new Intent(AdministratorsActivity.this, ProfileActivity.class);
                AdministratorsActivity.this.startActivity(v);
            }
        });
    }
}