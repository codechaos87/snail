/**
 * Project Name:wangguojun
 * File Name:QuestionInfo.java
 * Package Name:entity
 * Date:2018年3月28日下午4:05:15
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.wangguojun.entity;
/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午4:05:15 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class QuestionInfo {
    private int questionId;

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String subject;

    private String answer;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String i) {
        this.subject = i;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

