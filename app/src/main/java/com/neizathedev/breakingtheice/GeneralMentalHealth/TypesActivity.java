package com.neizathedev.breakingtheice.GeneralMentalHealth;

import android.app.DownloadManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
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

/* loaded from: classes6.dex */
public class TypesActivity extends AppCompatActivity {
    private static final String CHANNEL_ID = "download_notification_channel";
    private static final int DOWNLOAD_REQUEST_CODE = 1;
    private static final String FILE_NAME = "Child.docx";
    private static final String FILE_NAME1 = "suicide.docx";
    private static final String FILE_NAME2 = "Selfharm.docx";
    private static final String FILE_NAME3 = "MenMentalHealth.docx";
    private static final String FILE_NAME4 = "MentalHealthGeneral.docx";
    private static final String FILE_NAME5 = "MentalHealthTest.docx";
    private TextView Suicide;
    private TextView child;
    private StorageReference mStorageRef;
    private TextView men;
    private TextView mentalHealthGen;
    private TextView mentalHealthTest;
    private TextView selfHarm;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);
        this.mStorageRef = FirebaseStorage.getInstance().getReference();
        this.child = (TextView) findViewById(R.id.child);
        this.Suicide = (TextView) findViewById(R.id.Suicide);
        this.selfHarm = (TextView) findViewById(R.id.selfHarm);
        this.mentalHealthTest = (TextView) findViewById(R.id.mentalHealthTest);
        this.mentalHealthGen = (TextView) findViewById(R.id.mentalHealthGen);
        this.men = (TextView) findViewById(R.id.men);
        this.child.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TypesActivity.this.m320xad7aad94(view);
            }
        });
        this.Suicide.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TypesActivity.this.m321x17aa35b3(view);
            }
        });
        this.selfHarm.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TypesActivity.this.m322x81d9bdd2(view);
            }
        });
        this.mentalHealthTest.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TypesActivity.this.m323xec0945f1(view);
            }
        });
        this.mentalHealthGen.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TypesActivity.this.m324x5638ce10(view);
            }
        });
        this.men.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TypesActivity.this.m325xc068562f(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$0$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m320xad7aad94(View v) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            downloadFile();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$1$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m321x17aa35b3(View v) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            downloadFile1();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$2$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m322x81d9bdd2(View v) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            downloadFile2();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$3$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m323xec0945f1(View v) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            downloadFile3();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$4$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m324x5638ce10(View v) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            downloadFile4();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreate$5$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m325xc068562f(View v) {
        if (ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            downloadFile5();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1);
        }
    }

    private void downloadFile() {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        final File localFile = new File(downloadsDirectory, FILE_NAME);
        this.mStorageRef.child(FILE_NAME).getDownloadUrl().addOnCompleteListener(new OnCompleteListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda10
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TypesActivity.this.m314xfb1a61c5(localFile, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadFile$6$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m314xfb1a61c5(File localFile, Task task) {
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
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.ic_download).setContentTitle("Downloading Child.docx").setContentText("Download in progress").setPriority(1).setProgress(0, 0, true);
            notificationManager.notify((int) downloadId, builder.build());
            Toast.makeText(this, "Download started", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Download failed: " + task.getException(), Toast.LENGTH_SHORT).show();
    }

    private void downloadFile1() {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        final File localFile = new File(downloadsDirectory, FILE_NAME1);
        this.mStorageRef.child(FILE_NAME1).getDownloadUrl().addOnCompleteListener(new OnCompleteListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TypesActivity.this.m315x70ea26f5(localFile, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadFile1$7$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m315x70ea26f5(File localFile, Task task) {
        if (task.isSuccessful()) {
            String downloadUrl = ((Uri) task.getResult()).toString();
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
            request.setTitle(FILE_NAME1);
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
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.ic_download).setContentTitle("Downloading suicide.docx").setContentText("Download in progress").setPriority(1).setProgress(0, 0, true);
            notificationManager.notify((int) downloadId, builder.build());
            Toast.makeText(this, "Download started", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Download failed: " + task.getException(), Toast.LENGTH_SHORT).show();
    }

    private void downloadFile2() {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        final File localFile = new File(downloadsDirectory, FILE_NAME2);
        this.mStorageRef.child(FILE_NAME2).getDownloadUrl().addOnCompleteListener(new OnCompleteListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda11
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TypesActivity.this.m316x7787ab73(localFile, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadFile2$8$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m316x7787ab73(File localFile, Task task) {
        if (task.isSuccessful()) {
            String downloadUrl = ((Uri) task.getResult()).toString();
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
            request.setTitle(FILE_NAME2);
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
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.ic_download).setContentTitle("Downloading Selfharm.docx").setContentText("Download in progress").setPriority(1).setProgress(0, 0, true);
            notificationManager.notify((int) downloadId, builder.build());
            Toast.makeText(this, "Download started", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Download failed: " + task.getException(), Toast.LENGTH_SHORT).show();
    }

    private void downloadFile3() {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        final File localFile = new File(downloadsDirectory, FILE_NAME3);
        this.mStorageRef.child(FILE_NAME).getDownloadUrl().addOnCompleteListener(new OnCompleteListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TypesActivity.this.m317x7e252ff1(localFile, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadFile3$9$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m317x7e252ff1(File localFile, Task task) {
        if (task.isSuccessful()) {
            String downloadUrl = ((Uri) task.getResult()).toString();
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
            request.setTitle(FILE_NAME3);
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
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.ic_download).setContentTitle("Downloading MenMentalHealth.docx").setContentText("Download in progress").setPriority(1).setProgress(0, 0, true);
            notificationManager.notify((int) downloadId, builder.build());
            Toast.makeText(this, "Download started", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Download failed: " + task.getException(), Toast.LENGTH_SHORT).show();
    }

    private void downloadFile4() {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        final File localFile = new File(downloadsDirectory, FILE_NAME4);
        this.mStorageRef.child(FILE_NAME4).getDownloadUrl().addOnCompleteListener(new OnCompleteListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TypesActivity.this.m318xfd36f9a8(localFile, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadFile4$10$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m318xfd36f9a8(File localFile, Task task) {
        if (task.isSuccessful()) {
            String downloadUrl = ((Uri) task.getResult()).toString();
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
            request.setTitle(FILE_NAME4);
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
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.ic_download).setContentTitle("Downloading MentalHealthGeneral.docx").setContentText("Download in progress").setPriority(1).setProgress(0, 0, true);
            notificationManager.notify((int) downloadId, builder.build());
            Toast.makeText(this, "Download started", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "Download failed: " + task.getException(), Toast.LENGTH_SHORT).show();
    }

    private void downloadFile5() {
        File downloadsDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        final File localFile = new File(downloadsDirectory, FILE_NAME5);
        this.mStorageRef.child(FILE_NAME5).getDownloadUrl().addOnCompleteListener(new OnCompleteListener() { // from class: com.neizathedev.breakingtheice.GeneralMentalHealth.TypesActivity$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                TypesActivity.this.m319x58b81148(localFile, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$downloadFile5$11$com-neizathedev-breakingtheice-GeneralMentalHealth-TypesActivity  reason: not valid java name */
    public /* synthetic */ void m319x58b81148(File localFile, Task task) {
        if (task.isSuccessful()) {
            String downloadUrl = ((Uri) task.getResult()).toString();
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(downloadUrl));
            request.setTitle(FILE_NAME5);
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
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.ic_download).setContentTitle("Downloading MentalHealthTest.docx").setContentText("Download in progress").setPriority(1).setProgress(0, 0, true);
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