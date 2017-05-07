package com.cyj.model;

/**
 * Created by Administrator on 2017/4/5.
 */
public class GoodsModel {
    private int id;
    private String gname;
    private String unit;
    private String spec;
    private String note;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "GoodsModel{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                ", unit='" + unit + '\'' +
                ", spec='" + spec + '\'' +
                ", note='" + note + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
