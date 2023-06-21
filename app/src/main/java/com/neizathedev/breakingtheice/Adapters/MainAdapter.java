package com.neizathedev.breakingtheice.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.neizathedev.breakingtheice.Model.MainModel;
import com.neizathedev.breakingtheice.R;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * @Author: Monei Bakang Mothuti
 * @Date: Thursday June 2023
 * @Time: 2:31 PM
 */
public class MainAdapter extends FirebaseRecyclerAdapter<MainModel, MainAdapter.myViewHolder> {
    public MainAdapter(FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.firebase.ui.database.FirebaseRecyclerAdapter
    public void onBindViewHolder(myViewHolder holder, int position, MainModel model) {
        holder.email.setText(model.getEmail());
        holder.firstName.setText(model.getFirstName());
        holder.lastName.setText(model.getLastName());
        holder.DOB.setText(model.getDOB());
        holder.Gender.setText(model.getGender());
        holder.phoneNumber.setText(model.getPhoneNumber());
        holder.Address.setText(model.getAddress());
        holder.Country.setText(model.getCountry());
        holder.IDPassport.setText(model.getIDPassport());
        Glide.with(holder.img.getContext()).load(model.getUrl()).placeholder((int) R.drawable.common_google_signin_btn_icon_dark).circleCrop().error(R.drawable.common_google_signin_btn_icon_dark).into(holder.img);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item, parent, false);
        return new myViewHolder(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView Address;
        TextView Country;
        TextView DOB;
        TextView Gender;
        TextView IDPassport;
        TextView email;
        TextView firstName;
        CircleImageView img;
        TextView lastName;
        TextView phoneNumber;

        public myViewHolder(View itemView) {
            super(itemView);
            this.img = (CircleImageView) itemView.findViewById(R.id.img1);
            this.email = (TextView) itemView.findViewById(R.id.email);
            this.firstName = (TextView) itemView.findViewById(R.id.firstName);
            this.lastName = (TextView) itemView.findViewById(R.id.lastName);
            this.DOB = (TextView) itemView.findViewById(R.id.DOB);
            this.Gender = (TextView) itemView.findViewById(R.id.Gender);
            this.phoneNumber = (TextView) itemView.findViewById(R.id.phoneNumber);
            this.Address = (TextView) itemView.findViewById(R.id.address);
            this.Country = (TextView) itemView.findViewById(R.id.Country);
            this.IDPassport = (TextView) itemView.findViewById(R.id.Omang);
        }
    }
}