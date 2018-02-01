/**
 * Project Name:snail
 * File Name:Tank.java
 * Package Name:m01.d25.xuchao.坦克大战_监听
 * Date:2018年1月25日下午5:23:54
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d25.xuchao.坦克大战_监听;

/**
 * Description: <br/>
 * Date: 2018年1月25日 下午5:23:54 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class Tank {
    // 横坐标
    private int x;

    // 纵坐标
    private int y;

    // 方向
    private int direct;

    private int speed = 5;

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

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public void moveup() {
        y -= speed;
        if (y <= 25) {
            y = 25;
        }
    }

    public void movedown() {
        y += speed;
        if (y >= 215) {
            y = 215;
        }
    }

    public void moveleft() {
        x -= speed;
        if (x <= 25) {
            x = 25;
        }
    }

    public void moveright() {
        x += speed;
        if (x >= 240) {
            x = 240;
        }
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
