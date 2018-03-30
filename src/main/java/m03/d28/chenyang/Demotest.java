/**
 * Project Name:snail
 * File Name:Demotest.java
 * Package Name:m03.d28.chenyang
 * Date:2018年3月28日下午8:04:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.chenyang;

import java.util.List;
import java.util.Scanner;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午8:04:03 <br/>
 * @author   chenyang
 * @version
 * @see
 */
public class Demotest {

    public static void main(String[] args) {

        //  Auto-generated method stub
      QuestionInfoDao qd = new QuestionInfoDaoImpl();
      Scanner sc = new Scanner(System.in);
      System.out.println("***********************欢迎使用试题管理系统***********************");
      boolean flag = true;
      while(flag){
      System.out.println("请选择操作(1.列出所有试题  2.按科目查询  3.按题干模糊查询  4.添加试题  5.删除试题  6.退出系统):");
      int i = sc.nextInt();
      switch(i){
      case 1:
          List<QuestionInfo> allInfo = qd.getALLInfo();
          for (QuestionInfo questionInfo : allInfo) {
           System.out.println(questionInfo.getQuestionId()+"、"+questionInfo.getQuestion());
           System.out.println("\t"+questionInfo.getOptionA());
           System.out.println("\t"+questionInfo.getOptionB());
           System.out.println("\t"+questionInfo.getOptionC());
           System.out.println("\t"+questionInfo.getOptionD());
           System.out.println("\t"+"答案"+questionInfo.getAnswer());
         }
          break;
      case 2:
           System.out.println("请输入科目：(1.Java 2.C# 3.JSP)");
           int b = sc.nextInt();
           List<QuestionInfo> allInfo1 = qd.selectS(b);
           for (QuestionInfo questionInfo : allInfo1) {
               System.out.println(questionInfo.getQuestionId()+"、"+questionInfo.getQuestion());
               System.out.println("\t"+questionInfo.getOptionA());
               System.out.println("\t"+questionInfo.getOptionB());
               System.out.println("\t"+questionInfo.getOptionC());
               System.out.println("\t"+questionInfo.getOptionD());
               System.out.println("\t"+"答案"+questionInfo.getAnswer());
           }
           break;
      case 3:
          System.out.println("请输入题干：");
          String str = sc.next();
          List<QuestionInfo> allInfo2 = qd.mohu(str);
          for (QuestionInfo questionInfo : allInfo2) {
              System.out.println(questionInfo.getQuestionId()+"、"+questionInfo.getQuestion());
              System.out.println("\t"+questionInfo.getOptionA());
              System.out.println("\t"+questionInfo.getOptionB());
              System.out.println("\t"+questionInfo.getOptionC());
              System.out.println("\t"+questionInfo.getOptionD());
              System.out.println("\t"+"答案"+questionInfo.getAnswer());
           }
          break;
      case 4:
          System.out.println("请输入科目：(1.Java 2.C# 3.JSP):");
          int aa = sc.nextInt();
          System.out.println("请输入新题干：");
          String bb = sc.next();
          System.out.println("请输入新的选项A：");
          String a1 = sc.next();
          System.out.println("请输入新的选项B：");
          String b1 = sc.next();
          System.out.println("请输入新的选项C：");
          String c1 = sc.next();
          System.out.println("请输入新的选项D：");
          String d1 = sc.next();
          System.out.println("请输入新的答案：");
          String e1 = sc.next();
          QuestionInfo qi = new QuestionInfo();
          qi.setSubject(aa);
          qi.setQuestion(bb);
          qi.setOptionA(a1);
          qi.setOptionB(b1);
          qi.setOptionC(c1);
          qi.setOptionD(d1);
          qi.setAnswer(e1);
          int saveQ = qd.saveQ(qi);
          if(saveQ==1){
          System.out.println("添加成功！");
          }else{
              System.out.println("添加失败！");
          }
          break;
      case 5:
          System.out.println("请输入要删除的试题编号：");
          int cc = sc.nextInt();
          int delectQ = qd.delectQ(cc);
          if(delectQ==1){
              System.out.println("删除成功！");  
          }else{
            System.out.println("删除失败！");  
          }
          break;
      case 6:
          flag= false;
          break;
         }
      }
      }
    }



