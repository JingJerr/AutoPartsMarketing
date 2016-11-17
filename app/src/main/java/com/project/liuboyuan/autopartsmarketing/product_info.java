package com.project.liuboyuan.autopartsmarketing;

/**
 * Created by 13173 on 2016/11/2.
 */

public class product_info {
    private int id;
    private String mProductName;
    private String getmProductPrice;
    private int url;

    public product_info(int id, String mProductName, String getmProductPrice,int url) {
        this.id = id;
        this.mProductName = mProductName;
        this.getmProductPrice = getmProductPrice;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmProductName() {
        return mProductName;
    }

    public void setmProductName(String mProductName) {
        this.mProductName = mProductName;
    }

    public String getGetmProductPrice() {
        return getmProductPrice;
    }

    public void setGetmProductPrice(String getmProductPrice) {
        this.getmProductPrice = getmProductPrice;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }
}
