package com.project.liuboyuan.autopartsmarketing;

/**
 * Created by 13173 on 2016/11/2.
 */

public class order_info {
    private int id;
    private String mOrderNo;
    private String mOrderDetail;
    private int url;

    public order_info(int id, String mOrderNo, String mOrderDetail, int url) {
        this.id = id;
        this.mOrderNo = mOrderNo;
        this.mOrderDetail = mOrderDetail;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getmOrderDetail() {
        return mOrderDetail;
    }

    public void setmOrderDetail(String mOrderDetail) {
        this.mOrderDetail = mOrderDetail;
    }

    public String getmOrderNo() {
        return mOrderNo;
    }

    public void setmOrderNo(String mOrderNo) {
        this.mOrderNo = mOrderNo;
    }
}
