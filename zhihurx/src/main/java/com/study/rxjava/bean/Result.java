
package com.study.rxjava.bean;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("date")
    private String mDate;
    @SerializedName("stories")
    private List<Story> mStories;
    @SerializedName("top_stories")
    private List<TopStory> mTopStories;

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public List<Story> getStories() {
        return mStories;
    }

    public void setStories(List<Story> stories) {
        mStories = stories;
    }

    public List<TopStory> getTopStories() {
        return mTopStories;
    }

    public void setTopStories(List<TopStory> top_stories) {
        mTopStories = top_stories;
    }

    @Override
    public String toString() {
        return "Result{" +
                "mDate='" + mDate + '\'' +
                ", mStories=" + mStories +
                ", mTopStories=" + mTopStories +
                '}';
    }
}
