/**
 * Project Name:snail
 * File Name:QuestionInfoDaoImpl.java
 * Package Name:m03.d28.chenyang
 * Date:2018年3月28日下午6:52:22
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.chenyang;

import java.util.List;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午6:52:22 <br/>
 * @author   chenyang
 * @version
 * @see
 */
public class QuestionInfoDaoImpl extends BaseDao implements QuestionInfoDao {

    @Override
    public List<QuestionInfo> getALLInfo() {
        
        //  Auto-generated method stub
        String str = "SELECT * FROM question_info";
        return super.executeQueryList(QuestionInfo.class, str);
    }

    @Override
    public List<QuestionInfo> selectS(int subject) {
        
        //  Auto-generated method stub
        String str = "SELECT * FROM question_info WHERE SUBJECT=?";
        return super.executeQueryList(QuestionInfo.class,str,subject);
    }

    @Override
    public QuestionInfo selectQ(int questionId) {
        
        //  Auto-generated method stub
        String str = "SELECT * FROM question_info WHERE questionId=?";
        return super.executeQueryOne(QuestionInfo.class, str, questionId);
    }

    @Override
    public int delectQ(int questionId) {
        
        //  Auto-generated method stub
        String str = "DELETE FROM question_info WHERE questionId=?";
        return super.executeUpdate(str, questionId);
    }

    @Override
    public int saveQ(QuestionInfo question) {
        
        //  Auto-generated method stub
        String str = "INSERT INTO question_info(question,optionA,optionB,optionC,optionD,SUBJECT,answer) VALUES(?,?,?,?,?,?,?);";
        return  super.executeUpdate(str, question.getQuestion(),
                question.getOptionA(),question.getOptionB(),question.getOptionC(),
                question.getOptionD(),question.getSubject(),question.getAnswer());
    }

    @Override
    public List<QuestionInfo> mohu(String str) {
        
        //  Auto-generated method stub
        String st = "SELECT * FROM question_info WHERE question LIKE '%'||?||'%'";
        return super.executeQueryList(QuestionInfo.class,st,str);
    }

}

