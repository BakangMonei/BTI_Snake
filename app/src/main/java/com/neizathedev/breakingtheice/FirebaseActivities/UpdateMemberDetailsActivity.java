package com.neizathedev.breakingtheice.FirebaseActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.neizathedev.breakingtheice.Model.Member;
import com.neizathedev.breakingtheice.R;
import com.neizathedev.breakingtheice.SQLiteDatabase.DatabaseHelper;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

/* loaded from: classes9.dex */
public class UpdateMemberDetailsActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    ImageButton btnClose;
    Button btnEditProfilePic;
    Button btnUpdateUserProfile;
    String currUserEmail;
    String currUserFullnames;
    String currUserName;
    String currentUserId;
    String currentUserMobile;
    String currentUserProfPicUrl;
    private Uri imageUri;
    private String imageUrl;
    ProgressDialog pd;
    ImageView profileImage;
    EditText txtFullNames;
    EditText txtUserName;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_member_details);
        Intent userID = getIntent();
        String receivedID = userID.getStringExtra("memberID");
        this.txtFullNames = (EditText) findViewById(R.id.full_names);
        this.txtUserName = (EditText) findViewById(R.id.username);
        this.btnUpdateUserProfile = (Button) findViewById(R.id.btn_update_profile);
        this.btnEditProfilePic = (Button) findViewById(R.id.btn_edit_pic);
        ImageButton imageButton = (ImageButton) findViewById(R.id.img_close);
        this.btnClose = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.UpdateMemberDetailsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateMemberDetailsActivity.this.finish();
            }
        });
        this.btnEditProfilePic.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.UpdateMemberDetailsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.btnUpdateUserProfile.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.UpdateMemberDetailsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                UpdateMemberDetailsActivity.this.updateUserProfile();
            }
        });
        this.profileImage = (ImageView) findViewById(R.id.profile_pic);
        loadUserDetails(receivedID);
    }

    private void loadUserDetails(String receivedID) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.pd = progressDialog;
        progressDialog.setMessage("Loading Details...");
        this.pd.show();
        FirebaseDatabase.getInstance().getReference().child("Users").child(receivedID).addValueEventListener(new ValueEventListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.UpdateMemberDetailsActivity.4
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                Member member = (Member) snapshot.getValue(Member.class);
                UpdateMemberDetailsActivity.this.txtFullNames.setText(member.getNames().toString());
                Picasso.get().load(member.getProfileimageurl()).placeholder(R.drawable.avatar).into(UpdateMemberDetailsActivity.this.profileImage);
                UpdateMemberDetailsActivity.this.txtUserName.setText(member.getUsername());
                UpdateMemberDetailsActivity.this.currentUserId = member.getId();
                UpdateMemberDetailsActivity.this.currUserEmail = member.getEmail();
                UpdateMemberDetailsActivity.this.currUserName = member.getUsername();
                UpdateMemberDetailsActivity.this.currUserFullnames = member.getNames();
                UpdateMemberDetailsActivity.this.currentUserProfPicUrl = member.getProfileimageurl();
                UpdateMemberDetailsActivity.this.currentUserMobile = member.getMobile();
                UpdateMemberDetailsActivity.this.pd.dismiss();
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateUserProfile() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Updating Profile...");
        pd.show();
        if (this.imageUri != null) {
            final StorageReference filePath = FirebaseStorage.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid() + "." + getFileExtenstion(this.imageUri));
            StorageTask uploadtask = filePath.putFile(this.imageUri);
            uploadtask.continueWithTask(new Continuation() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.UpdateMemberDetailsActivity.7
                @Override // com.google.android.gms.tasks.Continuation
                public Object then(Task task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return filePath.getDownloadUrl();
                }
            }).addOnCompleteListener(new OnCompleteListener<Uri>() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.UpdateMemberDetailsActivity.6
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<Uri> task) {
                    Uri downloadUri = task.getResult();
                    UpdateMemberDetailsActivity.this.imageUrl = downloadUri.toString();
                    DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Users");
                    HashMap<String, Object> map = new HashMap<>();
                    map.put(DatabaseHelper.COLUMN_ID, UpdateMemberDetailsActivity.this.currentUserId);
                    map.put("mobile", UpdateMemberDetailsActivity.this.currentUserMobile);
                    map.put("profileimageurl", UpdateMemberDetailsActivity.this.imageUrl);
                    map.put("names", UpdateMemberDetailsActivity.this.txtFullNames.getText().toString());
                    map.put("email", UpdateMemberDetailsActivity.this.currUserEmail);
                    map.put("username", UpdateMemberDetailsActivity.this.txtUserName.getText().toString());
                    ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(map);
                    Toast.makeText(UpdateMemberDetailsActivity.this.getApplicationContext(), "Profile Successfully Updated", Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                    UpdateMemberDetailsActivity.this.startActivity(new Intent(UpdateMemberDetailsActivity.this, MainActivity2.class));
                    UpdateMemberDetailsActivity.this.finish();
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.UpdateMemberDetailsActivity.5
                @Override // com.google.android.gms.tasks.OnFailureListener
                public void onFailure(Exception e) {
                    Toast.makeText(UpdateMemberDetailsActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            return;
        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Athletes");
        HashMap<String, Object> map = new HashMap<>();
        map.put(DatabaseHelper.COLUMN_ID, this.currentUserId);
        map.put("mobile", this.currentUserMobile);
        map.put("names", this.txtFullNames.getText().toString());
        map.put("username", this.txtUserName.getText().toString());
        map.put("email", this.currUserEmail);
        map.put("profileimageurl", this.currentUserProfPicUrl);
        ref.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(map);
        Toast.makeText(this, "Profile Successfully Updated", Toast.LENGTH_SHORT).show();
        pd.dismiss();
        startActivity(new Intent(this, MainActivity2.class));
        finish();
    }

    private String getFileExtenstion(Uri imageUri) {
        return MimeTypeMap.getSingleton().getExtensionFromMimeType(getContentResolver().getType(imageUri));
    }
}