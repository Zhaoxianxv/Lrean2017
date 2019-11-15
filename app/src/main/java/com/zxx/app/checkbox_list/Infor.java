package com.zxx.app.checkbox_list;

import java.util.List;

/**
 * Created by Administrator on 2017/3/18.
 */
public class Infor {
    private String id;
    private String grup_content;
    private List<Bean> bean;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Bean> getBean() {
        return bean;
    }

    public void setBean(List<Bean> bean) {
        this.bean = bean;
    }

    public String getGrup_content() {
        return grup_content;
    }

    public void setGrup_content(String grup_content) {
        this.grup_content = grup_content;
    }
}
