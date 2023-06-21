package com.neizathedev.breakingtheice.GeneralMentalHealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.Type1Abuse.AbusingActivity;

/* loaded from: classes6.dex */
public class AbuseActivity extends AppCompatActivity {
    private TextView Abuse;
    private TextView Bullying;
    private TextView Crime;
    private TextView GBV;
    private TextView Narcisim;
    private TextView Rape;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abuse);
        this.GBV = (TextView) findViewById(R.id.GBV);
        this.Rape = (TextView) findViewById(R.id.Rape);
        this.Bullying = (TextView) findViewById(R.id.Bullying);
        this.Crime = (TextView) findViewById(R.id.Crime);
        this.Narcisim = (TextView) findViewById(R.id.Narcisim);
        TextView textView = (TextView) findViewById(R.id.Abuse);
        this.Abuse = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.AbuseActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(AbuseActivity.this, AbusingActivity.class);
                AbuseActivity.this.startActivity(intent);
            }
        });
    }
}