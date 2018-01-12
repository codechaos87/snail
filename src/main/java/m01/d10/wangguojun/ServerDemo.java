/**
 * Project Name:snail
 * File Name:SeverDemo.java
 * Package Name:m01.d10.wangguojun
 * Date:2018年1月11日上午12:05:52
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.wangguojun;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:   <br/>
 * Date:     2018年1月11日 上午12:05:52 <br/>
 * @author   wangguojun
 * @version
 * @see
 */
public class ServerDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("启动服务端。。。");
        // 1服务端对象
        ServerSocket ss = new ServerSocket(1005);
        // 2获取客户端
        Socket s = ss.accept();
        // 3获取流
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        // 4确定文件
        PrintWriter pw = new PrintWriter(new FileWriter("F:\\新建文本文档1.txt.txt"), true);
        //5读写
        String line=null;
        while ((line = bufIn.readLine()) != null) {
            if ("over".equals(line))
                break;
            pw.print(line);
        }

        // 6给客户端返回信息
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.print("上传成功");
            pw.close();
            s.close();
            ss.close();

    }

}

