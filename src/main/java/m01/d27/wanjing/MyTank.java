/**
 * Project Name:JAVA01
 * File Name:MyTank.java
 * Package Name:m01.d25
 * Date:2018��1��27������10:24:27
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

pacm01.d27.wanjing1.d25;

/**
 * Description: <br/>
 * Date: 2018��1��27�� ����10:24:27 <br/>
 * 
 * @author wangJing
 * @version
 * @see
 */
public class MyTank extends Tank {
    private int direct;

    private int speed = 3;

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public MyTank() {
        super();
    }

    public MyTank(int x, int y) {
        super(x, y);
    }

    public void shot() {

    }

    public void Fire() {
        // up
        if (this.direct == 0) {

        }
        // down
        else if (this.direct == 1) {

        }
        // right
        else if (this.direct == 2) {

        }
        // left
        else if (this.direct == 3) {

        }
    }
}
