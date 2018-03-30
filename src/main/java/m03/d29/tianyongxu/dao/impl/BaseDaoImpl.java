/**
 * Project Name:jdbc_03
 * File Name:BaseDaoImpl.java
 * Package Name:com.jdbc.dao.impl
 * Date:2018年3月30日上午11:46:09
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d29.tianyongxu.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.BaseDao;
import com.jdbc.entity.Information;

/**
 * Description:   <br/>
 * Date:     2018年3月30日 上午11:46:09 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class BaseDaoImpl extends BaseDao{
    
      public List<Information> selectAll(){
          List<Information> list = new ArrayList<Information>();
           try {
               String sql = "SELECT * FROM exam";
               //这里继承了工具类BaseDao，所有直接使用这个方法；这里就是装车
              pst =getCon().prepareStatement(sql);
              rs = pst.executeQuery();
             while(rs.next()){
                Information infos = new Information();
                infos.setQuestionId(rs.getInt("questionId"));
                infos.setQuestion(rs.getString("question"));
                infos.setOptionA(rs.getString("optionA"));
                infos.setOptionB(rs.getString("optionB"));
                infos.setOptionC(rs.getString("optionC"));
                infos.setOptionD(rs.getString("optionD"));
                infos.setSubject(rs.getInt("subject"));
                infos.setAnswer(rs.getString("answer"));
                list.add(infos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        } catch (Exception e) {
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close();
        }
          return list; 
      }
      public List<Information> selectKemu(int subject){
          List<Information> list = new ArrayList<Information>();
          String sql ="SELECT * FROM exam WHERE SUBJECT=?";
          try {
           pst = getCon().prepareStatement(sql);
           pst.setInt(1, subject);//给打问号的地方设置值，一个问号就在这里设置一个值。多个就用while循环!!
           rs =pst.executeQuery();
           while(rs.next()){
               Information infos = new Information();
               infos.setQuestionId(rs.getInt("questionId"));
               infos.setQuestion(rs.getString("question"));
               infos.setOptionA(rs.getString("optionA"));
               infos.setOptionB(rs.getString("optionB"));
               infos.setOptionC(rs.getString("optionC"));
               infos.setOptionD(rs.getString("optionD"));
               infos.setSubject(rs.getInt("subject"));
               infos.setAnswer(rs.getString("answer"));
               list.add(infos);
           }
        } catch (SQLException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        } catch (Exception e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close();
        }
          return list;
      }
      public List<Information> selectTg(String tigan){
          String sql = "SELECT * FROM exam WHERE question LIKE ?";
          List<Information> list = new ArrayList<Information>();
          try {
            pst = getCon().prepareStatement(sql);
            pst.setString(1, "%"+tigan+"%");
            rs = pst.executeQuery();
            while(rs.next()){
                Information infos = new Information();
                infos.setQuestionId(rs.getInt("questionId"));
                infos.setQuestion(rs.getString("question"));
                infos.setOptionA(rs.getString("optionA"));
                infos.setOptionB(rs.getString("optionB"));
                infos.setOptionC(rs.getString("optionC"));
                infos.setOptionD(rs.getString("optionD"));
                infos.setSubject(rs.getInt("subject"));
                infos.setAnswer(rs.getString("answer"));
                list.add(infos);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
          return list;
      }
      public int addtimu(Information infos){
          String sql = "INSERT INTO exam(question,optionA,optionB,optionC,optionD,SUBJECT,answer) VALUES(?,?,?,?,?,?,?)";
          int temp = 0;
          try {
            pst = getCon().prepareStatement(sql);
            Object[] obj = new Object[7];
            obj[0]=infos.getQuestion();
            obj[1]=infos.getOptionA();
            obj[2]=infos.getOptionB();
            obj[3]=infos.getOptionC();
            obj[4]=infos.getOptionD();
            obj[5]=infos.getSubject();
            obj[6]=infos.getAnswer();
            for (int i = 0; i < obj.length; i++) {
              pst.setObject(i+1, obj[i]);
          }
            temp = pst.executeUpdate();
            if (temp>=1) {
                System.out.println("添加成功！");
            }else {
                System.out.println("添加失败!");
            }
        } catch (Exception e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close();
        }
          return temp;
          
      }
      public int deleteTimu(int dele){
          int temp =0;
          String sql ="DELETE FROM exam WHERE questionId=?";
          try {
            pst = getCon().prepareStatement(sql);
            pst.setInt(1, dele);
            temp = pst.executeUpdate();
            if (temp>=1) {
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
            }
        } catch (Exception e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }finally{
            close();
        }
          return temp;
      }
}

