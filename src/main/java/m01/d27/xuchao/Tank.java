/**
 * Project Name:snail
 * File Name:Tank.java
 * Package Name:m01.d27.xuchao.发射子弹
 * Date:2018年1月27日下午2:21:34
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.xuchao;

import java.util.Vector;

/**
 * Description: <br/>
 * Date: 2018年1月27日 下午2:21:34 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class Tank {
    private int x;

    private int y;

    private int direct;

    private int type;

    private int speed = 5;

    private Bullet bul = null;

    // 新建一个线程安全的集合存储子弹
    private Vector<Bullet> vec = new Vector<Bullet>();

    public Tank() {
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bullet getBul() {
        return bul;
    }

    public void setBul(Bullet bul) {
        this.bul = bul;
    }

    public Vector<Bullet> getVec() {
        return vec;
    }

    public void setVec(Vector<Bullet> vec) {
        this.vec = vec;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // 设置向上移动的速度并设置边界
    public void moveUp() {
        y -= speed;
        if (y <= 25) {
            y = 25;
        }
    }

    // 设置向右移动的速度并设置边界
    public void moveRight() {
        x += speed;
        if (x >= 350) {
            x = 350;
        }
    }

    // 设置向下移动的速度并设置边界
    public void moveDown() {
        y += speed;
        if (y >= 325) {
            y = 325;
        }
    }

    // 设置向左移动的速度并设置边界
    public void moveLeft() {
        x -= speed;
        if (x <= 25) {
            x = 25;
        }
    }

    // 坦克开火的功能 可以生成子弹
    public void fire() {
        // 最多只能存储10枚子弹(未死亡的子弹)
        if (vec.size() <= 10) {
            if (direct == 0) {
                bul = new Bullet(x + 10, y - 25, direct);
                vec.add(bul);
            } else if (direct == 1) {
                bul = new Bullet(x + 45, y + 10, direct);
                vec.add(bul);
            } else if (direct == 2) {
                bul = new Bullet(x + 10, y + 45, direct);
                vec.add(bul);
            } else if (direct == 3) {
                bul = new Bullet(x - 25, y + 10, direct);
                vec.add(bul);
            }
            // 添加并启动线程
            Thread th = new Thread(bul);
            th.start();
        } else {
            System.out.println("子弹已到上线，请稍后再发射！");
        }
    }
}
