package m01.d27.wanjing;

import javax.swing.JFrame;

public class Test extends JFrame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Test tt = new Test();
    }

    public Test() {
        MyPanel mp = new MyPanel();

        this.addKeyListener(mp);
        this.add(mp);

        this.setBounds(200, 200, 800, 400);
        this.setTitle("̹�˴�ս");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
