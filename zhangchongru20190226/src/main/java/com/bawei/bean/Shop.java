package com.bawei.bean;

/**
 * @Author: zhang
 * @Date: 2019/2/26 9:05
 * @Description:封装
 */
public class Shop {
    private String commodityName;
    private String masterPic;

    public Shop(String commodityName, String masterPic) {
        this.commodityName = commodityName;
        this.masterPic = masterPic;
    }


    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                '}';
    }
}
