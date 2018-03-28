/**
 * Project Name:DT59Team5
 * File Name:Question.java
 * Package Name:m03.d28.xuchao.entity
 * Date:2018年3月28日下午1:33:39
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.xuchao.entity;

import java.io.Serializable;

/**
 * Description:   实体类 当作仓库<br/>
 * Date:     2018年3月28日 下午1:33:39 <br/>
 * @author   chaos
 * @version
 * @see
 */
public class QuestionInfo implements Serializable {
    /**
     * serialVersionUID:支持序列化 可将对象转化成字节序列而保存在磁盘上或在网络上传输
     */
    private static final long serialVersionUID = 190929817846694163L;
    
    private int questionId;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int qsubject;
    private String answer;
    //空参构造器
    public QuestionInfo() {}
    //有参构造器
    public QuestionInfo(String question, String optionA, String optionB, String optionC, String optionD,
            int qsubject, String answer) {
        super();
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.qsubject = qsubject;
        this.answer = answer;
    }
    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getOptionA() {
        return optionA;
    }
    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }
    public String getOptionB() {
        return optionB;
    }
    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }
    public String getOptionC() {
        return optionC;
    }
    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }
    public String getOptionD() {
        return optionD;
    }
    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }
    public int getQsubject() {
        return qsubject;
    }
    public void setQsubject(int qsubject) {
        this.qsubject = qsubject;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
}

