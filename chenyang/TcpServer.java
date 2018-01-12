/**
 * Project Name:snail
 * File Name:TcpServer.java
 * Package Name:m01.d10
 * Date:2018年1月11日下午12:42:40
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.chenyang;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:   <br/>
 * Date:     2018年1月11日 下午12:42:40 <br/>
 * @author   chenyang
 * @version
 * @see
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
       System.out.println("服务器端启动中...");
        ServerSocket ss = new ServerSocket(10008);
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"....连接上啦");
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Administrator\\Desktop\\zuoye\\server.java"),true);
        String line =null;
        while((line=bufIn.readLine())!=null){
            if("over".equals(line))
                break;
            pw.println(line);
         }   
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
            out.println("上传成功");
            pw.close();
            s.close();
            ss.close();
        
    }

}

