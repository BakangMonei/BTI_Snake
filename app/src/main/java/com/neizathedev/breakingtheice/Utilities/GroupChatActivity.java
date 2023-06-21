package com.neizathedev.breakingtheice.Utilities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.neizathedev.breakingtheice.Model.Message;
import com.neizathedev.breakingtheice.R;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class GroupChatActivity extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase mDatabase;
    Message message;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override
    // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view_messages);
        EditText editText = (EditText) findViewById(R.id.edit_text_message);
        Button button_send = (Button) findViewById(R.id.button_send);
        this.message = new Message();
        button_send.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Utilities.GroupChatActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GroupChatActivity.this.sendMessage();
            }
        });
    }

    private void initFirebase() {
        this.mAuth = FirebaseAuth.getInstance();
        this.mDatabase = FirebaseDatabase.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMessage() {
        this.mAuth.getCurrentUser().getUid();
        this.mDatabase.getReference("group_chat_messages").push().setValue(new Message());
    }

    private void retrieveMessages() {
        DatabaseReference messagesRef = this.mDatabase.getReference("group_chat_messages");
        messagesRef.addValueEventListener(new ValueEventListener() { // from class: com.neizathedev.breakingtheice.Utilities.GroupChatActivity.2
            @Override // com.google.firebase.database.ValueEventListener
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Message> messages = new ArrayList<>();
                for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                    Message message = (Message) messageSnapshot.getValue(Message.class);
                    messages.add(message);
                }
            }

            @Override // com.google.firebase.database.ValueEventListener
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}