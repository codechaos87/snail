/**
 * Project Name:snail
 * File Name:Test.java
 * Package Name:m03.d28.guojin
 * Date:2018年3月28日下午4:25:52
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m03.d28.guojin;

import java.util.List;
import java.util.Scanner;

/**
 * Description: <br/>
 * Date: 2018年3月28日 下午4:25:52 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        QuestionInfoDao qd = new QuestionInfoDaoImpl();
        List<QuestionInfo> list = qd.getAllInfo();
        while (true) {
            Scanner sc = new Scanner(System.in);
            // Auto-generated method stub
            System.out.println("请选择操作（1.列出所有试题 2.按科目查询 3.按题干模糊查询 4.添加试题 5.删除试题 6.退出系统：）");
            int input = sc.nextInt();

            switch (input) {
            case 1:

                for (QuestionInfo ff : list) {
                    System.out.println(ff.getQuestionId() + "、" + ff.getQuestion() + "\n" + ff.getOptionA() + "\n"
                            + ff.getOptionB() + "\n" + ff.getOptionC() + "\n" + ff.getOptionD() + "\n" + "答案:"
                            + ff.getAnswer());
                }
                break;
            case 2: {
                System.out.println("请输入科目：（1.Java 2.C# 3.JSP）");
                int input1 = sc.nextInt();
                switch (input1) {
                case 1:
                    QuestionInfoDao qd1 = new QuestionInfoDaoImpl();
                    List<QuestionInfo> list1 = qd1.getSubject1();
                    for (QuestionInfo ff : list1) {
                        System.out.println(ff.getQuestionId() + "、" + ff.getQuestion() + "\n" + ff.getOptionA() + "\n"
                                + ff.getOptionB() + "\n" + ff.getOptionC() + "\n" + ff.getOptionD() + "\n" + "答案:"
                                + ff.getAnswer());
                    }
                    break;
                case 2: {
                    QuestionInfoDao qd2 = new QuestionInfoDaoImpl();
                    List<QuestionInfo> list2 = qd2.getSubject2();
                    for (QuestionInfo ff : list2) {
                        System.out.println(ff.getQuestionId() + "、" + ff.getQuestion() + "\n" + ff.getOptionA() + "\n"
                                + ff.getOptionB() + "\n" + ff.getOptionC() + "\n" + ff.getOptionD() + "\n" + "答案:"
                                + ff.getAnswer());
                    }
                }
                case 3: {
                    QuestionInfoDao qd2 = new QuestionInfoDaoImpl();
                    List<QuestionInfo> list2 = qd2.getSubject3();
                    for (QuestionInfo ff : list2) {
                        System.out.println(ff.getQuestionId() + "、" + ff.getQuestion() + "\n" + ff.getOptionA() + "\n"
                                + ff.getOptionB() + "\n" + ff.getOptionC() + "\n" + ff.getOptionD() + "\n" + "答案:"
                                + ff.getAnswer());
                    }
                }
                    break;
                default:
                    break;
                }
            }
                break;
            case 3: {
                System.out.println("请输入题干：");
                String str = sc.next();
                if (str.equals("变量名")) {

                    for (QuestionInfo ff : list) {
                        System.out.println(ff.getQuestionId() + "、" + ff.getQuestion() + "\n" + ff.getOptionA() + "\n"
                                + ff.getOptionB() + "\n" + ff.getOptionC() + "\n" + ff.getOptionD() + "\n" + "答案:"
                                + ff.getAnswer());
                    }
                } else {
                    System.out.println("请输入正确的题干");
                }
            }
                break;

            case 4: {
                QuestionInfo info = new QuestionInfo();
                System.out.println("请输入科目：（1.Java 2.C# 3.JSP）");
                info.setSubject(sc.nextInt());
                System.out.println("请输入新的题干：");
                info.setQuestion(sc.next());
                System.out.println("请输入新的选项A：");
                info.setOptionA(sc.next());
                System.out.println("请输入新的选项B：");
                info.setOptionB(sc.next());
                System.out.println("请输入新的选项C：");
                info.setOptionC(sc.next());
                System.out.println("请输入新的选项D：");
                info.setOptionD(sc.next());
                System.out.println("请输入新的答案：");
                info.setAnswer(sc.next());
                int falg = qd.updateInfo(info);
                if (falg > 0) {
                    System.out.println("添加成功");
                } else {
                    System.out.println("添加失败");
                }
            }
                break;
            case 5: {
                System.out.println("请输入需要删除的试题编号：");
                int id = sc.nextInt();
                int flag = qd.deleteInfo(id);
                if (flag > 7) {
                    System.out.println("删除失败");
                } else {
                    System.out.println("删除成功");
                }
            }
                break;
            case 6: {
                System.out.println("退出成功");
            }
                break;
            default: {
                System.out.println("请输入正确的编号");
            }
                break;
            }

        }
    }
}
