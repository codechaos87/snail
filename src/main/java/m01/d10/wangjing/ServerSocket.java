/**
 * Project Name:snail
 * File Name:ServerSocket.java
 * Package Name:m01.d10.wangjing
 * Date:2018年1月10日下午6:57:21
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.wangjing;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午6:57:21 <br/>
 * 
 * @author wangJing
 * @version
 * @see
 */
public class ServerSocket {

    public static void main(String[] args) {

        try {
            java.net.ServerSocket serversocket = new java.net.ServerSocket(7573);
            System.out.println("等待客户端连接。。。");
            Socket fileLoaderSocket = serversocket.accept();// 接收客户端连接
            System.out.println("连接成功可以通信");
            // 收消息
            // 获取输入流读文件
            InputStream is = fileLoaderSocket.getInputStream();
            OutputStream fileSave = new FileOutputStream("d:\\TEST\\wangjing.txt");
            int len = 0;
            byte[] bs = new byte[1024];
            while ((len = is.read(bs)) != -1) {// 确保流中有数据
                fileSave.write(bs, 0, len);
                fileSave.flush();
            }
            is.read(bs);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fileLoaderSocket.getOutputStream()));
            out.write("文件上传成功");
            out.flush();
            // String rinfo = new String(bs);
            // System.out.println("服务器接收客户端的消息：" + rinfo);
            // 释放资源
            is.close();
            fileLoaderSocket.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
