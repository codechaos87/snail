/**
 * Project Name:pinhong
 * File Name:LimitPage.java
 * Package Name:main.java.pinhong.entity
 * Date:2018年4月13日下午10:28:06
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.entity;

/**
 * Description: <br/>
 * Date: 2018年4月13日 下午10:28:06 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class LimitPage {
    private int currentPage;

    private int pageSize = 3;

    private int totalPageSize;

    private int lastPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage < 1) {
            this.currentPage = 1;
        } else {
            if (currentPage > lastPage) {
                this.currentPage = lastPage;
            } else {
                this.currentPage = currentPage;
            }
        }

    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(int totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

}
