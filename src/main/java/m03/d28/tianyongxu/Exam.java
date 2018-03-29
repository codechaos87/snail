/**
 * Project Name:jdbc_01
 * File Name:Exam.java
 * Package Name:exam
 * Date:2018年3月28日下午5:18:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package exam;

import java.util.Scanner;

/**
 * Description:   <br/>
 * Date:     2018年3月28日 下午5:18:21 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class Exam {
        Scanner input = new Scanner(System.in);
        public void show(){
            System.out.println("*************欢迎使用试题管理系统***************");
            System.out.println("请选择操作(1.列出所有试题 2.按科目查询 3.按题干模糊查询  4.添加试题5.删除试题6.退出系统)");
            int key = input.nextInt();
            switch (key) {
            case 1:
                //显示所有试题的方法；
                selectAll();
                fanHui();
                break;
            case 2:
                //按科目查询的方法
                selectKemu();
                fanHui();
                break;
            case 3:
                //按题干模糊查询
                selectTigan();
                fanHui();
                break;
            case 4:
                //添加试题
                addTimu();
                fanHui();
                break;
            case 5:
               //删除试题
                deleteTimy();
                fanHui();
                break;
            case 6:
               //退出系统
                System.exit(1);
                break;
    
            }
        }
        public void selectAll(){//查询所有试题的方法
            
        }
        public void selectKemu(){//按科目查询
            
        }
        public void selectTigan(){//按题干模糊查询
            
        }
        public void addTimu(){//添加试题
            
        }
        public void deleteTimy(){//删除题目
            
        }
        public void fanHui(){//返回首页的方法
            System.out.println("输入0，返回首页");
            int key =input.nextInt();
            if (key==0) {
                show();
            }
        }

}

