package com.bawei.bean;

/**
 * @Author: zhang
 * @Date: 2019/2/28 19:38
 * @Description:
 */
public class ResultsBean {
    private String pic_url;
    private String news_id;

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getNews_id() {
        return news_id;
    }

    public void setNews_id(String news_id) {
        this.news_id = news_id;
    }

    @Override
    public String toString() {
        return "ResultsBean{" +
                "pic_url='" + pic_url + '\'' +
                ", news_id='" + news_id + '\'' +
                '}';
    }
}
