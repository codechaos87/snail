/**
 * Project Name:wangguojun
 * File Name:Test.java
 * Package Name:dao
 * Date:2018年3月28日下午6:42:08
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.wangguojun.dao;

import java.util.List;
import java.util.Scanner;

import m03.d28.wangguojun.entity.QuestionInfo;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午6:42:08 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        Dao bizDao = new daoimpl();
        System.out.println("************进入系统************");
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------");
        QuestionInfo info = new QuestionInfo();
        System.out.println("请输入要修改的编号：");

        List<m03.d28.wangguojun.entity.QuestionInfo> lists = bizDao.getAllQuestionInfo();
        for (m03.d28.wangguojun.entity.QuestionInfo ff : lists) {
            System.err.println(ff.getQuestionId() + "\t" + ff.getQuestion() + "\t" + ff.getOptionA() + "\t"
                    + ff.getOptionB() + "\t" + ff.getOptionC() + "\t" + ff.getOptionD() + "\t" + ff.getAnswer());
        }

    }

}

