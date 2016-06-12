package com.vadivelansr.android.tourguide.bean;

/**
 * Created by vadivelansr on 6/12/2016.
 */
public class ListItemBean {
    private String title;
    private String desc;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    private int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
