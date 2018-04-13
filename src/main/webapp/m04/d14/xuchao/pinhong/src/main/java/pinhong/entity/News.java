/**
 * Project Name:pinhong
 * File Name:News.java
 * Package Name:main.java.pinhong.entity
 * Date:2018年4月12日下午7:33:23
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.entity;

import java.util.Date;

/**
 * Description:   <br/>
 * Date:     2018年4月12日 下午7:33:23 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class News {
    private int nId;
    private String nTitle;
    private String nContent;
    private Date nDate;
    public int getnId() {
        return nId;
    }
    public void setnId(int nId) {
        this.nId = nId;
    }
    public String getnTitle() {
        return nTitle;
    }
    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }
    public String getnContent() {
        return nContent;
    }
    public void setnContent(String nContent) {
        this.nContent = nContent;
    }
    public Date getnDate() {
        return nDate;
    }
    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }
}

