package com.example.myportifolio.skills;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myportifolio.R;

import java.util.List;


public class SkillsAdaptor extends RecyclerView.Adapter<SkillsAdaptor.SkillsViewHolder> {
    RecyclerView menuRv;

    List<com.example.myportifolio.skills.SkillsItem> mdata;


    public SkillsAdaptor(List<com.example.myportifolio.skills.SkillsItem> mdata) {
        this.mdata = mdata;
    }

    @NonNull

    @Override
    public SkillsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_skills,parent,false);
        return new SkillsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull SkillsViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(mdata.get(position).getImage()).into(holder.imgport);
        //holder.tvPosition.setText(String.valueOf(position));

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class SkillsViewHolder extends RecyclerView.ViewHolder{
        ImageView imgport;
        //TextView tvPosition;


        public SkillsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgport = itemView.findViewById(R.id.item_portfolio_img);
            //tvPosition = itemView.findViewById(R.id.item_skill_text);
        }
    }
}
