/**
 * Project Name:snail
 * File Name:SocketDemo.java
 * Package Name:m01.d10.tianyongxu
 * Date:2018年1月11日下午2:27:41
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.tianyongxu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Description:   <br/>
 * Date:     2018年1月10日 下午8:23:09 <br/>
 * @author   tianyongxu
 * @version
 * @see
 */
public class SocketDemo {

    public static void main(String[] args) {
        try {
            //创建新的客户端
            File file = new File("D:\\留言板.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] by = new byte[fis.available()];
            fis.read(by);
            Socket socket = new Socket(InetAddress.getLoopbackAddress(), 10000);
            OutputStream os = socket.getOutputStream();
            //String str ="用户名：admin 密码：123";
            os.write(by);;
            System.out.println("服务器连接到我了");
            os.close();
            socket.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }

}