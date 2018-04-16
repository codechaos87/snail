/**
 * Project Name:pinhong
 * File Name:Message.java
 * Package Name:main.java.pinhong.entity
 * Date:2018年4月16日下午2:39:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.entity;

import java.util.Date;

/**
 * Description: <br/>
 * Date: 2018年4月16日 下午2:39:03 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class Message {
    private int mId;

    private String mTitle;

    private String mContent;

    private String mName;

    private Date mDate;

    private int rCount;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public Date getmDate() {
        return mDate;
    }

    public void setmDate(Date mDate) {
        this.mDate = mDate;
    }

    public int getrCount() {
        return rCount;
    }

    public void setrCount(int rCount) {
        this.rCount = rCount;
    }

}
