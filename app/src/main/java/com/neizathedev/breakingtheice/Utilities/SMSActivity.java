package com.neizathedev.breakingtheice.Utilities;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.neizathedev.breakingtheice.R;

/* loaded from: classes7.dex */
public class SMSActivity extends AppCompatActivity {
    Button btn_send;
    EditText et_contact;
    EditText et_message;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        this.btn_send = (Button) findViewById(R.id.btn_send);
        this.et_contact = (EditText) findViewById(R.id.et_contact);
        this.et_message = (EditText) findViewById(R.id.et_message);
        PermissionToConnect();
        this.btn_send.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Utilities.SMSActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String number = SMSActivity.this.et_contact.getText().toString();
                String message = SMSActivity.this.et_message.getText().toString();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, message, null, null);
                    Toast.makeText(SMSActivity.this, "Sent", 0).show();
                } catch (Exception e) {
                    Toast.makeText(SMSActivity.this, "Sending Failed", 0).show();
                }
            }
        });
    }

    private void PermissionToConnect() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.SEND_SMS") != 0) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.SEND_SMS")) {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.SEND_SMS"}, 1);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{"android.permission.SEND_SMS"}, 1);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                if (ContextCompat.checkSelfPermission(this, "android.permission.SEND_SMS") == 0) {
                    Toast.makeText(this, "Access", 0).show();
                    return;
                }
                return;
            }
            Toast.makeText(this, "Denied", 0).show();
        }
    }
}