package com.zxx.app.checkbox_list;

/**
 * Created by Administrator on 2017/3/18.
 */
public class Bean {
    private String id ;
    private String chicld_id ;
    private String content ;
    private String isChecked;


    public String getChicld_id() {
        return chicld_id;
    }

    public void setChicld_id(String chicld_id) {
        this.chicld_id = chicld_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(String isChecked) {
        this.isChecked = isChecked;
    }
}
