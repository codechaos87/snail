/**
 * Project Name:jdbc_01
 * File Name:Demo2.java
 * Package Name:com.class1.dao.java
 * Date:2018年3月28日下午4:19:10
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.class1.dao.java;

import java.util.Scanner;

import org.junit.Test;

import com.class1.dao.BizDao;
import com.class1.dao.entity.Info2;
import com.class1.dao.impl.BizDaoImpl;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:19:10 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class Demo2 {
    @Test
    public void save(){
        BizDao bizDao = new BizDaoImpl();
        Info2 ff = new Info2();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你的姓名");
        ff.setName(input.next());
        System.out.println("请输入你的生日");
        ff.setId(input.radix());
        int flag =bizDao.saveinfo2(ff);
        System.out.println("添加结束");
        
    }
}

