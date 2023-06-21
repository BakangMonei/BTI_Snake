package com.neizathedev.breakingtheice.FirebaseActivities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.neizathedev.breakingtheice.Adapters.MainAdapter;
import com.neizathedev.breakingtheice.Model.MainModel;
import com.neizathedev.breakingtheice.R;

/* loaded from: classes9.dex */
public class ProfileActivity extends AppCompatActivity {
    MainAdapter mainAdapter;
    RecyclerView recyclerView;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.recyclerView = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<MainModel> options = new FirebaseRecyclerOptions.Builder().setQuery(FirebaseDatabase.getInstance().getReference().child("Users"), MainModel.class).build();
        MainAdapter mainAdapter = new MainAdapter(options);
        this.mainAdapter = mainAdapter;
        this.recyclerView.setAdapter(mainAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        this.mainAdapter.startListening();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.mainAdapter.stopListening();
    }
}