package com.intent.pas_genap_14_32.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.intent.pas_genap_14_32.R;

public class ScheduleSessionFragment extends Fragment {

    RecyclerView rvSchedule;
    ProgressBar pbLoading;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_schedulesession, container, false);

        pbLoading = view.findViewById(R.id.pbLoading);
        rvSchedule = view.findViewById(R.id.rvSchedule);
        rvSchedule.setHasFixedSize(true);

        rvSchedule.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
