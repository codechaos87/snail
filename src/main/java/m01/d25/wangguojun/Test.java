/**
 * Project Name:snail9
 * File Name:Test.java
 * Package Name:m01.d25.wangguojun
 * Date:2018年1月25日下午3:09:10
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d25.wangguojun;

import javax.swing.JFrame;

/**
 * Description:   <br/>
 * Date:     2018年1月25日 下午3:09:10 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
@SuppressWarnings("serial")
public class Test extends JFrame {

    public static void main(String[] args) {
        Test tt = new Test();

    }

    public Test() {
        MyPanel mp = new MyPanel();
        Thread th = new Thread(mp);// mp指的是坦克，记得加
        th.start();
        this.addKeyListener(mp);
        this.add(mp);

        // 窗体出场的位置aww
        this.setBounds(200, 200, 400, 350);
        //
        this.setTitle("坦克大战");
        // 退出时关闭线程
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 窗体显示
        this.setVisible(true);

    }
}

