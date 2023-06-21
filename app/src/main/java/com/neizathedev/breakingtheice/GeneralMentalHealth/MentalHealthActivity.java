package com.neizathedev.breakingtheice.GeneralMentalHealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.Type2MentalHealth.ADHDActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.AnxietyActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.AutismActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.BipolarDisorderActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.BodelineActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.DepressionActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.DimentiaActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.DysthymiaActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.EatingDisorderActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.PTSDActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.PsychosisActivity;
import com.neizathedev.breakingtheice.Type2MentalHealth.SchizophreniaActivity;

/* loaded from: classes6.dex */
public class MentalHealthActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    TextView ADHD;
    TextView Anxiety;
    TextView Autism;
    TextView BipolarDisorder;
    TextView Bodeline;
    TextView Depression;
    TextView Dimentia;
    TextView Dysthymia;
    TextView EatingDisorder;
    TextView PTSD;
    TextView Psychosis;
    TextView Schizophrenia;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mental_health);
        TextView textView = (TextView) findViewById(R.id.Schizophrenia);
        this.Schizophrenia = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, SchizophreniaActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.boderlinePersonalityDisorder);
        this.Bodeline = textView2;
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, BodelineActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView3 = (TextView) findViewById(R.id.Dysthymia);
        this.Dysthymia = textView3;
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, DysthymiaActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView4 = (TextView) findViewById(R.id.Psychosis);
        this.Psychosis = textView4;
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, PsychosisActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView5 = (TextView) findViewById(R.id.PTSD);
        this.PTSD = textView5;
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, PTSDActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView6 = (TextView) findViewById(R.id.eatingDisorder);
        this.EatingDisorder = textView6;
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, EatingDisorderActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView7 = (TextView) findViewById(R.id.Dimentia);
        this.Dimentia = textView7;
        textView7.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, DimentiaActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView8 = (TextView) findViewById(R.id.bipolarDisorder);
        this.BipolarDisorder = textView8;
        textView8.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, BipolarDisorderActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView9 = (TextView) findViewById(R.id.Autism);
        this.Autism = textView9;
        textView9.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, AutismActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView10 = (TextView) findViewById(R.id.ADHD);
        this.ADHD = textView10;
        textView10.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, ADHDActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView11 = (TextView) findViewById(R.id.Depression);
        this.Depression = textView11;
        textView11.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, DepressionActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
        TextView textView12 = (TextView) findViewById(R.id.Anxiety);
        this.Anxiety = textView12;
        textView12.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.MentalHealthActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent x = new Intent(MentalHealthActivity.this, AnxietyActivity.class);
                MentalHealthActivity.this.startActivity(x);
            }
        });
    }
}