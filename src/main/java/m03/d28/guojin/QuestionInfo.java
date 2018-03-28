/**
 * Project Name:snail
 * File Name:QuestionInfo.java
 * Package Name:m03.d28.guojin
 * Date:2018年3月28日下午4:01:53
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.guojin;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午4:01:53 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class QuestionInfo {
    private int QuestionId;

    private String question;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private int subjecta;

    private String answer;

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int questionId) {
        QuestionId = questionId;
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

    public int getSubject() {
        return subjecta;
    }

    public void setSubject(int subject) {
        this.subjecta = subject;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
