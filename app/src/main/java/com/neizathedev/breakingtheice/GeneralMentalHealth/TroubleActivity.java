package com.neizathedev.breakingtheice.GeneralMentalHealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.Type5Trouble.AddictionActivity;

/* loaded from: classes6.dex */
public class TroubleActivity extends AppCompatActivity {
    private TextView Addiction;
    private TextView academicStruggle;
    private TextView alcoholAndDrugs;
    private TextView grief;
    private TextView poverty;
    private TextView procrastination;
    private TextView rebel;
    private TextView trauma;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trouble);
        TextView textView = (TextView) findViewById(R.id.Addiction);
        this.Addiction = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TroubleActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(TroubleActivity.this, AddictionActivity.class);
                TroubleActivity.this.startActivity(intent);
            }
        });
    }
}