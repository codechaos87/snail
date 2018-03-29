/**
 * Project Name:DT59Team5
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:m03.d28.xuchao.dao.impl
 * Date:2018年3月28日下午2:18:40
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d29.xuchao.dao.impl;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import m03.d29.xuchao.dao.BaseDao;
import m03.d29.xuchao.dao.QuestionInfoDao;
import m03.d29.xuchao.entity.QuestionInfo;


/**
 * Description:   实现类 继承父类和实现接口 实现各种方法<br/>
 * Date:     2018年3月28日 下午2:18:40 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    @Override
    public List<QuestionInfo> getAllInfo() {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
//        String sql = "SELECT * FROM question_info";
        //存储过程sql语句
        String sql = "CALL ups_getAllInfo";
        try {
//            pst=getCon().prepareStatement(sql);
            //调用存储过程的方法
            CallableStatement cst = getCon().prepareCall(sql);
//            rs=pst.executeQuery();
            rs=cst.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(con,pst,rs,cst);
        }
        return list;
    }
    
    @Override
    public List<QuestionInfo> getSubjectInfo(int qsubject) {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        String sql = "SELECT * FROM question_info WHERE qsubject = ?";
        try {
            pst=getCon().prepareStatement(sql);
            pst.setInt(1, qsubject);
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
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(con,pst,rs,cst);
        }
        return list;
    }
    
    @Override
    public List<QuestionInfo> getMohuInfo(String question) {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
//        String sql = "SELECT * FROM question_info WHERE question LIKE ?";//问号占位
        String sql = "CALL ups_getMohuInfo(?)";
        try {
//            pst=getCon().prepareStatement(sql);
//            pst.setString(1,"%"+question+"%");
            cst = getCon().prepareCall(sql);
            cst.setString(1, "%"+question+"%");
//            rs=pst.executeQuery();
            rs=cst.executeQuery();
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
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(con,pst,rs,cst);
        }
        return list;
    }

    @Override
    public int update(Object[] obj) {
        int flag =0;
        StringBuffer sb = new StringBuffer();//使用缓冲区拼接字符串
        sb.append("INSERT INTO question_info ");
        sb.append("(question,optionA,optionB,optionC,optionD,qsubject,answer) ");
        sb.append("VALUES(?,?,?,?,?,?,?)");
        String sql=sb.toString();//转换成字符串
        try {
            pst = getCon().prepareStatement(sql);
            //controlDML是父类BaseDao的方法
            flag = controlDML(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
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

