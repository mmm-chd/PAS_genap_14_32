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
import com.intent.pas_genap_14_32.fragment.PremiereLeagueFragment;

import java.util.List;

public class PremiereAdapter extends RecyclerView.Adapter<PremiereAdapter.ViewHolder> {

    List<ModelClass> teamList;

    public PremiereAdapter(PremiereLeagueFragment premiereList, List<ModelClass> teamList) {
        this.teamList = teamList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass team = teamList.get(position);
        holder.tvOne.setText(team.getStrTeam());
        holder.tvTwo.setText(team.getStrStadium());

        Glide.with(holder.itemView.getContext())
                .load(team.getStrBadge())
                .into(holder.ivBadge);
    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvOne, tvTwo;
        ImageView ivBadge;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvOne = itemView.findViewById(R.id.tvOne);
            tvTwo = itemView.findViewById(R.id.tvTwo);
            ivBadge = itemView.findViewById(R.id.ivBadge);

        }
    }

}
