package com.example.tien.bbcnews.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Tien on 8/22/2017.
 */

public interface ApiInterface {
    @GET("v1/articles")
    Call<BBCNewsReponse> getNews(@Query("source") String src, @Query("sortBy") String sortBy, @Query("apiKey") String apiKey);
}
