package com.neizathedev.breakingtheice.FirebaseActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.neizathedev.breakingtheice.Model.Member;
import com.neizathedev.breakingtheice.R;
import com.squareup.picasso.Picasso;

/* loaded from: classes9.dex */
public class MemberDetailsActivity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    Button btnCallUser;
    ImageButton btnClose;
    Button btnEditUserDetails;
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
    TextView txtFullNames;
    TextView txtMobile;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_details);
        Intent userID = getIntent();
        final String receivedID = userID.getStringExtra("memberID");
        this.txtFullNames = (TextView) findViewById(R.id.xml_fullnames);
        this.txtMobile = (TextView) findViewById(R.id.xml_mobile);
        this.btnCallUser = (Button) findViewById(R.id.btn_call_member);
        this.btnEditUserDetails = (Button) findViewById(R.id.btn_edit_details);
        ImageButton imageButton = (ImageButton) findViewById(R.id.img_close);
        this.btnClose = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.MemberDetailsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MemberDetailsActivity.this.finish();
            }
        });
        this.btnEditUserDetails.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.MemberDetailsActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent(MemberDetailsActivity.this, UpdateMemberDetailsActivity.class);
                intent.putExtra("memberID", receivedID);
                MemberDetailsActivity.this.startActivity(intent);
            }
        });
        this.btnCallUser.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.MemberDetailsActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MemberDetailsActivity.this.makePhoneCall();
            }
        });
        this.profileImage = (ImageView) findViewById(R.id.profile_pic);
        loadUserDetails(receivedID);
    }

    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1 && grantResults.length > 0 && grantResults[0] == 0) {
            makePhoneCall();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makePhoneCall() {
        Intent callIntent = new Intent("android.intent.action.CALL");
        callIntent.setData(Uri.parse("tel:" + this.txtMobile.getText().toString()));
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), "android.permission.CALL_PHONE") != 0) {
            ActivityCompat.requestPermissions(this, new String[]{"android.permission.CALL_PHONE"}, 1);
        } else {
            startActivity(callIntent);
        }
    }

    private void loadUserDetails(String receivedID) {
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.pd = progressDialog;
        progressDialog.setMessage("Loading Details...");
        this.pd.show();
        FirebaseDatabase.getInstance().getReference().child("Users").child(receivedID).addValueEventListener(new ValueEventListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.MemberDetailsActivity.4
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                Member member = (Member) snapshot.getValue(Member.class);
                MemberDetailsActivity.this.txtFullNames.setText(member.getNames().toString());
                Picasso.get().load(member.getProfileimageurl()).placeholder(R.drawable.avatar).into(MemberDetailsActivity.this.profileImage);
                MemberDetailsActivity.this.txtMobile.setText(member.getMobile().toString());
                MemberDetailsActivity.this.currentUserId = member.getId();
                MemberDetailsActivity.this.currUserEmail = member.getEmail();
                MemberDetailsActivity.this.currUserName = member.getUsername();
                MemberDetailsActivity.this.currUserFullnames = member.getNames();
                MemberDetailsActivity.this.currentUserProfPicUrl = member.getProfileimageurl();
                MemberDetailsActivity.this.currentUserMobile = member.getMobile();
                MemberDetailsActivity.this.pd.dismiss();
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        });
    }
}