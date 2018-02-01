/**
 * Project Name:snail
 * File Name:Queue.java
 * Package Name:m01.d24.xuchao.队列
 * Date:2018年1月24日下午7:23:43
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.xuchao.队列;

import java.util.LinkedList;

/**
 * 需求：添加add和get方法，实现先进先出的机制。<br/>
 * Description: <br/>
 * Date: 2018年1月24日 下午7:23:43 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class Queue {
    private LinkedList<String> list = new LinkedList<String>();

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
}
