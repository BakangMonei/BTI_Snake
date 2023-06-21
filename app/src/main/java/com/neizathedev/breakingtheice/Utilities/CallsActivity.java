package com.neizathedev.breakingtheice.Utilities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.neizathedev.breakingtheice.R;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class CallsActivity extends AppCompatActivity {
    public static final int MULTIPLE_PERMISSIONS = 101;
    private static final String TAG = CallsActivity.class.getSimpleName();
    EditText number;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calls);
        this.number = (EditText) findViewById(R.id.mobnum);
        checkPermissions();
    }

    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 101:
                if (grantResults.length > 0 && grantResults[0] == 0) {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void dialCall(View view) {
        String num = this.number.getText().toString();
        if (num != null && !num.equals("")) {
            String noToDial = "tel:" + num;
            Uri number = Uri.parse(noToDial);
            Intent callIntent = new Intent("android.intent.action.CALL", number);
            if (checkPermissions()) {
                startActivity(callIntent);
                return;
            }
            return;
        }
        Toast.makeText(this, "Please enter number", Toast.LENGTH_SHORT).show();
    }

    private boolean checkPermissions() {
        String[] permissions = {"android.permission.CALL_PHONE"};
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            int result = ContextCompat.checkSelfPermission(this, p);
            if (result != 0) {
                Log.d(TAG, "Ask Permissions : " + p);
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, (String[]) listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 101);
            return false;
        }
        return true;
    }
}