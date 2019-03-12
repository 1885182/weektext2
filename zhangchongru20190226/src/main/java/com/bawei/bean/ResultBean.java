package com.bawei.bean;

import java.util.List;

/**
 * @Author: zhang
 * @Date: 2019/2/26 9:03
 * @Description:封装
 */
public class ResultBean {
    private List<MyRxxp> rxxp;
    private List<MyPzsh> pzsh;
    private List<MyMlss> mlss;

    public ResultBean(List<MyRxxp> rxxp, List<MyPzsh> pzsh, List<MyMlss> mlss) {
        this.rxxp = rxxp;
        this.pzsh = pzsh;
        this.mlss = mlss;
    }

    public List<MyRxxp> getRxxp() {
        return rxxp;
    }

    public void setRxxp(List<MyRxxp> rxxp) {
        this.rxxp = rxxp;
    }

    public List<MyPzsh> getPzsh() {
        return pzsh;
    }

    public void setPzsh(List<MyPzsh> pzsh) {
        this.pzsh = pzsh;
    }

    public List<MyMlss> getMlss() {
        return mlss;
    }

    public void setMlss(List<MyMlss> mlss) {
        this.mlss = mlss;
    }
}
