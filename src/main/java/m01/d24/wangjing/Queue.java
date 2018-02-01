/**
 * Project Name:NewLife
 * File Name:Queue.java
 * Package Name:a_002
 * Date:2018��1��24������11:29:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.wangjing;

import java.util.LinkedList;

/**
 * Description: <br/>
 * Date: 2018��1��24�� ����11:29:33 <br/>
 * 
 * @author wangJing
 * @version
 * @see
 */
public class Queue {
    LinkedList<String> list = new LinkedList<String>();

    public void add(String str) {
        list.addFirst(str);
    }

    public void get() {
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } else {
            System.out.println("�б�Ϊ��");
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        // ����add���������β���Ԫ�ء�
        queue.add("A");
        queue.add("B");
        queue.add("C");
        // ����get��������Ԫ�صı���˳��
        queue.get();
    }
}
