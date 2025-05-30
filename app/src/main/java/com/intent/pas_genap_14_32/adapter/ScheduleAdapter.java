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
import com.intent.pas_genap_14_32.fragment.ScheduleSessionFragment;

import java.util.List;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    List<ModelClass> eventsList;

    public ScheduleAdapter(ScheduleSessionFragment scheduleSessionFragment,List<ModelClass> eventsList) {
        this.eventsList = eventsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ModelClass modelClass = eventsList.get(position);
        holder.tvEvent.setText(modelClass.getStrEvent());
        holder.tvLeague.setText(modelClass.getStrLeague());
        Glide.with(holder.itemView.getContext()).load(modelClass.getStrLeagueBadge()).into(holder.ivBadge);
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvEvent;
        ImageView ivBadge;
        TextView tvLeague;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEvent = itemView.findViewById(R.id.tvOne);
            ivBadge = itemView.findViewById(R.id.ivBadge);
            tvLeague = itemView.findViewById(R.id.tvTwo);
        }
    }
}
