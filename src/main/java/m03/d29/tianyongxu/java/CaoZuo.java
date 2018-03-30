/**
 * Project Name:jdbc_03
 * File Name:CaoZuo.java
 * Package Name:com.jdbc.java
 * Date:2018年3月30日下午1:42:03
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d29.tianyongxu.java;

import java.util.List;
import java.util.Scanner;

import com.jdbc.dao.impl.BaseDaoImpl;
import com.jdbc.entity.Information;

/**
 * Description:   <br/>
 * Date:     2018年3月30日 下午1:42:03 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class CaoZuo {
        Scanner input = new Scanner(System.in);
        public void show(){
            System.out.println("****************欢迎来到考试操作系统*****************");
            System.out.println("1、列出所有的题目 2、按科目查询 3、按题干模糊查询 4、添加试题 5 删除试题 6 退出系统");
            int key = input.nextInt();
            switch (key) {
                case 1:
                    //查询所有的方法
                    selectAll();
                    fanhui();
                    break;
                case 2:
                    //按科目查询的方法
                    selectKemu();
                    fanhui();
                    break;
                case 3:
                    //按题干模糊查询
                    selectTg();
                    fanhui();
                    break;
                case 4:
                    //添加试题
                    addTi();
                    fanhui();
                    break;
                case 5:
                    //删除试题
                    deleteTimu();
                    fanhui();
                    break;
                case 6:
                    System.exit(1);
                    break;
        
                }
                    
       }
        BaseDaoImpl bdi = new BaseDaoImpl();
        public void selectAll(){
           
           List<Information> list = bdi.selectAll();
           for (Information inf: list) {
            System.out.print(inf.getQuestionId()+inf.getQuestion()+inf.getOptionA()+inf.getOptionA()+inf.getOptionB()+inf.getOptionC()+inf.getOptionD());
            System.out.println();
        }
        }
        public void selectKemu(){
            System.out.println("请问您想查询的第几条信息");
            int subject = input.nextInt();
            List<Information> list = bdi.selectKemu(subject);
            for (Information inf: list) {
             System.out.print(inf.getQuestionId()+inf.getQuestion()+inf.getOptionA()+inf.getOptionA()+inf.getOptionB()+inf.getOptionC()+inf.getOptionD());
             System.out.println();
            }
            
        }
        public void selectTg(){
            System.out.println("请输入您想查询的题干");
            String tigan = input.next();
              List<Information> list = bdi.selectTg(tigan);
              for (Information inf: list) {
                  System.out.print(inf.getQuestionId()+inf.getQuestion()+inf.getOptionA()+inf.getOptionA()+inf.getOptionB()+inf.getOptionC()+inf.getOptionD());
                  System.out.println();
                 }
        }
        public void addTi(){//这么多信息肯定还是要添加到实体类中去。
            System.out.println("请输入你想添加的题目信息");
            System.err.println("请添加题干");
            String tg = input.next();
            System.out.println("请添加选项A");
            String xx1 = input.next();
            System.out.println("请添加选项B");
            String xx2 = input.next();
            System.out.println("请添加选项C");
            String xx3 = input.next();
            System.out.println("请添加选项D");
            String xx4 = input.next();
            System.out.println("请添加科目");
            Integer km = input.nextInt();
            System.out.println("请添答案");
            String da = input.next();
            Information infos = new Information();
            infos.setQuestion(tg);
            infos.setOptionA(xx1);
            infos.setOptionB(xx2);
            infos.setOptionC(xx3);
            infos.setOptionD(xx4);
            infos.setSubject(km);
            infos.setAnswer(da);
            bdi.addtimu(infos);
             
        }
        public void deleteTimu(){
            System.out.println("请输入你要删除的行");
            int dele = input.nextInt();
             bdi.deleteTimu(dele);
        }
        public void fanhui(){
            System.out.println("是否返回上一级,y/n");
            String yes = input.next();
            if (yes.equalsIgnoreCase("y")) {
                show();
            }
        }
      
}

