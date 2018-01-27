/**
 * Project Name:snail
 * File Name:MyPanel.java
 * Package Name:m01.d27.xuchao.发射子弹
 * Date:2018年1月27日下午2:27:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.xuchao;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Description: <br/>
 * Date: 2018年1月27日 下午2:27:03 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class MyPanel extends Panel implements KeyListener, Runnable {
    // 设置一个我的坦克 可以设定一些属性
    MyTank mt = null;

    public MyPanel() {
        // 设置我的坦克的初始位置
        mt = new MyTank(50, 50);
    }

    @Override
    public void paint(Graphics g) {
        // 1.4版本以前必写，现在可写可不写
        super.paint(g);

        // 设置一个方块作为背景颜色和尺寸
        g.setColor(Color.black);
        g.fillRect(0, 0, 400, 400);

        // 画坦克
        drawTank(mt.getX(), mt.getY(), g, mt.getDirect(), 0);

        // 循环得到子弹
        for (int i = 0; i < mt.getVec().size(); i++) {
            Bullet bul = mt.getVec().get(i);
            // 如果子弹没有消亡且集合不为空就进行绘制子弹
            if (bul.isAlive() == true && mt.getVec() != null) {
                g.fillRect(bul.getX(), bul.getY(), 2, 2);
            }
            // 如果子弹已经消亡，就从集合中移除子弹
            if (bul.isAlive() == false) {
                mt.getVec().remove(bul);
            }
        }
    }

    // 绘制坦克 要注意传入画笔 类型决定敌我坦克 通过不同方向来绘制不同坦克
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
        case 0:
            g.setColor(Color.gray);
            break;
        case 1:
            g.setColor(Color.red);
            break;
        }

        switch (direct) {
        case 0:
            g.fill3DRect(x - 5, y - 5, 30, 30, false);
            g.fill3DRect(x - 25, y - 15, 20, 50, false);
            g.fill3DRect(x + 25, y - 15, 20, 50, false);
            g.fillOval(x, y, 20, 20);
            g.drawLine(x + 10, y, x + 10, y - 25);
            break;
        case 1:
            g.fill3DRect(x - 5, y - 5, 30, 30, false);
            g.fill3DRect(x - 15, y - 25, 50, 20, false);
            g.fill3DRect(x - 15, y + 25, 50, 20, false);
            g.fillOval(x, y, 20, 20);
            g.drawLine(x + 20, y + 10, x + 45, y + 10);
            break;
        case 2:
            g.fill3DRect(x - 5, y - 5, 30, 30, false);
            g.fill3DRect(x - 25, y - 15, 20, 50, false);
            g.fill3DRect(x + 25, y - 15, 20, 50, false);
            g.fillOval(x, y, 20, 20);
            g.drawLine(x + 10, y + 20, x + 10, y + 45);
            break;
        case 3:
            g.fill3DRect(x - 5, y - 5, 30, 30, false);
            g.fill3DRect(x - 15, y - 25, 50, 20, false);
            g.fill3DRect(x - 15, y + 25, 50, 20, false);
            g.fillOval(x, y, 20, 20);
            g.drawLine(x, y + 10, x - 25, y + 10);
            break;
        }
    }

    @Override
    // F1~F12 功能按键 delete
    public void keyTyped(KeyEvent e) {
    }

    @Override
    // 事件源 监听键盘按下的按钮
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            mt.setDirect(0);
            mt.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mt.setDirect(1);
            mt.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mt.setDirect(2);
            mt.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mt.setDirect(3);
            mt.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            mt.fire();
        }
        // 必须重绘 不然动不了
        repaint();
    }

    @Override
    // 松开按键
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void run() {
        while (true) {
            try {
                // 让线程休眠一会 不然执行太快看不清楚
                Thread.sleep(50);
                // 必须重绘 不然子弹不动
                repaint();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
