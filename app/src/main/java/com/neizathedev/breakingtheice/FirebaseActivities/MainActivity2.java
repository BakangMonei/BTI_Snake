package com.neizathedev.breakingtheice.FirebaseActivities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.neizathedev.breakingtheice.Adapters.MembersAdapter;
import com.neizathedev.breakingtheice.Model.Member;
import com.neizathedev.breakingtheice.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes9.dex */
public class MainActivity2 extends AppCompatActivity {
    private ImageButton close;
    private List<Member> mMembers;
    private MembersAdapter membersAdapter;
    private RecyclerView recyclerViewMembers;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMembers);
        this.recyclerViewMembers = recyclerView;
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.recyclerViewMembers.setLayoutManager(linearLayoutManager);
        this.mMembers = new ArrayList();
        MembersAdapter membersAdapter = new MembersAdapter(this, this.mMembers);
        this.membersAdapter = membersAdapter;
        this.recyclerViewMembers.setAdapter(membersAdapter);
        readMembers();
    }

    private void readMembers() {
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Uploading");
        pd.show();
        FirebaseDatabase.getInstance().getReference().child("Users").addValueEventListener(new ValueEventListener() { // from class: com.neizathedev.breakingtheice.FirebaseActivities.MainActivity2.1
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot snapshot) {
                MainActivity2.this.mMembers.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Member member = (Member) dataSnapshot.getValue(Member.class);
                    MainActivity2.this.mMembers.add(member);
                }
                pd.dismiss();
                MainActivity2.this.membersAdapter.notifyDataSetChanged();
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError error) {
            }
        });
    }
}