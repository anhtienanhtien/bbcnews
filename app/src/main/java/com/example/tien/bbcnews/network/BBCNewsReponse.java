package com.example.tien.bbcnews.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tien on 8/22/2017.
 */

public class BBCNewsReponse {

    /**
     * status : ok
     * source : bbc-news
     * sortBy : top
     * articles : [{"author":"BBC News","title":"Barcelona attack: Van driver shot dead by police","description":"Younes Abouyaaqoub, wearing a fake explosive belt, was cornered west of Barcelona after a tip off.","url":"http://www.bbc.co.uk/news/world-europe-41004603","urlToImage":"https://ichef-1.bbci.co.uk/news/1024/cpsprodpb/10B7C/production/_97467486_mediaitem97467484.jpg","publishedAt":"2017-08-21T20:36:02Z"},{"author":"BBC News","title":"Solar eclipse 2017: Americans gaze at sky spectacular","description":"Skywatchers in the US are treated to a spectacular coast-to-coast eclipse.","url":"http://www.bbc.co.uk/news/science-environment-40657793","urlToImage":"https://ichef.bbci.co.uk/images/ic/1024x576/p05czbh7.jpg","publishedAt":"2017-08-21T19:22:55Z"}]
     */

    private String status;
    private String source;
    private String sortBy;
    @SerializedName("articles")
    private List<News> newsList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public static class News {
        /**
         * author : BBC News
         * title : Barcelona attack: Van driver shot dead by police
         * description : Younes Abouyaaqoub, wearing a fake explosive belt, was cornered west of Barcelona after a tip off.
         * url : http://www.bbc.co.uk/news/world-europe-41004603
         * urlToImage : https://ichef-1.bbci.co.uk/news/1024/cpsprodpb/10B7C/production/_97467486_mediaitem97467484.jpg
         * publishedAt : 2017-08-21T20:36:02Z
         */

        private String author;
        private String title;
        private String description;
        private String url;
        private String urlToImage;
        private String publishedAt;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrlToImage() {
            return urlToImage;
        }

        public void setUrlToImage(String urlToImage) {
            this.urlToImage = urlToImage;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public void setPublishedAt(String publishedAt) {
            this.publishedAt = publishedAt;
        }
    }
}
