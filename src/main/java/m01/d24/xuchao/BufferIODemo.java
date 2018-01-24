/**
 * Project Name:dt59lesson
 * File Name:Homework2.java
 * Package Name:hm20180105
 * Date:2018年1月7日下午12:36:15
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d24.xuchao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Description: <br/>
 * Date: 2018年1月7日 下午12:36:15 <br/>
 * 
 * @author chaos
 * @version
 * @see
 */
public class BufferIODemo {
    private static final Logger LOG = Logger.getLogger(BufferIODemo.class);

    public static void main(String[] args) {

        BufferedReader bufr = null;
        BufferedWriter bufw = null;
        try {
            bufr = new BufferedReader(
                    new FileReader("D:\\git\\dt59lesson\\src\\main\\java\\hm20180106\\Homework1.java"));
            bufw = new BufferedWriter(new FileWriter(
                    "D:\\git\\dt59lesson\\src\\main\\java\\hm20180106\\Homework1_copy.txt"));
            String line = null;
            while ((line = bufr.readLine()) != null) {
                bufw.write(line);
                bufw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufw != null) {
                try {
                    bufw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufr != null) {
                try {
                    LOG.info("文件拷贝成功");
                    bufr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                LOG.info("文件拷贝失败");
            }
        }
    }
}
