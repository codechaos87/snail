/**
 * Project Name:dt59homework.guojin
 * File Name:Test.java
 * Package Name:lesson20180111
 * Date:2018年1月10日下午4:18:42
 * Copyright (c) 2018, bluemobi All Rights Reserved.
 */

package m01.d10.guojin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Description: <br/>
 * Date: 2018年1月10日 下午4:18:42 <br/>
 * 
 * @author GUO
 * @version
 * @see
 */
public class Test {

    public static void main(String[] args) {
        Socket so = null;
        File file = new File("D:\\逻辑测试\\timg.jfif");
        OutputStream out = null;
        FileInputStream put = null;

        try {
            so = new Socket(InetAddress.getByName("192.168.80.25"), 6666);
            put = new FileInputStream(file);
            out = so.getOutputStream();

            byte[] by = new byte[1024];
            int len = put.read(by);
            while (len != -1) {
                out.write(by, 0, len);
                len = put.read(by);
            }

        } catch (UnknownHostException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {

            // Auto-generated catch block
            e.printStackTrace();

        } finally {
            if (so != null) {
                try {
                    so.close();
                } catch (IOException e) {

                    // Auto-generated catch block
                    e.printStackTrace();

                }
            }
        }

        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {

                // Auto-generated catch block
                e.printStackTrace();

            }

        }
        print(so);
        print(put);

    }

    public static void print(java.io.Closeable socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {

                // Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
