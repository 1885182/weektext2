package com.bawei.bean;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/2/26 9:04
 * @Description:封装
 */
public class MyRxxp {
    private List<Shop> commodityList;



    public List<Shop> getCommodityList() {
        return commodityList;
    }

    public void setCommodityList(List<Shop> commodityList) {
        this.commodityList = commodityList;
    }

    @Override
    public String toString() {
        return "MyRxxp{" +
                "commodityList=" + commodityList +
                '}';
    }
}
