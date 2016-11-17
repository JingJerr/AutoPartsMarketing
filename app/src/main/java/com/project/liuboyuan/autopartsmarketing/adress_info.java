package com.project.liuboyuan.autopartsmarketing;

/**
 * Created by 13173 on 2016/11/5.
 */

public class adress_info {
    private int id;
    private String adress;
    private String name;
    private String phone;

    public adress_info(int id, String phone, String name, String adress) {
        this.id = id;
        this.phone = phone;
        this.name = name;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
