package com.example.dllo.zaker.hotspot.sec;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by dllo on 16/8/31.
 */
public class HotspotSecBean implements Parcelable{
    private String webUrl;

    private int postion;
    private String pk;


    public HotspotSecBean() {
    }


    protected HotspotSecBean(Parcel in) {
        webUrl = in.readString();
        postion = in.readInt();
        pk = in.readString();
    }

    public static final Creator<HotspotSecBean> CREATOR = new Creator<HotspotSecBean>() {
        @Override
        public HotspotSecBean createFromParcel(Parcel in) {
            return new HotspotSecBean(in);
        }

        @Override
        public HotspotSecBean[] newArray(int size) {
            return new HotspotSecBean[size];
        }
    };

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public String getPk() {
        return pk;
    }

    public void setPk(String pk) {
        this.pk = pk;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(webUrl);
        dest.writeInt(postion);
        dest.writeString(pk);
    }
}
