/**
 * Project Name:dt59_jsp_news
 * File Name:PageLimit.java
 * Package Name:main.java.entity
 * Date:2018年4月10日上午10:04:44
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.entity;

/**
 * Description: <br/>
 * Date: 2018年4月10日 上午10:04:44 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class PageLimit {
    private int currentPage;

    private int pageSize = 3;

    private int totalPageSize;

    private int lastPage;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
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
