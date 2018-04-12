/**
 * Project Name:News
 * File Name:page.java
 * Package Name:entity
 * Date:2018年4月10日上午9:59:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.dt59.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月10日 上午9:59:11 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class Page {
    private int currentpage;

    private int pagesize = 3;

    private int sumsize;

    private int lastpage;

    public int getCurrentge() {
        return currentpage;
    }

    public void setCurrentge(int currentge) {
        this.currentpage = currentge;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getSumsize() {
        return sumsize;
    }

    public void setSumsize(int sumsize) {
        this.sumsize = sumsize;
    }

    public int getLastpage() {
        return lastpage;
    }

    public void setLastpage(int lastpage) {
        this.lastpage = lastpage;
    }

}

