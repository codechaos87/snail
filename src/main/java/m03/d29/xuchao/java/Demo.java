/**
 * Project Name:DT59Team5
 * File Name:Demo.java
 * Package Name:m03.d28.xuchao.java
 * Date:2018年3月28日下午2:32:01
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d29.xuchao.java;

import java.util.List;
import java.util.Scanner;

import m03.d29.xuchao.dao.QuestionInfoDao;
import m03.d29.xuchao.dao.impl.QuestionInfoDaoImpl;
import m03.d29.xuchao.entity.QuestionInfo;

/**
 * Description:   测试类<br/>
 * Date:     2018年3月28日 下午2:32:01 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class Demo {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.init();
    }
    Scanner input = new Scanner(System.in);
    QuestionInfoDao qid = new QuestionInfoDaoImpl();
    public void init() {
        System.out.println("****************欢迎使用试题管理系统****************");
        //标志位 用来打破循环
        boolean flag=true;
        do{
            System.out.println();
            System.out.print("请选择操作1(.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统):");
            int num=input.nextInt();
            switch (num) {
            case 1:
                getAllInfo();
                break;
            case 2:
                getSubjectInfo();
                break;
            case 3:
                getMohuInfo();
                break;
            case 4:
                update();
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
                input.close();
                break;
            default:
                System.out.println("逗我呢？请重输！！！");
                break;
            }
        }while(flag);
    }
    
    public void getAllInfo() {
        List<QuestionInfo> list = qid.getAllInfo();
        for (QuestionInfo qi : list) {
            System.out.println(qi.getQuestionId()+"、"+qi.getQuestion());
            System.out.println("\t选项A："+qi.getOptionA());
            System.out.println("\t选项B："+qi.getOptionB());
            System.out.println("\t选项C："+qi.getOptionC());
            System.out.println("\t选项D："+qi.getOptionD());
            System.out.println("\t答案："+qi.getAnswer());
        }
    }
    
    public void getSubjectInfo() {
        System.out.print("请输入科目：(1.java 2.C# 3.JSP)：");
        int qsubject=input.nextInt();
        List<QuestionInfo> list=qid.getSubjectInfo(qsubject);
        for (QuestionInfo qi : list) {
            System.out.println(qi.getQuestionId()+"、"+qi.getQuestion());
            System.out.println("\t选项A："+qi.getOptionA());
            System.out.println("\t选项B："+qi.getOptionB());
            System.out.println("\t选项C："+qi.getOptionC());
            System.out.println("\t选项D："+qi.getOptionD());
            System.out.println("\t答案："+qi.getAnswer());
        }
    }
    
    public void getMohuInfo() {
        System.out.print("请输入题干：");
        String question = input.next();
        List<QuestionInfo> list=qid.getMohuInfo(question);
        for (QuestionInfo qi : list) {
            System.out.println(qi.getQuestionId()+"、"+qi.getQuestion());
            System.out.println("\t选项A："+qi.getOptionA());
            System.out.println("\t选项B："+qi.getOptionB());
            System.out.println("\t选项C："+qi.getOptionC());
            System.out.println("\t选项D："+qi.getOptionD());
            System.out.println("\t答案："+qi.getAnswer());
        }
    }
    
    public void update() {
        System.out.print("请输入科目：(1.Java 2.C# 3.JSP)：");
        int newQsubject=input.nextInt();
        System.out.print("请输入新的题干：");
        String newQuestion=input.next();
        System.out.print("请输入新的选项A：");
        String newOptionA=input.next();
        System.out.print("请输入新的选项B：");
        String newOptionB=input.next();
        System.out.print("请输入新的选项C：");
        String newOptionC=input.next();
        System.out.print("请输入新的选项D：");
        String newOptionD=input.next();
        System.out.print("请输入新的答案：");
        String newAnswer=input.next();
        QuestionInfo qi =
                new QuestionInfo
                (newQuestion,newOptionA,newOptionB,newOptionC,newOptionD,newQsubject,newAnswer);
        Object[] obj = new Object[7];
        obj[0]=qi.getQuestion();
        obj[1]=qi.getOptionA();
        obj[2]=qi.getOptionB();
        obj[3]=qi.getOptionC();
        obj[4]=qi.getOptionD();
        obj[5]=qi.getQsubject();
        obj[6]=qi.getAnswer();
        int flag= qid.update(obj);
        if(flag>0) {
            System.out.println("添加成功");
        }else {
            System.out.println("添加失败");
        }
    }
}

