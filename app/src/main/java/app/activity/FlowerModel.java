package app.activity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by madhu on 23-Mar-18.
 */

public class FlowerModel {
    @SerializedName("largeImageURL")
    private String largeImageURL;
    @SerializedName("likes")
    private int likes;
    @SerializedName("views")
    private int views;
    @SerializedName("comments")
    private int comments;
    @SerializedName("pageURL")
    private String pageURL;
    @SerializedName("webformatURL")
    private String webformatURL;
    @SerializedName("previewURL")
    private String previewURL;
    @SerializedName("userImageURL")
    private String userImageURL;


    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }
}
