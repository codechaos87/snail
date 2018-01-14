/**
 * Project Name:snail
 * File Name:CientDemo.java
 * Package Name:m01.d10.wangjing
 * Date:2018年1月10日下午7:20:55
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.wangjing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午7:20:55 <br/>
 * 
 * @author wangJing
 * @version
 * @see
 */
public class CientDemo {

    public static void main(String[] args) {
        // 客户端代码

        try { // 创建socket对象
            Socket fileLoaderSocket = new Socket(InetAddress.getLocalHost(), 7573);
            // 写入流
            OutputStream os = fileLoaderSocket.getOutputStream();
            // 实例化对象fileReader
            InputStream fileRead = new FileInputStream("d:\\TEST2\\wangjing66.txt");
            byte[] bs = new byte[1024];
            int len = 0;
            while ((len = fileRead.read()) != -1) {
                os.write(bs, 0, len);
            }
            fileLoaderSocket.shutdownOutput();
            BufferedReader in = new BufferedReader(new InputStreamReader(fileLoaderSocket.getInputStream()));
            String serverBack = in.readLine();
            System.out.println(serverBack);

            // // 客户端给服务器发消息
            // String sinfo = "用户名是：王京；密码是：1234";
            // 写操作
            // os.write(sinfo.getBytes());
            // 关闭流
            os.close();

            fileRead.close();
            fileLoaderSocket.close();
            // System.out.println("连接服务器成功，我们中通信啦。。。");
        } catch (UnknownHostException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}
