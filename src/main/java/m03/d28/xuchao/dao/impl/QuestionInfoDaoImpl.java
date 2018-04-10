/**
 * Project Name:DT59Team5
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:m03.d28.xuchao.dao.impl
 * Date:2018年3月28日下午2:18:40
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.xuchao.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import m03.d28.xuchao.dao.BaseDao;
import m03.d28.xuchao.dao.QuestionInfoDao;
import m03.d28.xuchao.entity.QuestionInfo;

/**
 * Description:   实现类 继承父类和实现接口 实现各种方法<br/>
 * Date:     2018年3月28日 下午2:18:40 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    @Override
    public void getAllInfo() {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        String sql = "SELECT * FROM question_info";
        try {
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()) {
                QuestionInfo qi=new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setQsubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);
            }
            for (QuestionInfo qi : list) {
                System.out.println(qi.getQuestionId()+"、"+qi.getQuestion());
                System.out.println("\t选项A："+qi.getOptionA());
                System.out.println("\t选项B："+qi.getOptionB());
                System.out.println("\t选项C："+qi.getOptionC());
                System.out.println("\t选项D："+qi.getOptionD());
                System.out.println("\t答案："+qi.getAnswer());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(con,pst,rs);
        }
    }
    
    @Override
    public void getSubjectInfo(Scanner input) {
        System.out.print("请输入科目：(1.java 2.C# 3.JSP)：");
        int qsubject=input.nextInt();
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        String sql = "SELECT * FROM question_info";
        try {
            pst=getCon().prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()) {
                QuestionInfo qi=new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setQsubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);
            }
            for (QuestionInfo qi : list) {
                if(qi.getQsubject()==qsubject) {
                    System.out.println(qi.getQuestionId()+"、"+qi.getQuestion());
                    System.out.println("\t选项A："+qi.getOptionA());
                    System.out.println("\t选项B："+qi.getOptionB());
                    System.out.println("\t选项C："+qi.getOptionC());
                    System.out.println("\t选项D："+qi.getOptionD());
                    System.out.println("\t答案："+qi.getAnswer());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(con,pst,rs);
        }
    }
    
    @Override
    public void getMohuInfo(Scanner input) {
        System.out.print("请输入题干：");
        String question = input.next();
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        String sql = "SELECT * FROM question_info WHERE question LIKE ?";//问号占位
        try {
            pst=getCon().prepareStatement(sql);
            pst.setString(1,"%"+question+"%");
            rs=pst.executeQuery();
            while(rs.next()) {
                QuestionInfo qi=new QuestionInfo();
                qi.setQuestionId(rs.getInt(1));
                qi.setQuestion(rs.getString(2));
                qi.setOptionA(rs.getString(3));
                qi.setOptionB(rs.getString(4));
                qi.setOptionC(rs.getString(5));
                qi.setOptionD(rs.getString(6));
                qi.setQsubject(rs.getInt(7));
                qi.setAnswer(rs.getString(8));
                list.add(qi);
            }
            for (QuestionInfo qi : list) {
                System.out.println(qi.getQuestionId()+"、"+qi.getQuestion());
                System.out.println("\t选项A："+qi.getOptionA());
                System.out.println("\t选项B："+qi.getOptionB());
                System.out.println("\t选项C："+qi.getOptionC());
                System.out.println("\t选项D："+qi.getOptionD());
                System.out.println("\t答案："+qi.getAnswer());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(con,pst,rs);
        }
    }

    @Override
    public void update(Scanner input) {
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
        Object[] obj = new Object[7];//用Object数组接收数据当参数传递
        obj[0]=qi.getQuestion();
        obj[1]=qi.getOptionA();
        obj[2]=qi.getOptionB();
        obj[3]=qi.getOptionC();
        obj[4]=qi.getOptionD();
        obj[5]=qi.getQsubject();
        obj[6]=qi.getAnswer();
        StringBuffer sb = new StringBuffer();//使用缓冲区拼接字符串
        sb.append("INSERT INTO question_info ");
        sb.append("(question,optionA,optionB,optionC,optionD,qsubject,answer) ");
        sb.append("VALUES(?,?,?,?,?,?,?)");
        String sql=sb.toString();//转换成字符串
        try {
            pst = getCon().prepareStatement(sql);
            //controlDML是父类BaseDao的方法
            System.out.println(controlDML(sql, obj)>0?"添加成功":"添加失败");//三目运算符
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int delete(int questionId) {
        int flag=0;
        String sql = "DELETE FROM question_info WHERE questionId=?";
        try {
            pst=getCon().prepareStatement(sql);
            Object[] obj = new Object[1];
            obj[0]=questionId;
            flag=controlDML(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}

