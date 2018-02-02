/**
 * Project Name:DT593
 * File Name:Test.java
 * Package Name:lesson20180125
 * Date:2018年1月25日上午11:52:04
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.guojin;

import javax.swing.JFrame;

/**
 * Description: <br/>
 * Date: 2018年1月25日 上午11:52:04 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class Test extends JFrame {

    public Test() {
        Huahua p1 = new Huahua();
        addKeyListener(p1);
        Thread th = new Thread(p1);
        th.start();
        add(p1);
        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new Test();

    }
}
