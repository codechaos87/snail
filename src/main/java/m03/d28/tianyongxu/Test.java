/**
 * Project Name:jdbc_01
 * File Name:Test.java
 * Package Name:com.class1.dao.java
 * Date:2018年3月28日下午7:13:13
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package com.class1.dao.java;

import java.util.List;
import java.util.Scanner;

import com.class1.dao.BizDao;
import com.class1.dao.entity.Info;
import com.class1.dao.impl.BizDaoImpl;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午7:13:13 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        BizDao bizDao = new BizDaoImpl();
        List<Info> list = bizDao.getAllInfo();
        for (Info ff : list) {
            System.out.println(ff.getId()+"\t"+ff.getName()+"\t"+ff.getAge());
        }
        Scanner input =new Scanner(System.in);
        System.out.println("请输入要删除的编号:");
        int id=input.nextInt();
        int flag= bizDao.deleteinfo(id);
        System.out.println("删除的结果："+flag);
        System.out.println("=====================结果是：======================");
        List<Info> list2= bizDao.getAllInfo();
        for (Info ff : list2) {
            System.out.println(ff.getId()+"\t"+ff.getName()+"\t"+ff.getAge());
        }

    }

}

