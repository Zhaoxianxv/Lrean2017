package com.zxx.app.banner;

/**
 * 描述：广告信息</br>
 */
public class ADInfo {

    long id;
    long liveId;
    private String url;//image url
    private String new_url;//new url
    String content;//buttom string
    int type;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
