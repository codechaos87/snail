/**
 * Project Name:dt59_jsp_news
 * File Name:UserInfo.java
 * Package Name:main.java.entity
 * Date:2018年4月3日下午12:10:22
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m04.d03.xuchao.entity;

/**
 * Description: <br/>
 * Date: 2018年4月3日 下午12:10:22 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class UserInfo {
    private int userId;

    private String username;

    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
