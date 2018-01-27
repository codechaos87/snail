/**
 * Project Name:snail
 * File Name:MyTanKe.java
 * Package Name:m01.d25.wangguojun
 * Date:2018年1月27日下午2:28:32
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d25.wangguojun;

import java.util.Vector;

/**
 * Description:   <br/>
 * Date:     2018年1月27日 下午2:28:32 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class MyTanKe extends TanKe {
    // 我自己的坦克
    private int direct;// 方向

    private int speed = 3;// 速度

    private Shot shot = null;

    Vector<Shot> vect = new Vector<Shot>();

    public MyTanKe() {
        super();
    }
    public MyTanKe(int x, int y) {
        super(x, y);
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

    // 开火的方法
    public void tkFire() {

        if (this.direct <= 10) {
            // 向上
            shot = new Shot(this.getX() + 35, this.getY() - 10, this.direct);
            vect.add(shot);
        } else if (this.direct == 1) {
            // 向右
            shot = new Shot(this.getX() + 60, this.getY() + 35, this.direct);
            vect.add(shot);
        } else if (this.direct == 2) {
            // 向下
            shot = new Shot(this.getX() + 35, this.getY() + 60, this.direct);
            vect.add(shot);
        } else if (this.direct == 3) {
            // 向左
            shot = new Shot(this.getX() - 10, this.getY() + 35, this.direct);
            vect.add(shot);
        }
        Thread th = new Thread(shot);
        th.start();
    }

}

