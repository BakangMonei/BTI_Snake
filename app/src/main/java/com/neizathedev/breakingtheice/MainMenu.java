package com.neizathedev.breakingtheice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.neizathedev.breakingtheice.FirebaseActivities.MemberDetailsActivity;
import com.neizathedev.breakingtheice.GeneralMentalHealth.AbuseActivity;
import com.neizathedev.breakingtheice.GeneralMentalHealth.FamilyActivity;
import com.neizathedev.breakingtheice.GeneralMentalHealth.HealingActivity;
import com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity;
import com.neizathedev.breakingtheice.GeneralMentalHealth.TroubleActivity;
import com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity;
import com.neizathedev.breakingtheice.Utilities.AboutBTIActivity;
import com.neizathedev.breakingtheice.Utilities.CallsActivity;
import com.neizathedev.breakingtheice.Utilities.CameraActivity;
import com.neizathedev.breakingtheice.Utilities.ContactUsActivity;
import com.neizathedev.breakingtheice.Utilities.DownloadActivity;
import com.neizathedev.breakingtheice.Utilities.EmailActivity;
import com.neizathedev.breakingtheice.Utilities.GroupChatActivity;
import com.neizathedev.breakingtheice.Utilities.SMSActivity;
import com.neizathedev.breakingtheice.Utilities.SettingsActivity;

/* loaded from: classes5.dex */
public class MainMenu extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private ImageView abuseImageView;
    private TextView abuseTextView;
    private ImageView familyImageView;
    private TextView familyTextView;
    private ImageView healingImageView;
    private TextView healingTextView;
    private ImageView homeImageView;
    private ImageView mentalHealthImageView;
    private TextView mentalHealthTextView;
    private ImageView troubleImageView;
    private TextView troubleTextView;
    private ImageView typeImageView;
    private TextView typeTextView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ImageView imageView = (ImageView) findViewById(R.id.homeImageView);
        this.homeImageView = imageView;

        this.mentalHealthTextView = (TextView) findViewById(R.id.mentalHealthTextView);
        this.mentalHealthImageView = (ImageView) findViewById(R.id.mentalHealthImageView);
        View.OnClickListener mentalHealth = new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.MainMenu.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, MentalHealthActivity.class);
                MainMenu.this.startActivity(intent);
            }
        };
        this.mentalHealthImageView.setOnClickListener(mentalHealth);
        this.mentalHealthTextView.setOnClickListener(mentalHealth);
        this.typeImageView = (ImageView) findViewById(R.id.typeImageView);
        this.typeTextView = (TextView) findViewById(R.id.typeTextView);
        View.OnClickListener type = new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.MainMenu.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, TypesActivity.class);
                MainMenu.this.startActivity(intent);
            }
        };
        this.typeImageView.setOnClickListener(type);
        this.typeTextView.setOnClickListener(type);
        this.abuseImageView = (ImageView) findViewById(R.id.abuseImageView);
        this.abuseTextView = (TextView) findViewById(R.id.abuseTextView);
        View.OnClickListener abuse = new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.MainMenu.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, AbuseActivity.class);
                MainMenu.this.startActivity(intent);
            }
        };
        this.abuseImageView.setOnClickListener(abuse);
        this.abuseTextView.setOnClickListener(abuse);
        this.familyImageView = (ImageView) findViewById(R.id.familyImageView);
        this.familyTextView = (TextView) findViewById(R.id.familyTextView);
        View.OnClickListener family = new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.MainMenu.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, FamilyActivity.class);
                MainMenu.this.startActivity(intent);
            }
        };
        this.familyImageView.setOnClickListener(family);
        this.familyTextView.setOnClickListener(family);
        this.troubleImageView = (ImageView) findViewById(R.id.troubleImageView);
        this.troubleTextView = (TextView) findViewById(R.id.troubleTextView);
        View.OnClickListener trouble = new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.MainMenu.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, TroubleActivity.class);
                MainMenu.this.startActivity(intent);
            }
        };
        this.troubleImageView.setOnClickListener(trouble);
        this.troubleTextView.setOnClickListener(trouble);
        this.healingImageView = (ImageView) findViewById(R.id.healingImageView);
        this.healingTextView = (TextView) findViewById(R.id.healingTextView);
        View.OnClickListener healing = new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.MainMenu.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, HealingActivity.class);
                MainMenu.this.startActivity(intent);
            }
        };
        this.healingImageView.setOnClickListener(healing);
        this.healingTextView.setOnClickListener(healing);
    }

    private void startActivity(int x, int requestCode) {
    }

    public void exitApp(View view) {
        finishAffinity();
        System.exit(0);
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