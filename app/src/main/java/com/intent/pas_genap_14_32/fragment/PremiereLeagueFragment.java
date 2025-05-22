package com.intent.pas_genap_14_32.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.intent.pas_genap_14_32.R;
import com.intent.pas_genap_14_32.adapter.PremiereAdapter;
import com.intent.pas_genap_14_32.fetch_api.ApiClient;
import com.intent.pas_genap_14_32.fetch_api.ApiService;
import com.intent.pas_genap_14_32.fetch_api.ModelClass;
import com.intent.pas_genap_14_32.fetch_api.TeamResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PremiereLeagueFragment extends Fragment {
    RecyclerView rvPremiere;
    ProgressBar pbPremiere;

    List<ModelClass> teamList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_premiereleague, container, false);

        pbPremiere = view.findViewById(R.id.pbPremiere);
        rvPremiere = view.findViewById(R.id.rvPremiere);
        rvPremiere.setHasFixedSize(true);

        rvPremiere.setLayoutManager(new LinearLayoutManager(getContext()));


        //Hit Api
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<TeamResponse> call = apiService.getPremierLeagueTeams();

        call.enqueue(new Callback<TeamResponse>() {

            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    rvPremiere.setVisibility(View.VISIBLE);
                    pbPremiere.setVisibility(View.GONE);
                    List<ModelClass> teamList = response.body().getTeams();
                    PremiereAdapter adapter = new PremiereAdapter(PremiereLeagueFragment.this, teamList);
                    rvPremiere.setAdapter(adapter);
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
