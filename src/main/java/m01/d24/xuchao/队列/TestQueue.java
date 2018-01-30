/**
 * Project Name:snail
 * File Name:TestQueue.java
 * Package Name:m01.d24.xuchao.队列
 * Date:2018年1月24日下午7:26:48
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.xuchao.队列;

/**
 * Description: <br/>
 * Date: 2018年1月24日 下午7:26:48 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class TestQueue {

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
