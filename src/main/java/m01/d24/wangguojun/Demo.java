/**
 * Project Name:snail
 * File Name:Demo.java
 * Package Name:m01.d24.wangguojun
 * Date:2018年1月24日下午9:24:00
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.wangguojun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Description: <br/>
 * Date: 2018年1月24日 下午9:24:00 <br/>
 * 
 * @author wangguojun
 * @version
 * @see bufferedreader 用filereader进行加载文件？
 */
public class Demo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        FileReader fr = null;
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("F:\\新建文本文档.txt");
            br = new BufferedReader(fr);
            fw = new FileWriter("F:\\1.txt");
            bw = new BufferedWriter(fw);
            // 一行一行读，调用读的方法
            String str = br.readLine();
            while (str != null) {
                // 一边读一边写
                bw.write(str + "\r\n");
                str = br.readLine();
            }
            System.out.println("读写完成");

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            bw.close();
            fw.close();
            br.close();
            try {
                fr.close();
            } catch (IOException e) {

                // Auto-generated catch block
                e.printStackTrace();

            }
        }
    }
}