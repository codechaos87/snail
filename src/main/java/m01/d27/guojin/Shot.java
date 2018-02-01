/**
 * Project Name:DT593
 * File Name:Shot.java
 * Package Name:lesson20180125
 * Date:2018年1月27日下午2:26:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.guojin;

/**
 * Description: <br/>
 * Date: 2018年1月27日 下午2:26:34 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class Shot implements Runnable {
    private int x;

    private int y;

    private int direct;

    private int speed = 3;

    public Shot() {
    }

    public Shot(int x, int y, int direct) {
        this.direct = direct;
        this.x = x;
        this.y = y;
    }

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

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean isLive) {
        this.isLive = isLive;
    }

    private boolean isLive = true;

    @Override
    public void run() {
        while (true) {
            try {
                switch (this.direct) {
                case 0:
                    this.y -= this.speed;

                    break;
                case 1:
                    this.y += this.speed;

                    break;
                case 2:
                    this.x -= this.speed;

                    break;
                case 3:
                    this.x += this.speed;

                    break;

                default:
                    break;
                }
                Thread.sleep(50);
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            if (this.x < 0 || this.x > 600 || this.y < 0 || this.y > 600) {
                this.isLive = false;
                break;
            }
        }

    }

}
