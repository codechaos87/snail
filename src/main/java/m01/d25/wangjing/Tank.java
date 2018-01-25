package m01.d25.wangjing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Tank extends JPanel implements KeyListener {

    int x = 0, y = 0;

    /* int z1, z2, z3, z4, z5, a1, a2, a3, a4, a5; */

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.setColor(Color.pink);
        g.fillRect(x + 30, y + 30, 30, 80);
        g.fillRect(x + 60, y + 50, 60, 40);
        g.fillRect(x + 120, y + 30, 30, 80);
        g.setColor(Color.black);
        g.fillOval(x + 75, y + 55, 30, 30);
        g.fillRect(x + 87, y + 90, 5, 50);

        // g.drawLine(30, 30, 130, 30);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_A) {
            // a������
            this.x = x - 5;
            if (this.x <= -30) {
                this.x = -30;
            }
            System.out.println("����x=" + x);
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            this.y = y - 5;
            if (this.y <= -30) {
                this.y = -30;
            }
            System.out.println("����y=" + y);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            this.x = x + 5;
            if (this.x >= 635) {
                this.x = 635;
            }
            System.out.println("����x=" + x);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            this.y = y + 5;
            if (this.y >= 220) {
                this.y = 220;
            }
            System.out.println("����y=" + y);
        }
        /*
         * if (e.getKeyCode() == KeyEvent.VK_Y) { z1 = 80; a1 = 30; } if
         * (e.getKeyCode() == KeyEvent.VK_G) {
         * 
         * } if (e.getKeyCode() == KeyEvent.VK_G) {
         * 
         * } if (e.getKeyCode() == KeyEvent.VK_G) {
         * 
         * }
         */

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
