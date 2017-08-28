package com.example.tien.bbcnews.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.tien.bbcnews.R;
import com.example.tien.bbcnews.adapter.RVAdapter;
import com.example.tien.bbcnews.modal.News;
import com.example.tien.bbcnews.network.ApiClient;
import com.example.tien.bbcnews.network.ApiInterface;
import com.example.tien.bbcnews.network.BBCNewsReponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Tien on 29-Jul-17.
 */

public class NewsFragment extends Fragment {
    @Bind(R.id.recyclerview) RecyclerView recyclerView;
    private List<BBCNewsReponse.News> newsList = new ArrayList<>();
    private static final String TAG = "NewsFragment";
    private RVAdapter rvAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        ButterKnife.bind(this, v);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        requestData();

        return v;
    }

    private void requestData() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<BBCNewsReponse> call = apiService.getNews("bbc-news", "top", "cc496dc90bb24067abba5d22ebe029fa");
        call.enqueue(new Callback<BBCNewsReponse>() {
            @Override
            public void onResponse(Call<BBCNewsReponse> call, Response<BBCNewsReponse> response) {
                Log.d(TAG, "onResponse");
                newsList = response.body().getNewsList();
                rvAdapter = new RVAdapter(newsList, getContext());
                recyclerView.setAdapter(rvAdapter);
            }

            @Override
            public void onFailure(Call<BBCNewsReponse> call, Throwable t) {
                Log.d(TAG, "onFailure");
            }
        });
    }
}
