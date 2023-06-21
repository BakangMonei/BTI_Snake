package com.neizathedev.breakingtheice.Adapters;
/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 2:42 PM
 */


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.neizathedev.breakingtheice.FirebaseActivities.MemberDetailsActivity;
import com.neizathedev.breakingtheice.Model.Member;
import com.neizathedev.breakingtheice.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

import java.util.List;

/* loaded from: classes4.dex */
public class MembersAdapter extends RecyclerView.Adapter<MembersAdapter.ViewHolder> {
    private FirebaseUser firebaseUser;
    private Context mContext;
    private List<Member> mMembers;

    public MembersAdapter(Context mContext, List<Member> mMembers) {
        this.mContext = mContext;
        this.mMembers = mMembers;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.mContext).inflate(R.layout.member_item, parent, false);
        return new ViewHolder(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final ViewHolder holder, int position) {
        this.firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        Member member = this.mMembers.get(position);
        holder.username.setText(member.getUsername());
        holder.fullname.setText(member.getNames());
        Picasso.get().load(member.getProfileimageurl()).placeholder(R.drawable.avatar).into(holder.imageProfile);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Adapters.MembersAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(final View view) {
                Member member2 = (Member) MembersAdapter.this.mMembers.get(holder.getAdapterPosition());
                FirebaseDatabase.getInstance().getReference().child("Users").child(member2.getId()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() { // from class: com.neizathedev.breakingtheice.Adapters.MembersAdapter.1.1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public void onComplete(Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(view.getContext(), "Member Deleted !", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        holder.btnView.setOnClickListener(new View.OnClickListener() { // from class: com.neizathedev.breakingtheice.Adapters.MembersAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Member member2 = (Member) MembersAdapter.this.mMembers.get(holder.getAdapterPosition());
                Intent intent = new Intent(MembersAdapter.this.mContext, MemberDetailsActivity.class);
                intent.putExtra("memberID", member2.getId());
                MembersAdapter.this.mContext.startActivity(intent);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mMembers.size();
    }

    /* loaded from: classes4.dex */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageButton btnDelete;
        public Button btnView;
        public TextView fullname;
        public CircleImageView imageProfile;
        public TextView username;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageProfile = (CircleImageView) itemView.findViewById(R.id.image_profile);
            this.username = (TextView) itemView.findViewById(R.id.user_name);
            this.fullname = (TextView) itemView.findViewById(R.id.full_name);
            this.btnView = (Button) itemView.findViewById(R.id.btn_view);
            this.btnDelete = (ImageButton) itemView.findViewById(R.id.btn_delete);
        }
    }
}