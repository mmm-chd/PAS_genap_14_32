package com.intent.pas_genap_14_32.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.intent.pas_genap_14_32.R;
import com.intent.pas_genap_14_32.fetch_api.ModelClass;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass modelClass = teamList.get(position);
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
