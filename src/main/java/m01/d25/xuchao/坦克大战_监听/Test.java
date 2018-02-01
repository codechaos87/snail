/**
 * Project Name:snail
 * File Name:Test.java
 * Package Name:m01.d25.xuchao.坦克大战_监听
 * Date:2018年1月25日下午12:10:58
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d25.xuchao.坦克大战_监听;

import javax.swing.JFrame;

/**
 * Description: <br/>
 * Date: 2018年1月25日 下午12:10:58 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class Test extends JFrame {

    public static void main(String[] args) {

        Test test = new Test();
    }

    public Test() {
        // jPanel = new JPanel();
        // jPanel.setBackground(Color.black);
        // this.add(jPanel, BorderLayout.CENTER);

        MyPanel mp = new MyPanel();
        this.addKeyListener(mp);
        this.add(mp);

        this.setBounds(200, 200, 300, 300);
        this.setTitle("坦克大战");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setResizable(false);
        this.setVisible(true);
    }
}
