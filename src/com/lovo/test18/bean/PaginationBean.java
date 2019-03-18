package com.lovo.test18.bean;

import java.util.List;

public class PaginationBean {

    /**
     * 数据集合
     */
    private List list;

    /**
     * 当前页面
     */
    private Integer currPage;

    /**
     * 总条数
     */
    private Integer totalPage;

    private int count;

    public PaginationBean() {
        super();
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
