/**
 * Project Name:snail
 * File Name:Test.java
 * Package Name:m01.d27.xuchao.发射子弹
 * Date:2018年1月27日下午2:30:01
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d27.xuchao;

import javax.swing.JFrame;

/**
 * Description: <br/>
 * Date: 2018年1月27日 下午2:30:01 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class Test extends JFrame {

    public static void main(String[] args) {
        // 调用自身构造器执行操作
        Test test = new Test();
    }

    public Test() {
        // 通过构造器来初始化对象mp
        MyPanel mp = new MyPanel();
        // this指JFrame 监听者 给其添加监听的事件
        this.addKeyListener(mp);
        // 新建并运行mp线程
        Thread thread = new Thread(mp);
        thread.start();

        // 将mp绘制的图形显示到JFrame
        this.add(mp);
        // 设置边框初始出现位置和大小
        this.setBounds(200, 200, 400, 400);
        // 设置题目
        this.setTitle("坦克大战");
        // 设置退出按键
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 可视化
        this.setVisible(true);
        // 可拖拽
        this.setResizable(false);
    }
}
