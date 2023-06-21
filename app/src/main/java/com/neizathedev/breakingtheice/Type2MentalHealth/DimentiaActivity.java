package com.neizathedev.breakingtheice.Type2MentalHealth;

import android.app.DownloadManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.neizathedev.breakingtheice.R;

import java.io.File;

/* loaded from: classes3.dex */
public class DimentiaActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "download_notification_channel";
    private static final int DOWNLOAD_REQUEST_CODE = 1;
    private static final String FILE_NAME = "Dimentia.docx";
    private Button mDownloadButton;
    private StorageReference mStorageRef;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dimentia);
        this.mStorageRef = FirebaseStorage.getInstance().getReference();
        Button button = (Button) findViewById(R.id.dimentiadownloadButton);
        this.mDownloadButton = button;
        button.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Type2MentalHealth.DimentiaActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DimentiaActivity.this.m341x934a452e(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$0$com-neizathedev-breakingtheice-Type2MentalHealth-DimentiaActivity  reason: not valid java name */
    public /* synthetic */ void m341x934a452e(View v) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            downloadFile();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    private void downloadFile() {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        final File localFile = new File(downloadsDirectory, FILE_NAME);
        this.mStorageRef.child(FILE_NAME).getDownloadUrl().addOnCompleteListener(new OnCompleteListener() { // from class: com.neizathedev.breakingtheice.Type2MentalHealth.DimentiaActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                DimentiaActivity.this.m340xaed9ac58(localFile, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadFile$1$com-neizathedev-breakingtheice-Type2MentalHealth-DimentiaActivity  reason: not valid java name */
    public /* synthetic */ void m340xaed9ac58(File localFile, Task task) {
        if (task.isSuccessful()) {
            String downloadUrl = ((Uri) task.getResult()).toString();
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
            request.setTitle(FILE_NAME);
            request.setDescription("Downloading file...");
            request.setNotificationVisibility(1);
            request.setDestinationUri(Uri.fromFile(localFile));
            DownloadManager downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            long downloadId = downloadManager.enqueue(request);
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Download Notification", NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("Notification for file download");
            channel.enableLights(true);
            channel.setLightColor(-16776961);
            channel.enableVibration(true);
            notificationManager.createNotificationChannel(channel);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.ic_download).setContentTitle("Downloading Dimentia.docx").setContentText("Download in progress").setPriority(1).setProgress(0, 0, true);
            notificationManager.notify((int) downloadId, builder.build());
            Toast.makeText(this, "Download started", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Download failed: " + task.getException(), Toast.LENGTH_SHORT).show();
    }

    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == 0) {
                downloadFile();
            } else {
                Toast.makeText(this, "Permission denied. Can't download the file.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}