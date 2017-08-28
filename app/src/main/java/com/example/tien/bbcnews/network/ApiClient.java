package com.example.tien.bbcnews.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tien on 8/22/2017.
 */

public class ApiClient {
//    private static final String BASE_URL = "https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=cc496dc90bb24067abba5d22ebe029fa";
    private static final String BASE_URL = "https://newsapi.org/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
