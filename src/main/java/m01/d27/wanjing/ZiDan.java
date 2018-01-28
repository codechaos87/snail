/**
 * Project Name:JAVA01
 * File Name:ZiDan.java
 * Package Name:m01.d25
 * Date:2018��1��27������5:03:54
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

pacm01.d27.wanjing1.d25;

/**
 * Description: <br/>
 * Date: 2018��1��27�� ����5:03:54 <br/>
 * 
 * @author wangJing
 * @version
 * @see
 */
public class ZiDan implements Runnable {

    private int x;

    private int y;

    private int direct;

    private int speed = 3;

    private boolean islive = true;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

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

    public boolean isIslive() {
        return islive;
    }

    public void setIslive(boolean islive) {
        this.islive = islive;
    }

    public ZiDan() {

    }

    public ZiDan(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true) {
            try {
                switch (this.direct) {
                case 0:
                    // ��

                    this.y -= this.speed;
                    break;

                case 1:
                    // ��
                    this.y += this.speed;
                    break;

                case 2:
                    // ��
                    this.x += this.speed;
                    break;

                case 3:
                    // ��
                    this.x -= this.speed;
                    break;

                }
                Thread.sleep(50);

            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.x < -30 || this.x > 206 || this.y < -30 || this.y > 400) {
                this.islive = false;
            }
        }
    }
}
