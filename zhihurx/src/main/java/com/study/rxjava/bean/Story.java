
package com.study.rxjava.bean;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Story {

    @SerializedName("ga_prefix")
    private String mGaPrefix;
    @SerializedName("id")
    private Long mId;
    @SerializedName("images")
    private List<String> mImages;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private Long mType;

    public String getGaPrefix() {
        return mGaPrefix;
    }

    public void setGaPrefix(String ga_prefix) {
        mGaPrefix = ga_prefix;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<String> getImages() {
        return mImages;
    }

    public void setImages(List<String> images) {
        mImages = images;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getType() {
        return mType;
    }

    public void setType(Long type) {
        mType = type;
    }

}
