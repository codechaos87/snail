/**
 * Project Name:wangguojun
 * File Name:Queue.java
 * Package Name:hw20180124
 * Date:2018年1月24日下午7:37:17
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.wangguojun;

import java.util.LinkedList;

/**
 * Description:   <br/>
 * Date:     2018年1月24日 下午7:37:17 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class Queue {
    // LinkedList本来具备队列功能，所以生成就行
    private static LinkedList<Object> aa;

    // 构造方法，生成列表
    public Queue() {
        if (aa == null) {
            aa = new LinkedList<Object>();
        }
    }

    // 将指定元素添加到列表后面
    public void add(Object a) {
        aa.addFirst(a);
    }

    // 找到并移除次列表的第一个
    public Object get() {
        return aa.removeLast();
    }

}

