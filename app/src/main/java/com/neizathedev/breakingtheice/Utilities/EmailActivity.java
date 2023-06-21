package com.neizathedev.breakingtheice.Utilities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.neizathedev.breakingtheice.R;

/* loaded from: classes7.dex */
public class EmailActivity extends AppCompatActivity {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        TextView textView = (TextView) findViewById(R.id.recipientTxtView);
        TextView textView2 = (TextView) findViewById(R.id.subjectTxtView);
        TextView textView3 = (TextView) findViewById(R.id.messageTxtView);
        final EditText recipient = (EditText) findViewById(R.id.recipient);
        final EditText subject = (EditText) findViewById(R.id.subject);
        final EditText message = (EditText) findViewById(R.id.message);
        Button sendBtn = (Button) findViewById(R.id.sendBtn);
        sendBtn.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Utilities.EmailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String receiver = recipient.getText().toString().trim();
                String sub = subject.getText().toString().trim();
                String msg = message.getText().toString().trim();
                if (receiver.isEmpty() || sub.isEmpty() || msg.isEmpty()) {
                    Toast.makeText(EmailActivity.this, "Please check if everything is filled out", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent email = new Intent("android.intent.action.SEND");
                email.putExtra("android.intent.extra.EMAIL", new String[]{receiver});
                email.putExtra("android.intent.extra.SUBJECT", sub);
                email.putExtra("android.intent.extra.TEXT", msg);
                email.setType("message/rfc822");
                EmailActivity.this.startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });
    }

    public void sendEmail() {
    }
}