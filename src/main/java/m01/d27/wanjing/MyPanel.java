package m01.d27.wanjing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements KeyListener {
    MyTank mt = null;

    public MyPanel() {
        mt = new MyTank(30, 30);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.setColor(Color.gray);
        g.fillRect(0, 0, 800, 400);
        drawTank(mt.getX(), mt.getY(), 0, mt.getDirect(), g);

    }

    public void drawTank(int x, int y, int type, int direct, Graphics g) {
        switch (type) {
        case 0:// �о�

            break;

        case 1:// ��

            break;
        }
        switch (direct) {
        case 0:// ����
            g.setColor(Color.pink);
            g.fillRect(x + 30, y + 30, 30, 80);
            g.fillRect(x + 60, y + 50, 60, 40);
            g.fillRect(x + 120, y + 30, 30, 80);
            g.setColor(Color.black);
            g.fillOval(x + 75, y + 55, 30, 30);
            g.fillRect(x + 87, y, 5, 50);
            g.setColor(Color.red);
            g.fillOval(x + 87, y - 10, 5, 5);
            break;

        case 1:// ����
            g.setColor(Color.pink);
            g.fillRect(x + 30, y + 30, 30, 80);
            g.fillRect(x + 60, y + 50, 60, 40);
            g.fillRect(x + 120, y + 30, 30, 80);
            g.setColor(Color.black);
            g.fillOval(x + 75, y + 55, 30, 30);
            g.fillRect(x + 87, y + 90, 5, 50);
            g.setColor(Color.red);
            g.fillOval(x + 87, y + 150, 5, 5);
            break;

        case 2:// ����
            g.setColor(Color.pink);
            g.fillRect(x + 30, y + 30, 80, 30);
            g.fillRect(x + 50, y + 60, 40, 60);
            g.fillRect(x + 30, y + 120, 80, 30);
            g.setColor(Color.black);
            g.fillOval(x + 55, y + 70, 30, 30);
            g.fillRect(x + 90, y + 85, 50, 5);
            g.setColor(Color.red);
            g.fillOval(x + 150, y + 85, 5, 5);

            break;

        case 3:// ����
            g.setColor(Color.pink);
            g.fillRect(x + 30, y + 30, 80, 30);
            g.fillRect(x + 50, y + 60, 40, 60);
            g.fillRect(x + 30, y + 120, 80, 30);
            g.setColor(Color.black);
            g.fillOval(x + 55, y + 70, 30, 30);
            g.fillRect(x, y + 85, 50, 5);
            g.setColor(Color.red);
            g.fillOval(x - 10, y + 85, 5, 5);

            break;

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            mt.setDirect(0);
            moveup();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            mt.setDirect(1);
            movedowm();

        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            mt.setDirect(2);
            moveright();

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            mt.setDirect(3);
            moveleft();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {

        }
        this.repaint();
    }

    private void moveright() {

        int x = mt.getX() + 3;
        if (x >= 624) {
            x = 624;
        }

        mt.setX(x);
        System.out.println("��ǰx" + x);

    }

    private void moveleft() {

        int x = mt.getX() - 3;
        if (x <= 12) {
            x = 12;
        }
        mt.setX(x);
        System.out.println("��ǰx" + x);
    }

    private void movedowm() {

        int y = mt.getY() + 3;
        if (y >= 261) {
            y = 201;
        }

        mt.setY(y);
        System.out.println("��ǰy" + y);

    }

    private void moveup() {

        int y = mt.getY() - 3;

        if (y <= 12) {
            y = 12;
        }
        mt.setY(y);
        System.out.println("��ǰy" + y);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
