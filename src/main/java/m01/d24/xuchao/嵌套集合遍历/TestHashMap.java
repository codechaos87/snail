/**
 * Project Name:snail
 * File Name:TestHashMap.java
 * Package Name:m01.d24.xuchao.嵌套集合遍历
 * Date:2018年1月24日下午7:50:33
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.xuchao.嵌套集合遍历;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description: <br/>
 * Date: 2018年1月24日 下午7:50:33 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class TestHashMap {

    public static void main(String[] args) {
        // 生成一个类型也是集合的集合 二维集合
        List<HashMap<Integer, Person>> list = new ArrayList<HashMap<Integer, Person>>();

        // 用泛型Map生成一个键值对集合 给其添加元素
        Map<Integer, Person> map1 = new HashMap<Integer, Person>();
        Person p1 = new Person(110, "小明");
        Person p2 = new Person(120, "小黄");
        Person p3 = new Person(130, "小篮");
        map1.put(p1.getId(), p1);
        map1.put(p2.getId(), p2);
        map1.put(p3.getId(), p3);

        // 将这个集合类型元素添加到最外层的集合里
        list.add((HashMap<Integer, Person>) map1);

        // 重复添加操作
        Map<Integer, Person> map2 = new HashMap<Integer, Person>();
        Person pp1 = new Person(140, "张三");
        Person pp2 = new Person(150, "李四");
        Person pp3 = new Person(160, "王麻子");
        map2.put(pp1.getId(), pp1);
        map2.put(pp2.getId(), pp2);
        map2.put(pp3.getId(), pp3);
        list.add((HashMap<Integer, Person>) map2);

        // 设置一个标志位
        int count = 1;

        // 首先循环最外层
        for (HashMap<Integer, Person> hashMap : list) {
            System.out.println("第" + count + "遍");
            // 因为HashMap本身没有迭代器，用keySet方法或者K值集合遍历K值，同时用K值获取V值，遍历V值。
            Set<Integer> set = hashMap.keySet();
            Iterator<Integer> iter = set.iterator();
            while (iter.hasNext()) {
                /*
                 * 错误示范<br/>
                 * 
                 * iter.next()只能取一次 所以后面取V值时再调用这个方法就会出异常
                 * 
                 * System.out.println(iter.next() + "\t"
                 * +hashMap.get(iter.next()).getName());
                 */
                Integer key = iter.next();
                System.out.println(key + "\t" + hashMap.get(key).getName());

            }
            count++;
        }
    }
}
