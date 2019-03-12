package com.bawei.bean;

/**
 * @Author: zhang
 * @Date: 2019/2/26 9:03
 * @Description:封装
 */
public class ShopBean {
    private ResultBean result;

    public ShopBean(ResultBean result) {
        this.result = result;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }
}
