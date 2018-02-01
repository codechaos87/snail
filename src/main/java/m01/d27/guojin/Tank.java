/**
 * Project Name:DT593
 * File Name:Tank.java
 * Package Name:lesson20180125
 * Date:2018年1月25日下午4:38:11
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.guojin;

import java.util.Vector;

/**
 * Description: <br/>
 * Date: 2018年1月25日 下午4:38:11 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class Tank {

    private Shot hot = null;

    Vector<Shot> vect = new Vector<Shot>();

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

    int x;

    int y;

    int Direct = 0;

    int speed = 10;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public int getDirect() {
        return Direct;
    }

    public void setDirect(int direct) {
        Direct = direct;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void File() {
        if (vect.size() < 10) {
            if (this.Direct == 0) {
                hot = new Shot(this.getX() + 9, this.getY(), this.Direct);
                vect.add(hot);
            } else if (this.Direct == 1) {
                hot = new Shot(this.getX() + 9, this.getY() + 30, this.Direct);
                vect.add(hot);
            } else if (this.Direct == 2) {
                hot = new Shot(this.getX() - 4, this.getY() + 9, this.Direct);
                vect.add(hot);
            } else if (this.Direct == 3) {
                hot = new Shot(this.getX() + 30, this.getY() + 9, this.Direct);
                vect.add(hot);
            }
            Thread th = new Thread(hot);
            th.start();
        }
    }

    public Shot getHot() {
        return hot;
    }

    public void setHot(Shot hot) {
        this.hot = hot;
    }

    public Vector<Shot> getVect() {
        return vect;
    }

    public void setVect(Vector<Shot> vect) {
        this.vect = vect;
    }
}

class Hero extends Tank {

    public Hero(int x, int y) {

        super(x, y);
        // Auto-generated constructor stub

    }

}
