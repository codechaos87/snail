/**
 * Project Name:snail
 * File Name:MyPanel.java
 * Package Name:m01.d25.xuchao.坦克大战_监听
 * Date:2018年1月25日下午2:39:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d25.xuchao.坦克大战_监听;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Description: <br/>
 * Date: 2018年1月25日 下午2:39:53 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class MyPanel extends Panel implements KeyListener {

    Hero hero = null;

    public MyPanel() {
        hero = new Hero(50, 50);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 300, 300);
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect());
    }

    public void drawTank(int x, int y, Graphics g, int direct) {
        switch (direct) {
        case 0:// 向上
            g.setColor(Color.orange);
            g.fill3DRect(x - 5, y - 5, 30, 30, false);
            g.fill3DRect(x - 25, y - 15, 20, 50, false);
            g.fill3DRect(x + 25, y - 15, 20, 50, false);
            g.fillOval(x, y, 20, 20);
            g.drawLine(x + 10, y, x + 10, y - 25);
            break;
        case 1:// 向下
            g.setColor(Color.orange);
            g.fill3DRect(x - 5, y - 5, 30, 30, false);
            g.fill3DRect(x - 25, y - 15, 20, 50, false);
            g.fill3DRect(x + 25, y - 15, 20, 50, false);
            g.fillOval(x, y, 20, 20);
            g.drawLine(x + 10, y + 20, x + 10, y + 45);
            break;
        case 2:// 向左
            g.setColor(Color.orange);
            g.fill3DRect(x - 5, y - 5, 30, 30, false);
            g.fill3DRect(x - 15, y - 25, 50, 20, false);
            g.fill3DRect(x - 15, y + 25, 50, 20, false);
            g.fillOval(x, y, 20, 20);
            g.drawLine(x, y + 10, x - 25, y + 10);
            break;
        case 3:// 向右
            g.setColor(Color.orange);
            g.fill3DRect(x - 5, y - 5, 30, 30, false);
            g.fill3DRect(x - 15, y - 25, 50, 20, false);
            g.fill3DRect(x - 15, y + 25, 50, 20, false);
            g.fillOval(x, y, 20, 20);
            g.drawLine(x + 20, y + 10, x + 45, y + 10);
            break;
        }
    }

    @Override
    // F1~F12 功能按键 delete
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(2);
            hero.moveleft();
            // if (hero.getX() <= 25) {
            //
            // }
            // System.out.println("向左x=" + x);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            hero.moveup();
            // if (this.y <= 25) {
            // this.y = 25;
            // }
            // System.out.println("向上y=" + y);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(3);
            hero.moveright();
            // System.out.println("向右x=" + x);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(1);
            hero.movedown();
            // System.out.println("向下y=" + y);
        }
        this.repaint();
    }

    @Override
    // 松掉按键
    public void keyReleased(KeyEvent e) {

    }

}
