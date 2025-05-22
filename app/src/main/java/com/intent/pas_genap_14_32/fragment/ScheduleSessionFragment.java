package com.intent.pas_genap_14_32.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.intent.pas_genap_14_32.R;
import com.intent.pas_genap_14_32.adapter.ScheduleAdapter;
import com.intent.pas_genap_14_32.fetch_api.ApiClient;
import com.intent.pas_genap_14_32.fetch_api.ApiService;
import com.intent.pas_genap_14_32.fetch_api.ModelClass;
import com.intent.pas_genap_14_32.fetch_api.TeamResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        //Hit Api
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<TeamResponse> call = apiService.getEventsSeason();

        call.enqueue(new Callback<TeamResponse>() {

            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    rvSchedule.setVisibility(View.VISIBLE);
                    pbLoading.setVisibility(View.GONE);
                    List<ModelClass> teamList = response.body().getEvents();
                    ScheduleAdapter adapter = new ScheduleAdapter(ScheduleSessionFragment.this, teamList);
                    rvSchedule.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable throwable) {
                Toast.makeText(getContext(), "Error: " + throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
