package com.neizathedev.breakingtheice.GeneralMentalHealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.Type4Health.HealActivity;

/* loaded from: classes6.dex */
public class HealingActivity extends AppCompatActivity {
    private TextView Healing;
    private TextView Therapy;
    private TextView dealingWithFam;
    private TextView quotes;
    private TextView sbrana;
    private TextView selfCare;
    private TextView selfDev;
    private TextView someOrgs;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healing);
        TextView textView = (TextView) findViewById(R.id.Healing);
        this.Healing = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.HealingActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(HealingActivity.this, HealActivity.class);
                HealingActivity.this.startActivity(intent);
            }
        });
        this.Therapy = (TextView) findViewById(R.id.Therapy);
        this.dealingWithFam = (TextView) findViewById(R.id.dealingWithFam);
        this.selfCare = (TextView) findViewById(R.id.selfCare);
        this.selfDev = (TextView) findViewById(R.id.selfDev);
        this.quotes = (TextView) findViewById(R.id.quotes);
        this.sbrana = (TextView) findViewById(R.id.sbrana);
        this.someOrgs = (TextView) findViewById(R.id.someOrgs);
    }
}