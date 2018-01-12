/**
 * Project Name:snail

 * File Name:SocketDemo.java
 * Package Name:m01d10wangguojun
 * Date:2018年1月10日下午11:14:36
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.wangguojun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午11:14:36 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class SocketDemo {

    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("上传文本信息。。。");
        // 1客户端
        Socket s = new Socket("127.0.0.1", 1005);
        // 确定本地文件
        BufferedReader bufr = new BufferedReader(new FileReader("F:\\新建文本文档.txt"));
        // 2确定socket输出
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String line=null;
        while ((line = bufr.readLine()) != null) {
            out.println(line);
        }
        // 给服务端标记
        out.print("over");
        // 3通过socket读取服务端数据
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // 关
        String lineIn = bufIn.readLine();
        System.out.println(lineIn);
        bufIn.close();
        bufr.close();
        s.close();
    }

}

