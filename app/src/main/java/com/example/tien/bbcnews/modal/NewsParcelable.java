package com.example.tien.bbcnews.modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.tien.bbcnews.network.BBCNewsReponse;

/**
 * Created by Tien on 27-Aug-17.
 */

public class NewsParcelable implements Parcelable {
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public String publishedAt;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.author);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.url);
        dest.writeString(this.urlToImage);
        dest.writeString(this.publishedAt);
    }

    public NewsParcelable(BBCNewsReponse.News news) {
        this.author = news.getAuthor();
        this.description = news.getDescription();
        this.title = news.getTitle();
        this.publishedAt = news.getPublishedAt();
        this.url = news.getUrl();
        this.urlToImage = news.getUrlToImage();
    }

    protected NewsParcelable(Parcel in) {
        this.author = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.url = in.readString();
        this.urlToImage = in.readString();
        this.publishedAt = in.readString();
    }

    public static final Parcelable.Creator<NewsParcelable> CREATOR = new Parcelable.Creator<NewsParcelable>() {
        @Override
        public NewsParcelable createFromParcel(Parcel source) {
            return new NewsParcelable(source);
        }

        @Override
        public NewsParcelable[] newArray(int size) {
            return new NewsParcelable[size];
        }
    };
}
