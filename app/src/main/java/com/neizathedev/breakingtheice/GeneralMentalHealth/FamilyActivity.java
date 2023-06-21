package com.neizathedev.breakingtheice.GeneralMentalHealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.Type3Family.FamilyIssuesActivity;

/* loaded from: classes6.dex */
public class FamilyActivity extends AppCompatActivity {
    private TextView AbsentFathers;
    private TextView ParentingStruggles;
    private TextView Pregnancy;
    private TextView ToxicParenting;
    private TextView divorce;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        TextView textView = (TextView) findViewById(R.id.AbsentFathers);
        this.AbsentFathers = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.FamilyActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(FamilyActivity.this, FamilyIssuesActivity.class);
                FamilyActivity.this.startActivity(intent);
            }
        });
        this.Pregnancy = (TextView) findViewById(R.id.Pregnancy);
        this.ParentingStruggles = (TextView) findViewById(R.id.ParentingStruggles);
        this.ToxicParenting = (TextView) findViewById(R.id.ToxicParenting);
        this.divorce = (TextView) findViewById(R.id.divorce);
    }
}