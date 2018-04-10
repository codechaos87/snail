/**
 * Project Name:dt59_jsp_news
 * File Name:CommentInfo.java
 * Package Name:main.java.entity
 * Date:2018年4月8日下午10:58:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.entity;

import java.sql.Date;

/**
 * Description: <br/>
 * Date: 2018年4月8日 下午10:58:43 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class CommentInfo {
    private int commentID;

    private String username;

    private String commentIp;

    private String commentContent;

    private int commentNewsId;

    private Date fbtime;

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCommentIp() {
        return commentIp;
    }

    public void setCommentIp(String commentIp) {
        this.commentIp = commentIp;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentNewsId() {
        return commentNewsId;
    }

    public void setCommentNewsId(int commentNewsId) {
        this.commentNewsId = commentNewsId;
    }

    public Date getFbtime() {
        return fbtime;
    }

    public void setFbtime(Date fbtime) {
        this.fbtime = fbtime;
    }
}
