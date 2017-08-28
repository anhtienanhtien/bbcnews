package com.example.tien.bbcnews.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.tien.bbcnews.R;
import com.example.tien.bbcnews.modal.NewsParcelable;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tien on 29-Jul-17.
 */

public class DetailFragment extends Fragment {
    @Bind(R.id.webview_detail) WebView wv_detail;
    private String url;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        // get argument
        Bundle b = getArguments();
        NewsParcelable newsParcelable = b.getParcelable("URL");
        //load webview
        wv_detail.loadUrl(newsParcelable.url);
        return view;
    }
}
