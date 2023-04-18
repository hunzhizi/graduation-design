package com.hunzhizi.controller.result.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 魂之子
 * @since 2023-03-17 22:35
 * program: graduation-design
 * description:
 */
public class MyPage {
    private int total;
    private List<Analysis> list;
    private int pageNum;
    private int pageSize;
    private int size;

    public MyPage(List<Analysis> list,int pageNum, int pageSize) {
        total = list.size();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        if(this.total - pageNum * pageSize < 0 ) {
            this.size = total - (pageNum - 1) * pageSize;
        }else {
            this.size = pageSize;
        }
        ArrayList<Analysis> res = new ArrayList<>();
        for (int i = (pageNum-1)*pageSize; i < (pageNum-1)*pageSize+this.size; i++) {
            res.add(list.get(i));
        }
        this.list = res;

    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
