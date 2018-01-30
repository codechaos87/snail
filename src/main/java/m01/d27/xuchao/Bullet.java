/**
 * Project Name:snail
 * File Name:Bullet.java
 * Package Name:m01.d27.xuchao.发射子弹
 * Date:2018年1月27日下午3:08:29
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.xuchao;

/**
 * Description: <br/>
 * Date: 2018年1月27日 下午3:08:29 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class Bullet implements Runnable {
    private int x;

    private int y;

    private int speed = 3;

    private int direct;

    // 子弹是否死亡
    private boolean alive = true;

    public Bullet() {
    }

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    // 设置子弹飞行的速度
    public void run() {
        while (true) {
            try {
                switch (direct) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
                }
                // 让进城执行的缓慢一点
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 如果子弹超出边界 就死亡同时跳出函数
            if (x < 0 || x > 400 || y < 0 || y > 400) {
                alive = false;
                break;
            }
        }
    }
}
