/**
 * Project Name:DT593
 * File Name:Huahua.java
 * Package Name:lesson20180125
 * Date:2018年1月25日上午11:56:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.guojin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

/**
 * Description: <br/>
 * Date: 2018年1月25日 上午11:56:21 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class Huahua extends JPanel implements KeyListener, Runnable {

    Tank hero = null;

    public Huahua() {
        hero = new Hero(50, 10);
    }

    @Override
    public void paintComponent(Graphics g) {

        // Auto-generated method stub
        super.paintComponent(g);
        g.fillRect(0, 0, 600, 600);
        drTank(hero.getX(), hero.getY(), g, hero.Direct, 2);
        for (int i = 0; i < hero.vect.size(); i++) {
            Shot ot = hero.vect.get(i);
            if (ot.isLive() == true && hero.vect != null) {
                g.fill3DRect(ot.getX(), ot.getY(), 3, 3, false);
            }
            if (ot.isLive() == false) {
                hero.vect.remove(ot);
            }
        }
        // g.setColor(Color.red);
        // g.fillOval(a + 30, b + 40, 20, 20);
        // g.fillOval(a + 30, c + 60, 20, 20);
        // // g.drawLine(30, 60, 120, 60);
        // g.setColor(Color.BLACK);
        // g.draw3DRect(x - 10, y + 55, 50, 10, true);
        // g.fill3DRect(x - 10, y + 55, 50, 10, true);

    }

    public void drTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
        case 0: {
            g.setColor(Color.blue);
            break;
        }
        case 1: {
            g.setColor(Color.yellow);
        }
        case 2: {
            g.setColor(Color.red);
        }
            switch (direct) {
            case 0:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x + 15, y, 5, 30, false);
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                g.fillOval(x + 4, y + 10, 10, 10);
                g.drawLine(x + 9, y + 15, x + 9, y);
                break;
            case 1:
                g.fill3DRect(x, y, 5, 30, false);
                g.fill3DRect(x + 15, y, 5, 30, false);
                g.fill3DRect(x + 5, y + 5, 10, 20, false);
                g.fillOval(x + 4, y + 10, 10, 10);
                g.drawLine(x + 9, y + 15, x + 9, y + 30);
                break;
            case 2:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.fillOval(x + 9, y + 4, 10, 10);
                g.drawLine(x + 5, y + 9, x - 4, y + 9);
                break;
            case 3:
                g.fill3DRect(x, y, 30, 5, false);
                g.fill3DRect(x, y + 15, 30, 5, false);
                g.fill3DRect(x + 5, y + 5, 20, 10, false);
                g.fillOval(x + 9, y + 4, 10, 10);
                g.drawLine(x + 15, y + 9, x + 30, y + 9);
                break;
            default:
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent ex) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(1);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(2);
            hero.moveLeft();

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(3);
            hero.moveRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            hero.File();

        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
                this.repaint();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
        // Auto-generated method stub

    }
}
