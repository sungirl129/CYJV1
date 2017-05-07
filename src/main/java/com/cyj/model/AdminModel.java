package com.cyj.model;

/**
 * Created by Administrator on 2017/3/31.
 */
public class AdminModel {
    private int id;
    private String name;
    private String NT;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNT() {
        return NT;
    }

    public void setNT(String NT) {
        this.NT = NT;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", NT='" + NT + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
