package com.neizathedev.breakingtheice.FirebaseActivities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.SQLiteDatabase.DatabaseHelper;
import java.util.HashMap;

/* loaded from: classes9.dex */
public class EditProfilePage extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 100;
    private static final int IMAGEPICK_GALLERY_REQUEST = 300;
    private static final int IMAGE_PICKCAMERA_REQUEST = 400;
    private static final int STORAGE_REQUEST = 200;
    String[] cameraPermission;
    DatabaseReference databaseReference;
    TextView editlastname;
    TextView editname;
    TextView editpassword;
    private FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseUser firebaseUser;
    Uri imageuri;
    ProgressDialog pd;
    String profileOrCoverPhoto;
    TextView profilepic;
    ImageView set;
    String[] storagePermission;
    StorageReference storageReference;
    String storagepath = "Users_Profile_Cover_image/";
    String uid;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile_page);
        this.profilepic = (TextView) findViewById(R.id.profilepic);
        this.editname = (TextView) findViewById(R.id.editname);
        this.editlastname = (TextView) findViewById(R.id.editlastname);
        this.set = (ImageView) findViewById(R.id.setting_profile_image);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.pd = progressDialog;
        progressDialog.setCanceledOnTouchOutside(false);
        this.editpassword = (TextView) findViewById(R.id.changepassword);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        this.firebaseAuth = firebaseAuth;
        this.firebaseUser = firebaseAuth.getCurrentUser();
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        this.storageReference = FirebaseStorage.getInstance().getReference();
        DatabaseReference reference = this.firebaseDatabase.getReference("Users");
        this.databaseReference = reference;
        this.cameraPermission = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
        this.storagePermission = new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"};
        Query query = reference.orderByChild("email").equalTo(this.firebaseUser.getEmail());
        query.addValueEventListener(new ValueEventListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.1
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String image = "" + dataSnapshot1.child("image").getValue();
                    try {
                        Glide.with((FragmentActivity) EditProfilePage.this).load(image).into(EditProfilePage.this.set);
                    } catch (Exception e) {
                    }
                }
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        this.editpassword.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EditProfilePage.this.pd.setMessage("Changing Password");
                EditProfilePage.this.showPasswordChangeDailog();
            }
        });
        this.profilepic.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EditProfilePage.this.pd.setMessage("Updating Profile Picture");
                EditProfilePage.this.profileOrCoverPhoto = "image";
                EditProfilePage.this.showImagePicDialog();
            }
        });
        this.editname.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EditProfilePage.this.pd.setMessage("Updating Name");
                EditProfilePage.this.showNamephoneupdate("firstName");
            }
        });
        this.editlastname.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EditProfilePage.this.pd.setMessage("Updating LastName");
                EditProfilePage.this.showNamephoneupdate("lastName");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Query query = this.databaseReference.orderByChild("email").equalTo(this.firebaseUser.getEmail());
        query.addValueEventListener(new ValueEventListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.6
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String image = "" + dataSnapshot1.child("URL").getValue();
                    try {
                        Glide.with((FragmentActivity) EditProfilePage.this).load(image).into(EditProfilePage.this.set);
                    } catch (Exception e) {
                    }
                }
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        this.editpassword.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.7
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EditProfilePage.this.pd.setMessage("Changing Password");
                EditProfilePage.this.showPasswordChangeDailog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        Query query = this.databaseReference.orderByChild("Users").equalTo(this.firebaseUser.getEmail());
        query.addValueEventListener(new ValueEventListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.8
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String image = "" + dataSnapshot1.child("Users").getValue();
                    try {
                        Glide.with((FragmentActivity) EditProfilePage.this).load(image).into(EditProfilePage.this.set);
                    } catch (Exception e) {
                    }
                }
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }
        });
        this.editpassword.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.9
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                EditProfilePage.this.pd.setMessage("Changing Password");
                EditProfilePage.this.showPasswordChangeDailog();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean checkStoragePermission() {
        boolean result = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        return Boolean.valueOf(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestStoragePermission() {
        requestPermissions(this.storagePermission, 200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean checkCameraPermission() {
        boolean z = true;
        boolean result = ContextCompat.checkSelfPermission(this, "android.permission.CAMERA") == 0;
        boolean result1 = ContextCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        if (!result || !result1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestCameraPermission() {
        requestPermissions(this.cameraPermission, 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPasswordChangeDailog() {
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_update_password, (ViewGroup) null);
        final EditText oldpass = (EditText) view.findViewById(R.id.oldpasslog);
        final EditText newpass = (EditText) view.findViewById(R.id.newpasslog);
        Button editpass = (Button) view.findViewById(R.id.updatepass);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();
        editpass.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.10
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                String oldp = oldpass.getText().toString().trim();
                String newp = newpass.getText().toString().trim();
                if (TextUtils.isEmpty(oldp)) {
                    Toast.makeText(EditProfilePage.this, "Current Password cant be empty", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(newp)) {
                    Toast.makeText(EditProfilePage.this, "New Password cant be empty", Toast.LENGTH_SHORT).show();
                } else {
                    dialog.dismiss();
                    EditProfilePage.this.updatePassword(oldp, newp);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePassword(String oldp, final String newp) {
        this.pd.show();
        final FirebaseUser user = this.firebaseAuth.getCurrentUser();
        AuthCredential authCredential = EmailAuthProvider.getCredential(user.getEmail(), oldp);
        user.reauthenticate(authCredential).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.12
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(Void aVoid) {
                user.updatePassword(newp).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.12.2
                    @Override // com.google.android.gms.tasks.OnSuccessListener
                    public void onSuccess(Void aVoid2) {
                        EditProfilePage.this.pd.dismiss();
                        Toast.makeText(EditProfilePage.this, "Changed Password", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.12.1
                    @Override // com.google.android.gms.tasks.OnFailureListener
                    public void onFailure(Exception e) {
                        EditProfilePage.this.pd.dismiss();
                        Toast.makeText(EditProfilePage.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.11
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception e) {
                EditProfilePage.this.pd.dismiss();
                Toast.makeText(EditProfilePage.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNamephoneupdate(final String key) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Update" + key);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        System.out.println("Check *EditProfilePage.java* the above code this print code line");
        layout.setPadding(10, 10, 10, 10);
        final EditText editText = new EditText(this);
        editText.setHint("Enter" + key);
        layout.addView(editText);
        builder.setView(layout);
        builder.setPositiveButton("Update", new DialogInterface.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.13
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                final String value = editText.getText().toString().trim();
                if (!TextUtils.isEmpty(value)) {
                    EditProfilePage.this.pd.show();
                    HashMap<String, Object> result = new HashMap<>();
                    result.put(key, value);
                    EditProfilePage.this.databaseReference.child(EditProfilePage.this.firebaseUser.getUid()).updateChildren(result).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.13.2
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public void onSuccess(Void aVoid) {
                            EditProfilePage.this.pd.dismiss();
                            Toast.makeText(EditProfilePage.this, " updated ", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.13.1
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public void onFailure(Exception e) {
                            EditProfilePage.this.pd.dismiss();
                            Toast.makeText(EditProfilePage.this, "Unable to update", Toast.LENGTH_SHORT).show();
                        }
                    });
                    if (key.equals(DatabaseHelper.COLUMN_NAME)) {
                        final DatabaseReference databaser = FirebaseDatabase.getInstance().getReference("Users");
                        Query query = databaser.orderByChild("uid").equalTo(EditProfilePage.this.uid);
                        query.addValueEventListener(new ValueEventListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.13.3
                            @Override // com.google.firebase.database.ValueEventListener
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                                    databaser.getKey();
                                    dataSnapshot1.getRef().child("Users").setValue(value);
                                }
                            }

                            @Override // com.google.firebase.database.ValueEventListener
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });
                        return;
                    }
                    return;
                }
                Toast.makeText(EditProfilePage.this, "Unable to update", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.14
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                EditProfilePage.this.pd.dismiss();
            }
        });
        builder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showImagePicDialog() {
        String[] options = {"Camera", "Gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick Image From");
        builder.setItems(options, new DialogInterface.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.15
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    if (!EditProfilePage.this.checkCameraPermission().booleanValue()) {
                        EditProfilePage.this.requestCameraPermission();
                    } else {
                        EditProfilePage.this.pickFromCamera();
                    }
                } else if (which == 1) {
                    if (!EditProfilePage.this.checkStoragePermission().booleanValue()) {
                        EditProfilePage.this.requestStoragePermission();
                    } else {
                        EditProfilePage.this.pickFromGallery();
                    }
                }
            }
        });
        builder.create().show();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1) {
            if (requestCode == 300) {
                Uri data2 = data.getData();
                this.imageuri = data2;
                uploadProfileCoverPhoto(data2);
            }
            if (requestCode == 400) {
                uploadProfileCoverPhoto(this.imageuri);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        boolean writeStorageaccepted;
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100:
                if (grantResults.length > 0) {
                    boolean camera_accepted = grantResults[0] == 0;
                    writeStorageaccepted = grantResults[1] == 0;
                    if (camera_accepted && writeStorageaccepted) {
                        pickFromCamera();
                        return;
                    } else {
                        Toast.makeText(this, "Please Enable Camera and Storage Permissions", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                return;
            case 200:
                if (grantResults.length > 0) {
                    writeStorageaccepted = grantResults[0] == 0;
                    if (writeStorageaccepted) {
                        pickFromGallery();
                        return;
                    } else {
                        Toast.makeText(this, "Please Enable Storage Permissions", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pickFromCamera() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", "Temp_pic");
        contentValues.put("description", "Temp Description");
        this.imageuri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        Intent camerIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        camerIntent.putExtra("output", this.imageuri);
        startActivityForResult(camerIntent, 400);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pickFromGallery() {
        Intent galleryIntent = new Intent("android.intent.action.PICK");
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, 300);
    }

    private void uploadProfileCoverPhoto(Uri uri) {
        this.pd.show();
        String filepathname = this.storagepath + "" + this.profileOrCoverPhoto + "_" + this.firebaseUser.getUid();
        StorageReference storageReference1 = this.storageReference.child(filepathname);
        storageReference1.putFile(uri).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<UploadTask.TaskSnapshot>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.17
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                do {
                } while (!uriTask.isSuccessful());
                Uri downloadUri = uriTask.getResult();
                if (uriTask.isSuccessful()) {
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put(EditProfilePage.this.profileOrCoverPhoto, downloadUri.toString());
                    EditProfilePage.this.databaseReference.child(EditProfilePage.this.firebaseUser.getUid()).updateChildren(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.17.2
                        @Override // com.google.android.gms.tasks.OnSuccessListener
                        public void onSuccess(Void aVoid) {
                            EditProfilePage.this.pd.dismiss();
                            Toast.makeText(EditProfilePage.this, "Updated", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.17.1
                        @Override // com.google.android.gms.tasks.OnFailureListener
                        public void onFailure(Exception e) {
                            EditProfilePage.this.pd.dismiss();
                            Toast.makeText(EditProfilePage.this, "Error Updating ", Toast.LENGTH_SHORT).show();
                        }
                    });
                    return;
                }
                EditProfilePage.this.pd.dismiss();
                Toast.makeText(EditProfilePage.this, "Error", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.EditProfilePage.16
            @Override // com.google.android.gms.tasks.OnFailureListener
            public void onFailure(Exception e) {
                EditProfilePage.this.pd.dismiss();
                Toast.makeText(EditProfilePage.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}