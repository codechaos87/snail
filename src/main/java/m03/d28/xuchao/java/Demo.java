/**
 * Project Name:DT59Team5
 * File Name:Demo.java
 * Package Name:m03.d28.xuchao.java
 * Date:2018年3月28日下午2:32:01
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.xuchao.java;

import java.util.Scanner;

import m03.d28.xuchao.dao.QuestionInfoDao;
import m03.d28.xuchao.dao.impl.QuestionInfoDaoImpl;

/**
 * Description:   测试类<br/>
 * Date:     2018年3月28日 下午2:32:01 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class Demo {

    public static void main(String[] args) {
        //生成实体类对象
        QuestionInfoDao qid = new QuestionInfoDaoImpl();
        System.out.println("****************欢迎使用试题管理系统****************");
        //标志位 用来打破循环
        boolean flag=true;
        Scanner input = new Scanner(System.in);
        do{
            System.out.println();
            System.out.print("请选择操作1(.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统):");
            int num=input.nextInt();
            switch (num) {
            case 1:
                //查询所有
                qid.getAllInfo();
                break;
            case 2:
                //根据科目查询
                qid.getSubjectInfo(input);
                break;
            case 3:
                //题干查询
                qid.getMohuInfo(input);
                break;
            case 4:
                //添加
                qid.update(input);
                break;
            case 5:
                //删除
                int flagDele=0;
                do {
                    System.out.print("请输入需要删除的试题编号：");
                    int questionId=input.nextInt();
                    flagDele=qid.delete(questionId);
                    //输入没有的编号返回0 继续循环输入
                    if(flagDele<1) {
                        System.out.println("对不起，没有要删除的编号！请重新输入");
                    }
                }while(flagDele<1);
                System.out.println("删除成功");
                break;
            case 6:
                System.out.println("退出成功！");
                flag=false;
                break;
            default:
                System.out.println("逗我呢？请重输！！！");
                break;
            }
        }while(flag);
        input.close();
    }

}

