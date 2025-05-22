package com.intent.pas_genap_14_32.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.intent.pas_genap_14_32.R;
import com.intent.pas_genap_14_32.fetch_api.ModelClass;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    List<ModelClass> events;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass modelClass = events.get(position);
        holder.tvTeam.setText(modelClass.getStrTeam());
        holder.tvStadium.setText(modelClass.getStrStadium());
        Glide.with(holder.itemView.getContext()).load(modelClass.getStrBadge()).into(holder.ivBadge);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvTeam;
        ImageView ivBadge;
        TextView tvStadium;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTeam = itemView.findViewById(R.id.tvTeam);
            ivBadge = itemView.findViewById(R.id.ivBadge);
            tvStadium = itemView.findViewById(R.id.tvStadium);
        }
    }
}
