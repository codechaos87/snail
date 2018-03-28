/**
 * Project Name:wangguojun
 * File Name:daoimpl.java
 * Package Name:dao
 * Date:2018年3月28日下午5:39:47
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.wangguojun.dao;

import java.util.ArrayList;
import java.util.List;

import m03.d28.wangguojun.entity.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午5:39:47 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class daoimpl extends BaseDao implements Dao {
    // 查询
    public List<m03.d28.wangguojun.entity.QuestionInfo> getAllQuestionInfo() {
        List<m03.d28.wangguojun.entity.QuestionInfo> lists = new ArrayList<QuestionInfo>();
        try {
            String sql="SELECT * FROM question_info;";
            pst=getCon().prepareStatement(sql);
            res=pst.executeQuery(sql);
            while(res.next()){
                m03.d28.wangguojun.entity.QuestionInfo ff = new m03.d28.wangguojun.entity.QuestionInfo();
                ff.setQuestionId(res.getInt(1));
                ff.setQuestion(res.getString(2));
                ff.setOptionA(res.getString(3));
                ff.setOptionB(res.getString(4));
                ff.setOptionC(res.getString(5));
                ff.setOptionD(res.getString(6));
                // ff.setSubject(res.getInt(7));
                ff.setAnswer(res.getString(8));
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            close(con, pst, res);
        }
        return lists;
        
    }

    @Override
    public int updateQuestionInfo(Object t) {
        int flag = 0;
        try {
            String sql = "UPDATE info SET question=?,optionA=?,optionB=?,optionC=?,optionD=?,answer=? WHERE id=?";
            Object[] obj = new Object[3];
            if (t instanceof QuestionInfo) {
                QuestionInfo ff = (QuestionInfo) t;// 向下转型
                obj[0] = ff.getQuestionId();
                obj[1] = ff.getQuestion();
                obj[2] = ff.getOptionA();
                obj[2] = ff.getOptionB();
                obj[2] = ff.getOptionC();
                obj[2] = ff.getOptionD();
                obj[2] = ff.getAnswer();
            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteQuestionInfo(int id) {

        int flag = 0;
        try {
            String sql = "DELETE FROM QuestionInfo WHERE id=?";
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
    public int saveInQuestionInfo(Object t) {

        int flag = 0;
        try {
            String sql = "INSERT INTO info2(NAME,birthday) VALUES(?,?)";
            Object[] obj = new Object[2];
            if (t instanceof QuestionInfo) {
                QuestionInfo ff = (QuestionInfo) t;
                obj[0] = ff.getQuestionId();
                obj[1] = ff.getQuestion();
                obj[2] = ff.getOptionA();
                obj[2] = ff.getOptionB();
                obj[2] = ff.getOptionC();
                obj[2] = ff.getOptionD();
                obj[2] = ff.getAnswer();
            }
            flag = controlDml(sql, obj);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return flag;
    }
}

