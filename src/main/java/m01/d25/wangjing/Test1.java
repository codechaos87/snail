/**
 * Project Name:JAVA01
 * File Name:Test.java
 * Package Name:m01.d25
 * Date:2018��1��25������12:00:18
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d25.wangjing;

import javax.swing.JFrame;

/**
 * Description: <br/>
 * Date: 2018��1��25�� ����12:00:18 <br/>
 * 
 * @author wangJing
 * @version
 * @see
 */
public class Test1 extends JFrame {

    public static void main(String[] args) {
        Test1 tt = new Test1();
    }

    public Test1() {

        Tank tk = new Tank();
        this.add(tk);
        this.addKeyListener(tk);

        this.setBounds(200, 200, 700, 500);
        this.setTitle("̹�˴�ս");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ؽ��
        this.setVisible(true);

    }
}
