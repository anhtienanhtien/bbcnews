package com.example.tien.bbcnews.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tien.bbcnews.R;
import com.example.tien.bbcnews.fragments.DetailFragment;
import com.example.tien.bbcnews.modal.NewsParcelable;
import com.example.tien.bbcnews.network.BBCNewsReponse;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Tien on 19-Aug-17.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.NewsViewHolder> {
    private static List<BBCNewsReponse.News> newsList;
    private static Context mContext;

    public RVAdapter(List<BBCNewsReponse.News> newsList, Context context) {
        this.newsList = newsList;
        this.mContext = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        NewsViewHolder nvh = new NewsViewHolder(v);
        return nvh;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder newsHolder, int position) {
        newsHolder.titleNews.setText(newsList.get(position).getTitle());
        newsHolder.descNews.setText(newsList.get(position).getDescription());

        Picasso.with(mContext).load(newsList.get(position).getUrlToImage())
                .resize(Resources.getSystem().getDisplayMetrics().widthPixels, (int)(9/16)*Resources.getSystem().getDisplayMetrics().widthPixels)
                .into(newsHolder.newsPhoto);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView titleNews;
        TextView descNews;
        ImageView newsPhoto;
        public NewsViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardview);
            titleNews = (TextView) itemView.findViewById(R.id.tv_title);
            descNews = (TextView) itemView.findViewById(R.id.tv_description);
            newsPhoto = (ImageView) itemView.findViewById(R.id.image_news);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    DetailFragment detailFragment = new DetailFragment();
                    FragmentTransaction transaction = ((FragmentActivity) mContext).getSupportFragmentManager().beginTransaction();
                    Bundle bundle = new Bundle();
                    NewsParcelable newsParcelable = new NewsParcelable(newsList.get(position));
                    bundle.putParcelable("URL", newsParcelable);
                    detailFragment.setArguments(bundle);
                    transaction.addToBackStack("NewsDetail");
                    transaction.replace(R.id.view_news, detailFragment, "NewsDetail").commit();

                }
            });
        }
    }
}
