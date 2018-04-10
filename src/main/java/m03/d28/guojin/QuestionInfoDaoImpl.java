/**
 * Project Name:snail
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:m03.d28.guojin
 * Date:2018年3月28日下午4:37:00
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.guojin;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午4:37:00 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    @Override
    public List<QuestionInfo> getAllInfo() {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info1";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    @Override
    public int updateInfo(Object t) {

        int flag = 0;
        try {
            String sql = "insert into question_info1 (question,optionA,optionB,optionC,optionD,subjecta,answer) values (?,?,?,?,?,?,?)";
            Object[] obj = new Object[7];
            if (t instanceof QuestionInfo) {
                QuestionInfo ff = (QuestionInfo) t;
                obj[0] = ff.getQuestion();
                obj[1] = ff.getOptionA();
                obj[2] = ff.getOptionB();
                obj[3] = ff.getOptionC();
                obj[4] = ff.getOptionD();
                obj[5] = ff.getSubject();
                obj[6] = ff.getAnswer();

            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteInfo(int id) {

        int flag = 0;
        try {
            String sql = "DELETE FROM question_info1 WHERE questionId=?";
            Object[] obj = new Object[1];
            obj[0] = id;
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<QuestionInfo> getSubject1() {
        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info1 WHERE subjecta=1";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;

    }

    @Override
    public List<QuestionInfo> getSubject2() {

        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info1 WHERE subjecta=2";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;

    }

    @Override
    public List<QuestionInfo> getAllInfo1() {

        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info1  WHERE question LIKE '%变量名%'";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

    @Override
    public List<QuestionInfo> getSubject3() {

        List<QuestionInfo> list = new ArrayList<QuestionInfo>();
        try {
            String sql = "SELECT * FROM question_info1 WHERE subjecta=3";
            pst = getCon().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                QuestionInfo ff = new QuestionInfo();
                ff.setQuestionId(rs.getInt(1));
                ff.setQuestion(rs.getString(2));
                ff.setOptionA(rs.getString(3));
                ff.setOptionB(rs.getString(4));
                ff.setOptionC(rs.getString(5));
                ff.setOptionD(rs.getString(6));
                ff.setSubject(rs.getInt(7));
                ff.setAnswer(rs.getString(8));
                list.add(ff);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            close(con, pst, rs);
        }
        return list;
    }

}
