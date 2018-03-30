/**
 * Project Name:snail
 * File Name:ServerDemo.java
 * Package Name:m01.d10.tianyongxu
 * Date:2018年1月11日下午2:29:07
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.tianyongxu;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午8:18:54 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class ServerDemo {
    private final static Logger LOG = Logger.getLogger(ServerDemo.class);
    public static void main(String[] args) {
        try {
            //先创建服务
            File file = new File("F:\\tian.txt");
            FileOutputStream fos = new FileOutputStream(file);
            //*********************************
            ServerSocket serverSocket = new ServerSocket(2995);
            System.out.println("等待来连接");
            Socket socket=serverSocket.accept();
            InputStream is=socket.getInputStream();
            int len=0;
            int i=1;
            while(len==0){
                len=is.available();
                LOG.info(i+len);
                i++;
            }
            byte[] b = new byte[is.available()];
            is.read(b);
            fos.write(b);
            //String str = new String(b);
            //System.out.println(str);
            //System.out.println("我们联通了");
            is.close();
            socket.close();
            serverSocket.close();
            fos.close();
        } catch (IOException e) {
            
            //  Auto-generated catch block
            e.printStackTrace();
            
        }

    }

}

