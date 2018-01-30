/**
 * Project Name:wangguojun
 * File Name:TestQueue.java
 * Package Name:hw20180124
 * Date:2018年1月24日下午7:52:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.wangguojun;
/**
 * Description:   <br/>
 * Date:     2018年1月24日 下午7:52:53 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class TestQueue {

    public static void main(String[] args) {

        Queue q = new Queue();
        for (int i = 0; i < 7; i++) {
            q.add(i);
        }
        System.out.println(q.get());

    }

}

