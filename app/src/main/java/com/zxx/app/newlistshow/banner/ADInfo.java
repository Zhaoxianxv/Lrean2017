package com.zxx.app.newlistshow.banner;

/**
 * 描述：广告信息</br>
 */
public class ADInfo {

    long id;
    long liveId;
    String url;
    String content;
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

    public long getLiveId() {
        return liveId;
    }

    public void setLiveId(long liveId) {
        this.liveId = liveId;
    }





    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
