/**
 * Project Name:snail
 * File Name:MyPanel.java
 * Package Name:m01.d25.wangguojun
 * Date:2018年1月27日下午2:42:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.wangguojun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Description:   <br/>
 * Date:     2018年1月27日 下午2:42:39 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
@SuppressWarnings("serial")
public class MyPanel extends JPanel implements KeyListener, Runnable {

    MyTanKe mt = null;// 先在内存中占一个空间

    public MyPanel() {
        mt = new MyTanKe(30, 40);// 窗口出场位置
    }

    // 画图
    public void paint(Graphics g) {
        super.paint(g);// g是画笔
        g.fillRect(0, 0, 400, 350);// 窗体大小
        g.setColor(Color.black);
        // 分四个方向画坦克
        this.drawTanke(mt.getX(), mt.getY(), 0, mt.getDirect(), g);
        //根据集合的大小绘制
        for(int i=0;i<mt.vect.size();i++){
            Shot st = mt.vect.get(i);
            if (st.isLive() && mt.vect != null) {
                g.fillRect(st.getX() - 1, st.getY(), 2, 2);
            }
            if (!st.isLive() && mt.vect != null) {
                mt.vect.remove(st);
            }
        }
    }

    public void drawTanke(int x, int y, int type, int direct, Graphics g) {
        // 画左边的矩形
        switch (type) {
        case 0:
            g.setColor(Color.yellow);
            break;
        case 1:
            g.setColor(Color.blue);
            break;
        }
        switch (direct) {
        case 0:// 向上
            g.fill3DRect(x, y, 20, 50, false);// 左边矩形
            g.fill3DRect(x + 20, y + 10, 30, 30, false);// 中间矩形
            g.fill3DRect(x + 50, y, 20, 50, false);// 右边的矩形
            g.fillOval(x + 25, y + 15, 20, 20);// 中间的炮台
            g.drawLine(x + 35, y + 15, x + 35, y - 10);// 画线
            break;
        case 1:// 向右
            g.fill3DRect(x, y, 50, 20, false);// 左边矩形
            g.fill3DRect(x + 10, y + 20, 30, 30, false);// 中间矩形
            g.fill3DRect(x, y + 50, 50, 20, false);// 右边的矩形
            g.fillOval(x + 15, y + 25, 20, 20);// 中间的炮台
            g.drawLine(x + 35, y + 35, x + 60, y + 35);// 画线
            break;
        case 2:// 向下
            g.fill3DRect(x, y, 20, 50, false);// 左边矩形
            g.fill3DRect(x + 20, y + 10, 30, 30, false);// 中间矩形
            g.fill3DRect(x + 50, y, 20, 50, false);// 右边的矩形
            g.fillOval(x + 25, y + 15, 20, 20);// 中间的炮台
            g.drawLine(x + 35, y + 35, x + 35, y + 60);// 画线
            break;
        case 3:// 向左
            g.fill3DRect(x, y, 50, 20, false);// 左边矩形
            g.fill3DRect(x + 10, y + 20, 30, 30, false);// 中间矩形
            g.fill3DRect(x, y + 50, 50, 20, false);// 右边的矩形
            g.fillOval(x + 15, y + 25, 20, 20);// 中间的炮台
            g.drawLine(x + 15, y + 35, x - 10, y + 35);// 画线
            break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

        // Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            mt.setDirect(0);
            moveup();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mt.setDirect(1);
            moveright();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mt.setDirect(2);
            movedown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mt.setDirect(3);
            moveleft();
        }
        //开火。j
        if(e.getKeyCode()==KeyEvent.VK_J){
            mt.tkFire();
        }
        this.repaint();//重绘
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void moveup() {

        int speed = mt.getSpeed();// 先获取速度
        int y = mt.getY() - speed;// 运算
        if (y < 30) {
            y = 0;
        }
        mt.setY(y);
        System.out.println("当前y=" + y);
    }

    // 向右
    public void moveright() {

        int speed = mt.getSpeed();// 先获取速度
        int x = mt.getX() + speed;// 运算
        if (x > 320) {
            x = 320;
        }
        mt.setX(x);
        System.out.println("当前x=" + x);
    }

    // 向左
    public void moveleft() {

        int speed = mt.getSpeed();// 先获取速度
        int x = mt.getX() - speed;// 运算
        if (x < 30) {
            x = 0;
        }
        mt.setX(x);
        System.out.println("当前x=" + x);
    }

    public void movedown() {

        int speed = mt.getSpeed();// 先获取速度
        int y = mt.getY() + speed;// 运算
        if (y > 240) {
            y = 240;
        }
        mt.setY(y);
        System.out.println("当前y=" + y);
    }

    @Override
    public void run() {
        while (true) {
        try {
            Thread.sleep(50);
                this.repaint();
        } catch (Exception e) {
                e.printStackTrace();
        }

    }
    }
}



