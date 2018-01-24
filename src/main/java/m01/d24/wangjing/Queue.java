/**
 * Project Name:NewLife
 * File Name:Queue.java
 * Package Name:a_002
 * Date:2018年1月24日下午11:29:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package a_002;

import java.util.LinkedList;

/**
 * Description: <br/>
 * Date: 2018年1月24日 下午11:29:33 <br/>
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
            System.out.println("列表为空");
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        // 调用add方法，依次插入元素。
        queue.add("A");
        queue.add("B");
        queue.add("C");
        // 调用get方法，看元素的遍历顺序
        queue.get();
    }
}
