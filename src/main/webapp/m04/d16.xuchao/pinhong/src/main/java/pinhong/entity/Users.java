/**
 * Project Name:pinhong
 * File Name:User.java
 * Package Name:main.java.pinhong.entity
 * Date:2018年4月13日下午2:25:46
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package main.java.pinhong.entity;
/**
 * Description:   <br/>
 * Date:     2018年4月13日 下午2:25:46 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class Users {
    private int uId;
    private String uName;
    private String uPWD;
    private String uStatus;
    private String uPic;
    public int getuId() {
        return uId;
    }
    public void setuId(int uId) {
        this.uId = uId;
    }
    public String getuName() {
        return uName;
    }
    public void setuName(String uName) {
        this.uName = uName;
    }
    public String getuPWD() {
        return uPWD;
    }
    public void setuPWD(String uPWD) {
        this.uPWD = uPWD;
    }
    public String getuStatus() {
        return uStatus;
    }
    public void setuStatus(String uStatus) {
        this.uStatus = uStatus;
    }
    public String getuPic() {
        return uPic;
    }
    public void setuPic(String uPic) {
        this.uPic = uPic;
    }
    
}

