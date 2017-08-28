package com.example.tien.bbcnews.modal;

/**
 * Created by Tien on 19-Aug-17.
 */

public class News {

    /**
     * author : BBC News
     * title : White nationalist rally at University of Virginia
     * description : The local mayor called the torch-lit protest "a cowardly parade of hatred, bigotry and racism".
     * url : http://www.bbc.co.uk/news/world-us-canada-40909547
     * urlToImage : https://ichef-1.bbci.co.uk/news/1024/cpsprodpb/17994/production/_97306669_mediaitem97306666.jpg
     * publishedAt : 2017-08-12T13:42:12Z
     */

    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;

    public News(String urlToImage, String title, String description) {
        this.urlToImage = urlToImage;
        this.title = title;
        this.description = description;
    }

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
